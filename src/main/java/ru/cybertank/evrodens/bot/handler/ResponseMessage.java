package ru.cybertank.evrodens.bot.handler;

public enum ResponseMessage {
    MISSED("Промах. Ход переходит противнику"),
    REPEATED("Выстрел произведен по ранее обстрелянной клетке, ход переходит противнику"),
    WOUNDED("Ранил, ход продолжается"),
    KILLED("Убил, ход продолжается"),
    OVER_BORDER("Вне поля"),
    TIMEOUT("Таймаут. Техническое поражение"),
    INVALID_MATRIX("Неверная матрица поля");
    private String descriptions;

    ResponseMessage(String descriptions) {
        this.descriptions = descriptions;
    }
}
