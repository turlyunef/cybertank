package ru.cybertank.evrodens.bot.handler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerResponseDto {
    @JsonProperty("Step")
    private String step;
    @JsonProperty("Hp")
    private int hp;
    @JsonProperty("Message")
    private ResponseMessage responseMessage;
    @JsonProperty("Status")
    private ResponseStatus responseStatus;
    @JsonProperty("Steps")
    private int steps;

    //Инициализация вражеского поля
    @JsonProperty("Field")
    private int[][] field;
}
