package dev.kouyang.APIs;

import dev.kouyang.APIs.Statbotics.StatAPI;
import dev.kouyang.APIs.TBA.TBAapi;
import dev.kouyang.APIs.Types.TypesStat.TeamStat;
import dev.kouyang.APIs.Types.TypesTBA.TeamTBA;
import dev.kouyang.Data.Types.Team;
import lombok.Data;

@Data
public class API {
    public static API api = new API();
    private static TBAapi tbaAPI = new TBAapi();
    private static StatAPI statAPI = new StatAPI();

    public Team getStat(String teamNumber) {
        TeamTBA tba = tbaAPI.getTeams().get(Integer.parseInt(teamNumber));
        TeamStat stat = statAPI.getTeam(teamNumber);
        String number = tba.getTeam_number();
        String name = tba.getNickname();
        String website = tba.getWebsite();
        double current = stat.normEpa.getCurrent();
        double recent = stat.normEpa.getRecent();
        double mean = stat.normEpa.getMean();
        double max = stat.normEpa.getMax();
        double winrate = stat.record.season.getWinrate();
        return new Team(
                number,
                name,
                website,
                current,
                recent,
                mean,
                max,
                winrate
        );
    }
}
