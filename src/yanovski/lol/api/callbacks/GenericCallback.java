package yanovski.lol.api.callbacks;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import yanovski.lol.api.messages.EventBusManager;
import yanovski.lol.api.messages.ResponseNotification;

public class GenericCallback<T> implements Callback<T> {
	
	private String requestId;
	
	public String requestId() {
		return requestId;
	}
	
	public GenericCallback(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public void failure(RetrofitError error) {
		ResponseNotification<T> notification = new ResponseNotification<T>();
		notification.requestId = requestId;
		notification.error = error;
		
		EventBusManager.post(notification);
	}

	@Override
	public void success(T data, Response r) {
		ResponseNotification<T> notification = new ResponseNotification<T>();
		notification.requestId = requestId;
		notification.data = data;
		notification.origin = r;
		
		EventBusManager.post(notification);
	}

}
