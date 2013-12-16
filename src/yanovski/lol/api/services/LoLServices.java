package yanovski.lol.api.services;

import java.util.List;
import java.util.UUID;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

import retrofit.RestAdapter;
import yanovski.lol.api.callbacks.GenericCallback;
import yanovski.lol.api.callbacks.LeaguesCallback;
import yanovski.lol.api.models.ChampionList;
import yanovski.lol.api.models.MasteryPages;
import yanovski.lol.api.models.PlayerStatsSummaryList;
import yanovski.lol.api.models.RankedStats;
import yanovski.lol.api.models.RecentGames;
import yanovski.lol.api.models.RunePages;
import yanovski.lol.api.models.Summoner;
import yanovski.lol.api.models.SummonerNames;
import yanovski.lol.api.models.Team;

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
		instance.getSummonerByName(region, name, RIOT_SERVICES_API_KEY, new GenericCallback<Summoner>(
				requestId));

		return requestId;
	}

	public static String getLeaguesBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getLeaguesBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY, new LeaguesCallback(
				requestId));

		return requestId;
	}

	public static String getChampions(String region, boolean freeToPlay) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getChampions(region, freeToPlay, RIOT_SERVICES_API_KEY,
				new GenericCallback<ChampionList>(requestId));

		return requestId;
	}

	public static String getRecentGamesBySummnerId(String region,
			long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getRecentGamesBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new GenericCallback<RecentGames>(requestId));

		return requestId;
	}

	public static String getStatsBySummnerId(String region, long summonerId, String season) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getStatsBySummnerId(region, summonerId, season, RIOT_SERVICES_API_KEY,
				new GenericCallback<PlayerStatsSummaryList>(requestId));

		return requestId;
	}

	public static String getRandkedStatsBySummnerId(String region,
			long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getRandkedStatsBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new GenericCallback<RankedStats>(requestId));

		return requestId;
	}

	public static String getMasteriesBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getMasteriesBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new GenericCallback<MasteryPages>(requestId));

		return requestId;
	}

	public static String getSummonerBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getSummonerBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new GenericCallback<Summoner>(requestId));

		return requestId;
	}

	public static String getSummonerNamesBySummnerId(String region,
			String summonerIds) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getSummonerNamesBySummnerId(region, summonerIds, RIOT_SERVICES_API_KEY,
				new GenericCallback<SummonerNames>(requestId));

		return requestId;
	}

	public static String getTeamsBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getTeamsBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new GenericCallback<List<Team>>(requestId));

		return requestId;
	}
	
	public static String getRunesBySummnerId(String region, long summonerId) {
		String requestId = UUID.randomUUID().toString();

		LoLServicesClient instance = getInstance();
		instance.getRunesBySummnerId(region, summonerId, RIOT_SERVICES_API_KEY,
				new GenericCallback<RunePages>(requestId));

		return requestId;
	}
}
