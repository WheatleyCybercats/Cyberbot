package dev.kouyang.APIs.Statbotics;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kouyang.APIs.Types.TypesStat.TeamStat;

public class StatAPI {
    public TeamStat getTeam(String teamNumber){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(Grabber.json("team/" + teamNumber), new TypeReference<TeamStat>() {
            });
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        return null;
    }
}
