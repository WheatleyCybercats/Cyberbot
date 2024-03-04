package dev.kouyang.APIs.TBA;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kouyang.APIs.Types.TypesTBA.TeamTBA;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class TBAapi {

    public HashMap<Integer, TeamTBA> teams;


    public TBAapi() /*throws IOException*/ {

        teams = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        List<TeamTBA> matchList = new ArrayList<>();
        try {
            for (int i = 0; i < 20; i++) {

                // Map JSON data to a list of Team objects
                List<TeamTBA> teamsList = objectMapper.readValue(Grabber.json("teams/" + i), new TypeReference<List<TeamTBA>>() {
                });

                // Print team details
                for (TeamTBA team : teamsList) {
                    teams.put(Integer.valueOf(team.getTeam_number()), team);
                }
            }
            System.out.println("Teams information gathered");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        for (TeamTBA team : matchList) {
            teams.put(Integer.valueOf(team.getTeam_number()), team);
        }

        String Teaminfo;









    }
}
