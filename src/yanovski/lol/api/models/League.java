package yanovski.lol.api.models;

import java.util.List;

public class League {
	public long timestamp;
	public String queue;
	public String name;
	public String tier;
	public List<LeagueItem> entries;
}
