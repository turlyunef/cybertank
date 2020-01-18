package ru.cybertank.evrodens.bot.handler;

public enum Message {
    MISSED("Промах. Ход переходит противнику"),
    REPEATED("Выстрел произведен по ранее обстрелянной клетке, ход переходит противнику"),
    WOUNDED("Ранил, ход продолжается"),
    KILLED("Убил, ход продолжается"),
    OVER_BORDER("Вне поля"),
    TIMEOUT("Таймаут. Техническое поражение");
    private String descriptions;

    Message(String descriptions) {
        this.descriptions = descriptions;
    }
}
