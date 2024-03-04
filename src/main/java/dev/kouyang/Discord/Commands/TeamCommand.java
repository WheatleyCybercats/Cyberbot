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
        sb.append("Team Name: ").append(team.getName());
        sb.append("\n");
        sb.append("Team Number: ").append(team.getNumber());
        sb.append("\n");
        sb.append("Winrate: ").append(team.getWinrate()*10 + "%");
        sb.append("\n");
        sb.append("Website: ").append(team.getWebsite());
        sb.append("\n");
        sb.append("Recent norm_epa: ").append(team.getRecent());
        sb.append("\n");
        sb.append("Mean norm_epa: ").append(team.getMean());
        sb.append("\n");
        sb.append("Max norm_epa: ").append(team.getMax());
        return sb.toString();
    }
}
