package yanovski.lol.api.callbacks;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.SummonerNames;
import yanovski.lol.api.responses.SummonerNamesResponseNotification;

public class SummonerNamesCallback extends GenericCallback<SummonerNames> {

	public SummonerNamesCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<SummonerNames> createTypedResponse() {
		return new SummonerNamesResponseNotification();
	}
}
