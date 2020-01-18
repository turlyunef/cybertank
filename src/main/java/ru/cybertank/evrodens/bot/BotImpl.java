package ru.cybertank.evrodens.bot;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cybertank.evrodens.bot.fieldCreator.FieldCreator;
import ru.cybertank.evrodens.bot.fieldCreator.ManualPull;
import ru.cybertank.evrodens.bot.handler.ResponseReceiver;
import ru.cybertank.evrodens.domain.Field;

import java.io.IOException;

public class BotImpl implements Bot {

    private Field enemyField;
    private StepSender stepSender;
    private ResponseReceiver responseReceiver;
    private FieldCreator fieldCreator = new ManualPull();

    private final Logger logger = LoggerFactory.getLogger(TestBotImpl.class);
    private String name;

    public BotImpl(String name) {
        this.name = name;
        this.enemyField = new Field();
        this.stepSender = new StepSender();
        this.responseReceiver = new ResponseReceiver(enemyField);
    }

    public BotImpl(Field enemyField, StepSender stepSender, ResponseReceiver responseReceiver) {
        this.name = "EvRoDens";
        this.enemyField = enemyField;
        this.stepSender = stepSender;
        this.responseReceiver = responseReceiver;
    }

    @Override
    public String sendArrangement() {
        Gson gson = new Gson();
        return gson.toJson(fieldCreator.createField());
    }

    @Override
    public Step sendStep() {
        return this.stepSender.sendStep(this.enemyField);
    }

    @Override
    public void handleMessage(String message) {
        try {
            logger.debug("Получено сообщение от сервера: " + message);
            this.responseReceiver.handleMessage(message);
        } catch (IOException e) {
            logger.error("Ошибка маппинга json, полученного от сервера");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
