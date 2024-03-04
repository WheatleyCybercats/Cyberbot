package dev.kouyang.Statbotics.Types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Teams {
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

class Colors {
    public String primary;
    public String secondary;
}

class Record {
    public Season season;
    public Full full;
}

class Season {
    public int wins;
    public int losses;
    public int ties;
    public int count;
    public double winrate;
}

class Full {
    public int wins;
    public int losses;
    public int ties;
    public int count;
    public double winrate;
}

class NormEpa {
    public double current;
    public double recent;
    public double mean;
    public double max;
}
