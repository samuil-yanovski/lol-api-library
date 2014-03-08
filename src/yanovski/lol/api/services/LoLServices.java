package yanovski.lol.api.services;

import java.util.UUID;

import retrofit.RestAdapter;
import yanovski.lol.api.callbacks.ChampionsCallback;
import yanovski.lol.api.callbacks.MasteryPagesCallback;
import yanovski.lol.api.callbacks.PlayerStatsSummaryCallback;
import yanovski.lol.api.callbacks.RankedStatsCallback;
import yanovski.lol.api.callbacks.RecentGamesCallback;
import yanovski.lol.api.callbacks.RunePagesCallback;
import yanovski.lol.api.callbacks.SimpleLeagueCallback;
import yanovski.lol.api.callbacks.SimpleLeagueEntriesCallback;
import yanovski.lol.api.callbacks.SimpleLeaguesCallback;
import yanovski.lol.api.callbacks.SummonerCallback;
import yanovski.lol.api.callbacks.SummonerNamesCallback;
import yanovski.lol.api.callbacks.TeamsCallback;
import yanovski.lol.api.callbacks.TeamsMapCallback;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class LoLServices {
	public static final String API_KEY_METADATA_NAME = "yanovski.lol.api.API_KEY";
	private static String RIOT_SERVICES_API_KEY = "";
	
	private static LoLServicesClient services;

	protected synchronized static LoLServicesClient getInstance() {
		if (null == services) {
			RestAdapter restAdapter = new RestAdapter.Builder().setServer(
					"http://prod.api.pvp.net").build();
			services = restAdapter.create(LoLServicesClient.class);
		}

		return services;
	}
	
	public static void init(Context context) {
		try {
			ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
			Bundle bundle = ai.metaData;
			RIOT_SERVICES_API_KEY = bundle.getString(API_KEY_METADATA_NAME);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getSummonerByName(String region, String name) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getSummonerByName(region, name, RIOT_SERVICES_API_KEY, new SummonerCallback(
				requestId));

		return requestId;
	}
	
	public static String getLeagueEntriesBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getLeagueEntriesBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY, new SimpleLeagueEntriesCallback(
				requestId));

		return requestId;
	}
	
	public static String getChallengerLeague(String region, String type) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getChallengerLeague(region, type, RIOT_SERVICES_API_KEY, new SimpleLeagueCallback(
				requestId));

		return requestId;
	}

	public static String getLeaguesBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getLeaguesBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY, new SimpleLeaguesCallback(
				requestId));

		return requestId;
	}

	public static String getChampions(String region, boolean freeToPlay) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getChampions(region, freeToPlay, RIOT_SERVICES_API_KEY,
				new ChampionsCallback(requestId));

		return requestId;
	}

	public static String getRecentGamesBySummnerId(String region,
			long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getRecentGamesBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new RecentGamesCallback(requestId));

		return requestId;
	}

	public static String getStatsBySummnerId(String region, long summonerId, String season) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getStatsBySummnerId(region, summonerId, season, RIOT_SERVICES_API_KEY,
				new PlayerStatsSummaryCallback(requestId));

		return requestId;
	}

	public static String getRandkedStatsBySummnerId(String region,
			long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getRandkedStatsBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new RankedStatsCallback(requestId));

		return requestId;
	}

	public static String getMasteriesBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getMasteriesBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new MasteryPagesCallback(requestId));

		return requestId;
	}

	public static String getSummonerBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getSummonerBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new SummonerCallback(requestId));

		return requestId;
	}

	public static String getSummonerNamesBySummnerId(String region,
			String summonerIds) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getSummonerNamesBySummnerId(region, summonerIds, RIOT_SERVICES_API_KEY,
				new SummonerNamesCallback(requestId));

		return requestId;
	}

	public static String getTeamsBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getTeamsBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new TeamsCallback(requestId));

		return requestId;
	}
	
	public static String getTeamsByTeamId(String region, String teamIds) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getTeamsByTeamId(region, teamIds, RIOT_SERVICES_API_KEY,
				new TeamsMapCallback(requestId));

		return requestId;
	}
	
	public static String getRunesBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getRunesBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new RunePagesCallback(requestId));

		return requestId;
	}
}
