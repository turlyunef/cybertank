package ru.cybertank.evrodens.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cybertank.evrodens.TestBot;
import ru.cybertank.evrodens.domain.Field;

public class BotImpl implements Bot {

    private Field enemyField;
    private StepSender stepSender;

    private final Logger logger = LoggerFactory.getLogger(TestBot.class);
    private static final String NAME = "EvRoDens";

    public BotImpl() {
        this.enemyField = new Field();
        this.stepSender = new StepSender();
    }

    @Override
    public String sendArrangement() {
        return null;
    }

    @Override
    public Step sendStep() {
        return stepSender.sendStep(this.enemyField);
    }

    @Override
    public void handleMessage(String message) {

    }

    @Override
    public String getName() {
        return NAME;
    }
}
