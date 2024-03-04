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
        for(PitForm pf : Database.pitForms){
            for(TeamTBA tt : total){
                if(!(pf.getTeamNumber().equals(tt.getTeam_number()))){
                    noScout.append(tt.getTeam_number()).append("\n");
                }
            }
        }
        return noScout.toString();
    }

    public String scouted(){
        String result = "";
        for(PitForm pf : Database.pitForms){
            result += pf.getTeamNumber() + "\n";
        }
        return result;
    }
}
