package yanovski.lol.api.callbacks;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.ChampionList;
import yanovski.lol.api.responses.ChampionsResponseNotification;

public class ChampionsCallback extends GenericCallback<ChampionList> {

	public ChampionsCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<ChampionList> createTypedResponse() {
		return new ChampionsResponseNotification();
	}
}
