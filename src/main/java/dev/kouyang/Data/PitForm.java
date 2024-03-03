package dev.kouyang.Data;

import lombok.Data;

@Data
public class PitForm {

    private String team;
    private String region;
    private String auto;
    private String scoring;
    private String other;

    public PitForm(String team, String region, String auto, String scoring, String other){
        this.team = team;
        this.region = region;
        this.auto = auto;
        this.scoring = scoring;
        this.other = other;
    }

}
