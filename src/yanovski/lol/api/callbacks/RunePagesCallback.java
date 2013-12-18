package yanovski.lol.api.callbacks;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.RunePages;
import yanovski.lol.api.responses.RunePagesResponseNotification;

public class RunePagesCallback extends GenericCallback<RunePages> {

	public RunePagesCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<RunePages> createTypedResponse() {
		return new RunePagesResponseNotification();
	}
}
