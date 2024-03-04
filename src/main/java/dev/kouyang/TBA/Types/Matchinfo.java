package dev.kouyang.TBA.Types;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
@Data
public class Matchinfo {
    private long actual_time;
    private Map<String, String> alliances;
    private String comp_level;
    private String event_key;
    private String key;
    private int match_number;
    private long post_result_time;
    private long predicted_time;
    private Map<String, Map<String, Object>> score_breakdown;
    private int set_number;
    private long time;
    private List<String> videos;
    private String winning_alliance;

    @JsonProperty("dq_team_keys")
    private List<String> dqTeamKeys;
    private int score;
    @JsonProperty("surrogate_team_keys")
    private List<String> surrogateTeamKeys;
    @JsonProperty("team_keys")
    private List<String> teamKeys;
    private String keys;
    private String type;

    // No need for getters and setters as fields are public

}
