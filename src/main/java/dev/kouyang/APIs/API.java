package dev.kouyang.APIs;

import dev.kouyang.APIs.Statbotics.StatAPI;
import dev.kouyang.APIs.TBA.TBAapi;
import dev.kouyang.APIs.Types.TypesStat.TeamStat;
import dev.kouyang.APIs.Types.TypesTBA.TeamTBA;
import dev.kouyang.Data.Database;
import dev.kouyang.Data.PitForm;
import dev.kouyang.Data.Types.Team;
import lombok.Data;

@Data
public class API {
    public static API api = new API();
    //private static TBAapi tbaAPI = new TBAapi();
    private static StatAPI statAPI = new StatAPI();

    public Team getStat(String teamNumber) {

        Database.parseHashMap();

        TeamStat stat = statAPI.getTeam(teamNumber);
        String name = stat.name;
        //String website = tba.getWebsite();
        double current = stat.normEpa.getCurrent();
        double recent = stat.normEpa.getRecent();
        double mean = stat.normEpa.getMean();
        double max = stat.normEpa.getMax();
        double winrate = stat.record.season.getWinrate();
        String robotPictureURL;
        try {
             robotPictureURL = Database.pitFormHashMap.get(teamNumber).getProxyURL();
        }catch (NullPointerException e){
            robotPictureURL = "None";
        }
        return new Team(
                teamNumber,
                name,
                current,
                recent,
                mean,
                max,
                winrate,
                robotPictureURL
        );
    }
}
