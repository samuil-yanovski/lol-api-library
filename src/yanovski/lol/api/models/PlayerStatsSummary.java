package yanovski.lol.api.models;

import java.util.List;

public class PlayerStatsSummary {
	public List<AggregatedStat> aggregatedStats;
	public int wins;
	public int losses;
	public long modifyDate;
	public String modifyDateStr;
	public String playerStatSummaryType;
}
