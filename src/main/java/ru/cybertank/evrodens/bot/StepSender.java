package ru.cybertank.evrodens.bot;

import ru.cybertank.evrodens.domain.Cell;
import ru.cybertank.evrodens.domain.CellStatus;
import ru.cybertank.evrodens.domain.Field;

import static java.util.Objects.nonNull;

public class StepSender {

    private Step previousStep;

    public Step sendStep(Field enemyField){
        Cell woundedCell = enemyField.findWounded();

        if (nonNull(woundedCell)) {
            return finish(enemyField, woundedCell);
        }

        return new Step(1, 2);
    }

    public StepSender() {
        previousStep = new Step(0, 0);
    }

    private Step makeStep(){
        Step step = new Step(1, 2);

        return null;
    }

    private boolean isStepRight(int x, int y, Field enemyField){
       return (x < 9 && x > 0) && (y < 9 && y > 0)
               && (enemyField.getCellByCoordinate(x, y).getStatus().equals(CellStatus.MISSED));
    }

    private Step finish(Field enemyField, Cell woundedCell){

        int x = woundedCell.getX();
        int y = woundedCell.getY();

        if (isStepRight(x+1, y, enemyField)){
            return new Step(x + 1, y);
        } else if (isStepRight(x - 1, y, enemyField)){
            return new Step(x - 1, y);
        } else if (isStepRight(x, y + 1, enemyField)){
            return new Step(x, y + 1);
        }
            return new Step(x, y - 1);

    }

}
