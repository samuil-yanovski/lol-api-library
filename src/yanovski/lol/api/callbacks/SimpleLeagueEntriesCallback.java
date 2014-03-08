package yanovski.lol.api.callbacks;

import java.util.List;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.LeagueItem;
import yanovski.lol.api.responses.LeagueEntriesResponseNotification;

public class SimpleLeagueEntriesCallback extends GenericCallback<List<LeagueItem>> {

	public SimpleLeagueEntriesCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<List<LeagueItem>> createTypedResponse() {
		return new LeagueEntriesResponseNotification();
	}
}
