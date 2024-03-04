package dev.kouyang.Discord.Commands;

import dev.kouyang.Main;
import dev.kouyang.TBA.Types.Team;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class TeamCommand {
    OptionMapping optionMapping;
    public TeamCommand(OptionMapping optionMapping){
        this.optionMapping = optionMapping;
    }

    public String getResult(){
        Team team = Main.TBAapi.teams.get(optionMapping.getAsInt());
        StringBuilder sb = new StringBuilder();
        sb.append("Nickname: ").append(team.getNickname());
        sb.append("\n");
        sb.append("Team Number: ").append(team.getTeam_number());
        sb.append("\n");
        sb.append("Rookie Year: ").append(team.getRookie_year());
        sb.append("\n");
        sb.append("Website: ").append(team.getWebsite());


        return sb.toString();
    }
}
