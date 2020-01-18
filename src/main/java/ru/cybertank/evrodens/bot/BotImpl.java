package ru.cybertank.evrodens.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cybertank.evrodens.TestBot;
import ru.cybertank.evrodens.bot.handler.ResponseReceiver;
import ru.cybertank.evrodens.domain.Field;

import java.io.IOException;

public class BotImpl implements Bot {

    private Field enemyField;
    private StepSender stepSender;
    private ResponseReceiver responseReceiver;

    private final Logger logger = LoggerFactory.getLogger(TestBot.class);
    private static final String NAME = "EvRoDens";

    public BotImpl() {
        this.enemyField = new Field();
        this.stepSender = new StepSender();
        this.responseReceiver = new ResponseReceiver(enemyField);
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
        try {
            this.responseReceiver.handleMessage(message);
        } catch (IOException e) {
            logger.error("Ошибка маппинга json, полученного от сервера");
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
