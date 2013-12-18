package yanovski.lol.api.callbacks;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.RecentGames;
import yanovski.lol.api.responses.RecentGamesResponseNotification;

public class RecentGamesCallback extends GenericCallback<RecentGames> {

	public RecentGamesCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<RecentGames> createTypedResponse() {
		return new RecentGamesResponseNotification();
	}
}
