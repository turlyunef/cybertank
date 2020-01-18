package ru.cybertank.evrodens.bot.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cybertank.evrodens.bot.TestBotImpl;
import ru.cybertank.evrodens.domain.Cell;
import ru.cybertank.evrodens.domain.CellStatus;
import ru.cybertank.evrodens.domain.Field;

import java.io.IOException;

import static java.util.Objects.nonNull;

public class ResponseReceiver {
    Field enemyField;
    private final Logger logger = LoggerFactory.getLogger(TestBotImpl.class);

    public ResponseReceiver(Field enemyField) {
        this.enemyField = enemyField;
    }

    public void handleMessage(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ServerResponseDto response = mapper.readValue(message, ServerResponseDto.class);
        if (nonNull(response.getResponseMessage()) &&
                (nonNull(response.getStep()))) {
            CellDto cell = mapper.readValue(response.getStep(), CellDto.class);
            if (nonNull(cell.getX()) && (nonNull(cell.getY())) ) {
                CellStatus cellStatus;
                switch (response.getResponseMessage()) {
                    case REPEATED:
                    case MISSED:
                        cellStatus = CellStatus.MISSED;
                        break;
                    case WOUNDED:
                        cellStatus = CellStatus.WOUNDED;
                        break;
                    case KILLED:
                        cellStatus = CellStatus.KILLED;
                        break;
                    default:
                        return;
                }
                int x = cell.getX();
                int y = cell.getY();
                enemyField.changeCellStatus(new Cell(x, y, cellStatus));
                logger.debug("Изменено состояние вражеского поля с координатами x = {}, y = {}. " +
                                "Выставлен статус {}", x, y, cellStatus);
            }
        }
    }

}
