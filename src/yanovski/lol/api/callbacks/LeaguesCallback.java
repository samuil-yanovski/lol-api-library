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

import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedString;
import yanovski.lol.api.messages.EventBusManager;
import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.League;
import yanovski.lol.api.responses.LeaguesResponseNotification;

import com.google.gson.Gson;

public class LeaguesCallback extends GenericCallback<Response> {

	public LeaguesCallback(String requestId) {
		super(requestId);
	}

	@Override
	public void success(Response r, Response response) {
		ResponseNotification<List<League>> notification = new LeaguesResponseNotification();
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
			
			List<League> leagues = new ArrayList<League>();
			for (int index = 0; index < length; ++index) {
				String name = names.getString(index);
				JSONObject current = json.optJSONObject(name);
				if (null != current) {
					League l = (League) converter.fromBody(new TypedString(current.toString()), League.class);
					leagues.add(l);
				}
			}
			
			notification.data = leagues;
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
