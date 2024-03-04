package dev.kouyang.APIs.TBA;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kouyang.APIs.Types.TypesStat.TeamStat;
import dev.kouyang.APIs.Types.TypesTBA.TeamTBA;

import java.util.ArrayList;

public class TBAapi {

    public ArrayList<TeamTBA> getEvent(String eventCode){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(Grabber.json("event/" + eventCode + "/teams"), new TypeReference<ArrayList<TeamTBA>>() {
            });
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        return null;
    }
}
