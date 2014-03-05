package yanovski.lol.api.callbacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedString;
import yanovski.lol.api.messages.EventBusManager;
import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.Summoner;

public class SummonerCallback extends GenericCallback<Response> {

	public SummonerCallback(String requestId) {
		super(requestId);
	}

	@Override
	public void success(Response r, Response response) {
		ResponseNotification<List<Summoner>> notification = new ResponseNotification<List<Summoner>>();
		notification.requestId = requestId();
		notification.origin = r;
		
		
		try {
			InputStream in = r.getBody().in();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			StringBuilder total = new StringBuilder(in.available());
			String line;
			while ((line = br.readLine()) != null) {
			    total.append(line);
			}
			JSONObject json = new JSONObject(total.toString());
			JSONArray names = json.names();
			int length = names.length();
			GsonConverter converter = new GsonConverter(new Gson());
			
			List<Summoner> summoners = new ArrayList<Summoner>();
			for (int index = 0; index < length; ++index) {
				String name = names.getString(index);
				JSONObject current = json.optJSONObject(name);
				if (null != current) {
					Summoner s = (Summoner) converter.fromBody(new TypedString(current.toString()), Summoner.class);
					summoners.add(s);
				}
			}
			
			notification.data = summoners;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ConversionException e) {
			e.printStackTrace();
		}
		
		EventBusManager.post(notification);
	}
}
