package ru.cybertank.evrodens;

import ru.cybertank.evrodens.bot.TestBotImpl;
import ru.cybertank.evrodens.client.Client;
import ru.cybertank.evrodens.client.PlayMode;


public class CyberTanksTestModeApp {

    public static void main(final String[] args) {
        final TestBotImpl bot1 = new TestBotImpl("GLaDOS_1");
        final TestBotImpl bot2 = new TestBotImpl("GLaDOS_2");

        new Client(bot1).start(PlayMode.TEST);
        new Client(bot2).start(PlayMode.TEST);
    }
}
