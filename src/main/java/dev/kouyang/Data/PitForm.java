package dev.kouyang.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PitForm {

    @JsonProperty("teamNumber")
    private String teamNumber;
    @JsonProperty("region")
    private String region;
    @JsonProperty("robot")
    private String robot;
    @JsonProperty("auto")
    private String auto;
    @JsonProperty("scoring")
    private String scoring;
    @JsonProperty("other")
    private String other;
    private String proxyURL;

    public PitForm(String teamNumber, String region, String robot, String auto, String scoring, String other){
        this.teamNumber = teamNumber;
        this.robot = robot;
        this.region = region;
        this.auto = auto;
        this.scoring = scoring;
        this.other = other;
    }
    public PitForm(String teamNumber, String proxyURL){
        this.teamNumber = teamNumber;
        this.proxyURL= proxyURL;

    }

}
