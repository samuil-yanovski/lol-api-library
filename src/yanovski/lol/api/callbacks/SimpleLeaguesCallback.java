package yanovski.lol.api.callbacks;

import java.util.List;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.League;
import yanovski.lol.api.responses.LeaguesResponseNotification;

public class SimpleLeaguesCallback extends GenericCallback<List<League>> {

	public SimpleLeaguesCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<List<League>> createTypedResponse() {
		return new LeaguesResponseNotification();
	}
}
