package ru.cybertank.evrodens.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cybertank.evrodens.bot.TestBotImpl;

import java.util.Arrays;

public class Field {

    private final int fieldSize = 10;
    private Cell[][] field;
    private final Logger logger = LoggerFactory.getLogger(TestBotImpl.class);

    public Field() {
        field = new Cell[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = new Cell(i, j, CellStatus.CLOSED);
            }
        }
    }

    public Cell[][] getField() {
        return field;
    }

    public void setField(Cell[][] field) {
        this.field = field;
    }

    public Cell findWounded() {
        return Arrays.stream(field)
                .flatMap(Arrays::stream)
                .filter(x -> x.getStatus().equals(CellStatus.WOUNDED))
                .findFirst()
                .orElse(null);
    }

    public Cell getCellByCoordinate(int x, int y) {
        return field[x][y];
    }

    public void changeCellStatus(Cell cell) {
        this.field[cell.getX()][cell.getY()].setStatus(cell.getStatus());
        if (cell.getStatus().equals(CellStatus.KILLED)) {
            updateEmptyCells(cell);
        }
    }

    private void updateEmptyCells(Cell cell) {
        logger.debug("Запуск проверки окружающих клеток после убийства");
        int rowIndex = cell.getY();
        int colIndex = cell.getX();
        for (int i = rowIndex - 1; i <= rowIndex + 1; i++) {
            for (int j = colIndex - 1; j <= colIndex + 1; j++) {
                if (isCellExist(i, j)) {
                    updateCell(i, j);
                }
            }
        }
    }

    private void updateCell(int i, int j) {
        Cell cell = getCellByCoordinate(i, j);
        if (cell.getStatus().equals(CellStatus.CLOSED)) {
            cell.setStatus(CellStatus.MISSED);
            logger.debug("Ячейка с координатами [{}, {}] проверкой после убийства выставлена в MISSED", i, j);
        }
    }

    private boolean isCellExist(int rowIndex, int colIndex) {
        return !((rowIndex < 0) || (colIndex < 0) ||
                (rowIndex > fieldSize) ||
                (colIndex > fieldSize));
    }

    public int getFieldSize() {
        return fieldSize;
    }
}
