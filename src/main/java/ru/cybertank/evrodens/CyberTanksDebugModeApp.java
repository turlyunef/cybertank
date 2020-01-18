package ru.cybertank.evrodens;

import ru.cybertank.evrodens.bot.BotImpl;
import ru.cybertank.evrodens.client.Client;
import ru.cybertank.evrodens.client.PlayMode;


public class CyberTanksDebugModeApp {

    public static void main(final String[] args) {
        final TestBot debugBot = new TestBot("EvRoDensTest");
        //Запускать несколько тестовых ботов в режиме Fight нельзя, за это последуют санкции =)
        new Client(debugBot).start(PlayMode.DEBUG);

    }
}
