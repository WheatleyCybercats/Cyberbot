package dev.kouyang.APIs.Types.TypesStat;

import lombok.Data;

@Data
class Full {
    public int wins;
    public int losses;
    public int ties;
    public int count;
    public double winrate;
}
