package yanovski.lol.api.callbacks;

import java.util.List;

import yanovski.lol.api.messages.ResponseNotification;
import yanovski.lol.api.models.Team;
import yanovski.lol.api.responses.TeamsResponseNotification;

public class TeamsCallback extends GenericCallback<List<Team>> {

	public TeamsCallback(String requestId) {
		super(requestId);
	}

	@Override
	protected ResponseNotification<List<Team>> createTypedResponse() {
		return new TeamsResponseNotification();
	}
}
