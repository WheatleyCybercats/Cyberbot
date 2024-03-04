package dev.kouyang.Discord.Commands;

import dev.kouyang.APIs.API;
import dev.kouyang.Data.Database;
import dev.kouyang.Data.Types.Team;
import dev.kouyang.Main;
import dev.kouyang.APIs.Types.TypesTBA.TeamTBA;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class TeamCommand {
    OptionMapping optionMapping;
    public TeamCommand(OptionMapping optionMapping){
        this.optionMapping = optionMapping;
    }

    public String getResult(){
        Team team = API.api.getStat(optionMapping.getAsString());
        Database.teams.add(team);
        StringBuilder sb = new StringBuilder();
        sb.append("Team Name: ").append(team.getName()+"\n");
        sb.append("Team Number: ").append(team.getNumber()+"\n");
        sb.append("Winrate: ").append(team.getWinrate()*100 + "%"+"\n");
        sb.append("Website: ").append(team.getWebsite()+"\n");
        sb.append("Recent norm_epa: ").append(team.getRecent()+"\n");
        sb.append("Mean norm_epa: ").append(team.getMean()+"\n");
        sb.append("Max norm_epa: ").append(team.getMax()+"\n");
        sb.append("Robot Picture: ").append(team.getRobotPictureURL()+"\n");
        return sb.toString();
    }
}
