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
import yanovski.lol.api.messages.EventBusManager;
import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.SummonerName;
import yanovski.lol.api.models.SummonerNames;
import yanovski.lol.api.responses.SummonerNamesResponseNotification;

public class SummonerNamesCallback extends GenericCallback<Response> {

	public SummonerNamesCallback(String requestId) {
		super(requestId);
	}

	@Override
	public void success(Response r, Response response) {
		ResponseNotification<SummonerNames> notification = new SummonerNamesResponseNotification();
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
			JSONArray jsonNames = json.names();
			int length = jsonNames.length();
			
			SummonerNames summonerNames = new SummonerNames();
			List<SummonerName> n = new ArrayList<SummonerName>();
			for (int index = 0; index < length; ++index) {
				String id = jsonNames.getString(index);
				String name = json.getString(id);
				
				SummonerName sn = new SummonerName();
				sn.id = Long.parseLong(id);
				sn.name = name;
				
				n.add(sn);
			}
			
			summonerNames.summoners = n;
			notification.data = summonerNames;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		EventBusManager.post(notification);
	}
}
