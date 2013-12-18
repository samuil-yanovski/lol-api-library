package yanovski.lol.api.callbacks;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.MasteryPages;
import yanovski.lol.api.responses.MasteryPagesResponseNotification;

public class MasteryPagesCallback extends GenericCallback<MasteryPages> {

	public MasteryPagesCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<MasteryPages> createTypedResponse() {
		return new MasteryPagesResponseNotification();
	}
}
