package riot_dev_api.unittest

import org.junit.Assert
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import riot_dev_api.Global
import riot_dev_api.connection.ConnectionFactory
import riot_dev_api.connection.SummonerConnection
import riot_dev_api.connection.async.SummonerAsyncConn
import riot_dev_api.dto.summoner_v3.SummonerDTO

class SummonerConnectionTest {
    @Test
    fun getSummonerByAccount() {
        val connFactory = ConnectionFactory();
        val connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST/*summoner name*/, Global.API_KEY);
        summoner = connObject.getSummonerByAccount(summoner!!.accountId, Global.API_KEY)
        Assert.assertNotNull("Failed. Summoner is null data.",summoner);
    }

    @Test
    fun getSummonerByName() {
        val connFactory = ConnectionFactory();
        val connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        val summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST/*summoner name*/, Global.API_KEY);
        Assert.assertNotNull("Failed. Summoner is null data.",summoner);
    }

    @Test
    fun getSummonerBySummonerID() {
        
        val connFactory = ConnectionFactory();
        val connObject = connFactory.getConnection(Global.Api.SUMMONER_V3, Global.Locale.KR)
        connObject as SummonerConnection
        var summoner = connObject.getSummonerByName(Global.SUMMONER_NAME_FOR_TEST/*summoner name*/, Global.API_KEY);
        Assert.assertNotNull("Failed. Summoner is null data.",summoner);
        summoner = connObject.getSummonerBySummonerID(summoner!!.id, Global.API_KEY);
        Assert.assertNotNull("Failed. Summoner is null data.",summoner);

    }
}