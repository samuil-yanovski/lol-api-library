package yanovski.lol.api.messages;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class ResponseNotification<T> {
	public String requestId;
	public T data;
	public Response origin;
	public RetrofitError error;
}
