package yanovski.lol.api.callbacks;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.Summoner;
import yanovski.lol.api.responses.SummonerResponseNotification;

public class SummonerCallback extends GenericCallback<Summoner> {

	public SummonerCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<Summoner> createTypedResponse() {
		return new SummonerResponseNotification();
	}
}
