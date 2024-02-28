package dev.kouyang.Discord.Commands;

import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class FormCommand {

    public static Modal pitForm(){
        TextInput team = TextInput.create("team", "Team", TextInputStyle.SHORT)
                .setPlaceholder("Team Number/ Team name")
                .setMinLength(4)
                .setMaxLength(20) // or setRequiredRange(10, 100)
                .build();


        TextInput body = TextInput.create("rating", "Rating", TextInputStyle.SHORT)
                .setPlaceholder("rate it on a scale of 1 to 10")
                .setMinLength(1)
                .setMaxLength(10)
                .build();

        TextInput region = TextInput.create("region", "Region - Smoky/Hofstra", TextInputStyle.SHORT)
                .setPlaceholder("Smoky")
                .setMinLength(1)
                .setMaxLength(10)
                .build();



        Modal pit = Modal.create("pit", "Pit Scouting Form")
                .addComponents(ActionRow.of(team), ActionRow.of(body), ActionRow.of(region))
                .build();

        return pit;
    }

}
