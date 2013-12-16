package yanovski.lol.api.models;

import java.util.List;

public class RankedStats {
	public long summonerId;
	public long modifyDate;
	public String modifyDateStr;
	public List<ChampionStats> champions;
}
