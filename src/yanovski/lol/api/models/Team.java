package yanovski.lol.api.models;

import java.util.List;

public class Team {
	public String createDate;
	public String lastGameDate;
	public String lastJoinDate;
	public String lastJoinedRankedTeamQueueDate;
	public List<MatchHistorySummary> matchHistory;
	public MessageOfDay messageOfDay;
	public String modifyDate;
	public String name;
	public Roster roster;
	public String secondLastJoinDate;
	public String status;
	public String tag;
	public TeamId teamId;
	public TeamStatSummary teamStatSummary;
	public String thirdLastJoinDate;
	public long timestamp;
}
