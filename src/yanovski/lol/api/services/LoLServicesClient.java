package yanovski.lol.api.services;

import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import yanovski.lol.api.models.ChampionList;
import yanovski.lol.api.models.League;
import yanovski.lol.api.models.LeagueItem;
import yanovski.lol.api.models.PlayerStatsSummaryList;
import yanovski.lol.api.models.RankedStats;
import yanovski.lol.api.models.RecentGames;
import yanovski.lol.api.models.Team;

/**
 * Created by Intuitiv-01 on 13-12-11.
 */
public interface LoLServicesClient {
    @GET("/api/lol/{region}/v1.3/summoner/by-name/{name}")
    void getSummonerByName(@Path("region") String region, @Path("name") String name, @Query("api_key") String apiKey, Callback<Response> callback);
          
    @GET("/api/lol/{region}/v2.3/league/challenger")
    void getChallengerLeague(@Path("region") String region, @Query("type") String type, @Query("api_key") String apiKey, Callback<League> callback);
    
    @GET("/api/lol/{region}/v2.3/league/by-summoner/{summonerId}/entry")
    void getLeagueEntriesBySummnerId(@Path("region") String region, @Path("summonerId") long summonerId, @Query("api_key") String apiKey, Callback<List<LeagueItem>> callback);
    
    @GET("/api/lol/{region}/v2.3/league/by-summoner/{summonerId}")
    void getLeaguesBySummnerId(@Path("region") String region, @Path("summonerId") long summonerId, @Query("api_key") String apiKey, Callback<List<League>> callback);
    
    @GET("/api/lol/{region}/v1.1/champion")
    void getChampions(@Path("region") String region, @Query("freeToPlay") boolean freeToPlay, @Query("api_key") String apiKey, Callback<ChampionList> callback);
    
    @GET("/api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    void getRecentGamesBySummnerId(@Path("region") String region, @Path("summonerId") long summonerId, @Query("api_key") String apiKey, Callback<RecentGames> callback);
    
    @GET("/api/lol/{region}/v1.2/stats/by-summoner/{summonerId}/summary")
    void getStatsBySummnerId(@Path("region") String region, @Path("summonerId") long summonerId, @Query("region") String season, @Query("api_key") String apiKey, Callback<PlayerStatsSummaryList> callback);
    
    @GET("/api/lol/{region}/v1.2/stats/by-summoner/{summonerId}/ranked")
    void getRandkedStatsBySummnerId(@Path("region") String region, @Path("summonerId") long summonerId, @Query("api_key") String apiKey, Callback<RankedStats> callback);
    
    @GET("/api/lol/{region}/v1.3/summoner/{summonerId}/masteries")
    void getMasteriesBySummnerId(@Path("region") String region, @Path("summonerId") long summonerId, @Query("api_key") String apiKey, Callback<Response> callback);
    
    @GET("/api/lol/{region}/v1.1/summoner/{summonerId}")
    void getSummonerBySummnerId(@Path("region") String region, @Path("summonerId") long summonerId, @Query("api_key") String apiKey, Callback<Response> callback);
    
    @GET("/api/lol/{region}/v1.3/summoner/{summonerIds}/name")
    void getSummonerNamesBySummnerId(@Path("region") String region, @Path("summonerIds") String summonerIds, @Query("api_key") String apiKey, Callback<Response> callback);
           
    @GET("/api/lol/{region}/v2.2/team/{teamIds}")
    void getTeamsByTeamId(@Path("region") String region, @Path("teamIds") String teamIds, @Query("api_key") String apiKey, Callback<Response> callback);
    
    @GET("/api/lol/{region}/v2.2/team/by-summoner/{summonerId}")
    void getTeamsBySummnerId(@Path("region") String region, @Path("summonerId") long summonerId, @Query("api_key") String apiKey, Callback<List<Team>> callback);
    
    @GET("/api/lol/{region}/v1.3/summoner/{summonerId}/runes")
    void getRunesBySummnerId(@Path("region") String region, @Path("summonerId") long summonerId, @Query("api_key") String apiKey, Callback<Response> callback);
}
