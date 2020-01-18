package ru.cybertank.evrodens.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cybertank.evrodens.TestBot;

public class BotImpl implements Bot {

    private final Logger logger = LoggerFactory.getLogger(TestBot.class);
    private static final String name = "EvRoDens";

    public BotImpl() {
    }

    @Override
    public String sendArrangement() {
        return null;
    }

    @Override
    public Step sendStep() {
        return null;
    }

    @Override
    public void handleMessage(String message) {

    }

    @Override
    public String getName() {
        return name;
    }
}
