package dev.kouyang.Discord.Commands;

import dev.kouyang.APIs.API;
import dev.kouyang.APIs.TBA.TBAapi;
import dev.kouyang.APIs.Types.TypesTBA.TeamTBA;
import dev.kouyang.Data.Database;
import dev.kouyang.Data.PitForm;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ListTeamCommand {

    public String notScouted(String eventCode){
        TBAapi tbAapi = new TBAapi();
        ArrayList<TeamTBA> total = tbAapi.getEvent(eventCode);
        StringBuilder noScout = new StringBuilder();
        for(TeamTBA tba : total){
            if(!(Database.pitFormHashMap.containsKey(tba.getTeam_number()))){
                noScout.append(tba.getTeam_number()).append("\n");
            }
        }
        return noScout.toString();
    }

    public String listScouted(){
        StringBuilder sb = new StringBuilder();
        for(PitForm pf : Database.pitForms){
            sb.append(pf.getTeamNumber()).append("\n");
        }
        return sb.toString();
    }

    public String scouted(String number){
        StringBuilder sb = new StringBuilder();
        Database.parseHashMap();
        try {
            PitForm pf = Database.pitFormHashMap.get(number);
            sb.append("Robot Team Number: \n").append(pf.getTeamNumber()).append("\n");
            sb.append("\n");
            sb.append("------------------------");
            sb.append("\n");
            sb.append("Region Scouted: \n").append(pf.getRegion()).append("\n");
            sb.append("\n");
            sb.append("------------------------");
            sb.append("\n");
            sb.append("Robot Description: \n").append(pf.getRobot().replaceAll("\n", " | ")).append("\n");
            sb.append("\n");
            sb.append("------------------------");
            sb.append("\n");
            sb.append("Auto Description: \n").append(pf.getAuto().replaceAll("\n", " | ")).append("\n");
            sb.append("\n");
            sb.append("------------------------");
            sb.append("\n");
            sb.append("Scoring Description: \n").append(pf.getScoring().replaceAll("\n", " | ")).append("\n");
            sb.append("\n");
            sb.append("------------------------");
            sb.append("\n");
            sb.append("Other information: \n").append(pf.getOther().replaceAll("\n", " | ")).append("\n");
            sb.append("\n");
            sb.append("------------------------");
            sb.append("\n");
            sb.append("Robot Picture: \n").append(pf.getProxyURL()).append("\n");
        }catch (NullPointerException e){
            sb.append("We haven't scouted them yet! Perhaps scout them with /scoutpit :)");
        }
        return sb.toString();
    }
}
