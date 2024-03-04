package dev.kouyang.Discord.Commands;

import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class FormCommand {

    public static Modal pitForm(){
        TextInput region = TextInput.create("region", "Region - Smoky/Hofstra", TextInputStyle.SHORT)
                .setPlaceholder("Smoky")
                .build();

        TextInput robot = TextInput.create("robot", "Robot - DriveTrain / Mechanisms", TextInputStyle.PARAGRAPH)
                .setPlaceholder("Swerve drive / No shoot/ Yes climb / Yes amp / Yes speaker")
                .build();

        TextInput auto = TextInput.create("auto", "how many note auto/ if they are consistent", TextInputStyle.PARAGRAPH)
                .setPlaceholder("they have 4 note auto but not very consistent")
                .build();

        TextInput scoring = TextInput.create("scoring", "Climb/Amp/Speaker/Trap / Endgame ", TextInputStyle.PARAGRAPH)
                .setPlaceholder("they don't seem like to be able to score speaker")
                .setMinLength(1)
                .build();

        TextInput other = TextInput.create("other", "Opinions/Thoughts/RANK DRIVER/speed of cycle", TextInputStyle.PARAGRAPH)
                .setPlaceholder("although it's not a good scoring bot but they seem to be a good fit for us")
                .build();

        return Modal.create("pit", "Pit Scouting Form")
                .addComponents(ActionRow.of(region) , ActionRow.of(robot), ActionRow.of(scoring) ,ActionRow.of(auto), ActionRow.of(other))
                .build();
    }




    public static Modal Matchform(){
/*
        TextInput Matchnumber = TextInput.create("matchnum", "which match is it", TextInputStyle.SHORT)
                .setPlaceholder("1/32 ... 2/32")
                .build();
        TextInput Matchauto = TextInput.create("matchauto", "How many note auto, and ", TextInputStyle.SHORT)
                .setPlaceholder("they have a 3 note auto but they aren't consist")
                .build();
        TextInput Matchmidgame = TextInput.create("matchmidgame", " how fast is cycle / general pos of game", TextInputStyle.SHORT)
                .setPlaceholder("fast cycle, and they generally play offence scoring")
                .build();
        TextInput Matchendgame = TextInput.create("matcheg", " trap?/ Harmonony?/ Climb?", TextInputStyle.SHORT)
                .setPlaceholder("1/32 or 2/32")
                .build();
        TextInput Matchopinion = TextInput.create("matchopinion", " Rank driver/ how consistent they are   ", TextInputStyle.SHORT)
                .setPlaceholder("1/32 or 2/32")
                .build();
        return Modal.create("match", "Match Scouting Form")
                .addComponents(ActionRow.of(MatchnumbeMatchnumber) , ActionRow.of(Matchauto), ActionRow.of(Matchmidgame) ,ActionRow.of(Matchendgame), ActionRow.of(Matchopinion))
                .build();

 */
return null;
    }

}
