package dev.kouyang.TBA;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iwebpp.crypto.TweetNaclFast;
import dev.kouyang.TBA.Core.Grabber;
import dev.kouyang.TBA.TBA.Matchinfo;
import dev.kouyang.TBA.TBA.Team;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@Data
public class API {

    public HashMap<Integer, Team> teams;


    public API() /*throws IOException*/ {

        teams = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        List<Team> matchList = new ArrayList<>();
        try {
            for (int i = 0; i < 20; i++) {

                // Map JSON data to a list of Team objects
                List<Team> teamsList = objectMapper.readValue(Grabber.json("teams/" + i), new TypeReference<List<Team>>() {
                });

                // Print team details
                for (Team team : teamsList) {
                    teams.put(Integer.valueOf(team.getTeam_number()), team);
                }
            }
            System.out.println("Teams information gathered");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        for (Team team : matchList) {
            teams.put(Integer.valueOf(team.getTeam_number()), team);
        }

        //List<Matchinfo> infolist = objectMapper.readValue(Grabber.json("event/2023nyli/teams"), new TypeReference<List<Matchinfo>>() {
       // });




    }
}
