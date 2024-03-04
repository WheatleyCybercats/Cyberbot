package dev.kouyang.Statbotics;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kouyang.Statbotics.Types.Teams;

public class StatAPI {
    public void getTeam(){
        ObjectMapper mapper = new ObjectMapper();
        Teams team = new Teams();
        try {
            team = mapper.readValue(Grabber.json("/team/2872"), new TypeReference<Teams>() {
            });
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(team.getName());
    }
}
