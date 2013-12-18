package yanovski.lol.api.callbacks;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.RankedStats;
import yanovski.lol.api.responses.RankedStatsResponseNotification;

public class RankedStatsCallback extends GenericCallback<RankedStats> {

	public RankedStatsCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<RankedStats> createTypedResponse() {
		return new RankedStatsResponseNotification();
	}
}
