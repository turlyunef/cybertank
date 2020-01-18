package ru.cybertank.evrodens;

import ru.cybertank.evrodens.bot.TestBotImpl;
import ru.cybertank.evrodens.client.Client;
import ru.cybertank.evrodens.client.PlayMode;


public class CyberTanksDebugModeApp {

    public static void main(final String[] args) {
        final TestBotImpl debugBot = new TestBotImpl("EvRoDensTest");
        //Запускать несколько тестовых ботов в режиме Fight нельзя, за это последуют санкции =)
        new Client(debugBot).start(PlayMode.DEBUG);

    }
}
