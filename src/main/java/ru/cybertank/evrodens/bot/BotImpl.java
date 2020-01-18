package ru.cybertank.evrodens.bot;

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
        return fieldCreator.createField();
    }

    @Override
    public Step sendStep() {
        printField(enemyField);
        Step step = this.stepSender.sendStep(this.enemyField);
        logger.warn("SHOOT: x = {} y =  {}", step.getY(), step.getX());
        return step;
    }

    private void printField(Field enemyField) {
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(enemyField.getCellByCoordinate(i, j).getStatus() + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

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
