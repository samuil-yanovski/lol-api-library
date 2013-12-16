package yanovski.lol.api.models;

import java.util.List;

public class Game {
	public int championId;
	public long createDate;
	public String createDateStr;
	public List<Player> fellowPlayers;
	public long gameId;
	public String gameMode;
	public String gameType;
	public boolean invalid;
	public int level;
	public int mapId;
	public int spell1;
	public int spell2;
	public List<RawStat> statistics;
	public String subType;
	public int teamId;
}
