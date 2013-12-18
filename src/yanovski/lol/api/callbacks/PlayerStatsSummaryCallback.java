package yanovski.lol.api.callbacks;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.PlayerStatsSummaryList;
import yanovski.lol.api.responses.PlayerStastsSummaryResponseNotification;

public class PlayerStatsSummaryCallback extends GenericCallback<PlayerStatsSummaryList> {

	public PlayerStatsSummaryCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<PlayerStatsSummaryList> createTypedResponse() {
		return new PlayerStastsSummaryResponseNotification();
	}
}
