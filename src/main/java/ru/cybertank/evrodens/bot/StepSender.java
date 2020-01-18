package ru.cybertank.evrodens.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cybertank.evrodens.domain.Cell;
import ru.cybertank.evrodens.domain.CellStatus;
import ru.cybertank.evrodens.domain.Field;

import java.util.Arrays;

import static java.util.Objects.nonNull;

public class StepSender {

    private Step currentStep;

    private int numberOfLine;

    private int relativeX;
    private int relativeY;

    private final Logger logger = LoggerFactory.getLogger(StepSender.class);

    public Step sendStep(Field enemyField){
        Cell woundedCell = enemyField.findWounded();

        if (nonNull(woundedCell)) {
            return finish(enemyField, woundedCell);
        }

        Step resultStep = makeStep(enemyField);

        System.out.println("Enemy field:" + Arrays.deepToString(enemyField.getField()));
        System.out.println(String.format("EvRoDens make a step with coordinate : %1$s , %2$s", resultStep.getX(), resultStep.getY()));
        logger.info( String.format("EvRoDens make a step with coordinate : %1$s , %2$s", resultStep.getX(), resultStep.getY()));

        return resultStep;
    }

    public StepSender() {
        numberOfLine = 1;
        relativeX = 1;
        relativeY = 0;
        currentStep = new Step(relativeX, relativeY);
    }

    private Step makeStep(Field enemyField){

        int x = currentStep.getX();
        int y = currentStep.getY();

        if (isStepRight(x, y, enemyField)){
            currentStep = new Step(x + 1, y + 1);
            return new Step(x, y);
        } else if(!enemyField.getCellByCoordinate(x, y).getStatus().equals(CellStatus.CLOSED)){
            currentStep = new Step(x + 1, y + 1);
            return makeStep(enemyField);
        }

        if(numberOfLine == 2){
            numberOfLine = 1;
            currentStep = new Step(relativeX + 2, relativeY);
        } else {
            currentStep = new Step(relativeY, relativeX);
            numberOfLine++;
        }
        return makeStep(enemyField);
    }

    private boolean isStepRight(int x, int y, Field enemyField){
       return (x <= enemyField.getFieldSize() && x >= 0) && (y <= enemyField.getFieldSize() && y >= 0)
               && (enemyField.getCellByCoordinate(x, y).getStatus().equals(CellStatus.CLOSED));
    }

    private Step finish(Field enemyField, Cell woundedCell){

        int x = woundedCell.getX();
        int y = woundedCell.getY();
        logger.info("Finish him");
        if (isStepRight(x + 1, y, enemyField)){
            return new Step(x + 1, y);
        } else if (isStepRight(x - 1, y, enemyField)){
            return new Step(x - 1, y);
        } else if (isStepRight(x, y + 1, enemyField)){
            return new Step(x, y + 1);
        }
            return new Step(x, y - 1);

    }

}
