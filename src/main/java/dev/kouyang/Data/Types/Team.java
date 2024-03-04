package dev.kouyang.Data.Types;

import lombok.Data;

@Data
public class Team {
    private String number;
    private String name;
    private String website;
    private double current; //Current norm_epa
    private double recent; //Recent norm_epa
    private double mean;// Mean norm_epa
    private double max;// Max norm_epa
    private double winrate; //Percent

    public Team(String number, String name, String website, double current, double recent, double mean, double max, double winrate){
        this.number = number;
        this.name = name;
        this.website = website;
        this.current = current;
        this.recent = recent;
        this.mean = mean;
        this.max = max;
        this.winrate = winrate;
    }
}
