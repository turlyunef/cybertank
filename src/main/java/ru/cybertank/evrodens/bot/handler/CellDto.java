package ru.cybertank.evrodens.bot.handler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CellDto {
    @JsonProperty("X")
    private int x;
    @JsonProperty("Y")
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
