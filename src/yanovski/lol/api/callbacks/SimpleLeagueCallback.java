package yanovski.lol.api.callbacks;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.League;
import yanovski.lol.api.responses.LeagueResponseNotification;

public class SimpleLeagueCallback extends GenericCallback<League> {

	public SimpleLeagueCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<League> createTypedResponse() {
		return new LeagueResponseNotification();
	}
}
