package dev.kouyang.APIs.TBA;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kouyang.APIs.Types.TypesStat.TeamStat;
import dev.kouyang.APIs.Types.TypesTBA.TeamTBA;

import java.util.ArrayList;
import java.util.Arrays;

public class TBAapi {

    public ArrayList<TeamTBA> getEvent(String eventCode){
        ArrayList<TeamTBA> teams = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            teams = mapper.readValue(Grabber.json("event/" + eventCode + "/teams"), new TypeReference<ArrayList<TeamTBA>>() {
            });
        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return teams;
    }
}
