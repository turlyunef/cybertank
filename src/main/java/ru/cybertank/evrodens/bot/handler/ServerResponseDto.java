package ru.cybertank.evrodens.bot.handler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerResponseDto {
    @JsonProperty("Step")
    private CellDto step;
    @JsonProperty("Hp")
    private int hp;
    @JsonProperty("Message")
    private ResponseMessage responseMessage;
    @JsonProperty("Status")
    private ResponseStatus responseStatus;
    @JsonProperty("Steps")
    private int steps;

    //Initialization of the enemy field
    @JsonProperty("Field")
    private int[][] field;

    public CellDto getStep() {
        return step;
    }

    public void setStep(CellDto step) {
        this.step = step;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }
}
