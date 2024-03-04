package dev.kouyang.APIs.Types.TypesStat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class TeamStat {
    public String team;
    public String name;
    public String country;
    public String state;
    public String district;
    @JsonProperty("rookie_year")
    public int rookieYear;
    public boolean offseason;
    public boolean active;
    public Colors colors;
    public Record record;
    @JsonProperty("norm_epa")
    public NormEpa normEpa;
}

