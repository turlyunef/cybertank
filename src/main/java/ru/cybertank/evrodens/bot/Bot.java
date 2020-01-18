package ru.cybertank.evrodens.bot;

public interface Bot {

    String sendArrangement();

    Step sendStep();

    void handleMessage(final String message);

    String getName();
}
