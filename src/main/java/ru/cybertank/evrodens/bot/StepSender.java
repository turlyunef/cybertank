package ru.cybertank.evrodens.bot;

import ru.cybertank.evrodens.domain.Cell;
import ru.cybertank.evrodens.domain.Field;

public class StepSender {

    private Step previousStep;

    public Step sendStep(Field enemyField){

        return new Step(1, 2);
    }

    public StepSender() {
    }

    private boolean isStepRight(Step step){
       return (step.getX() > 9 || step.getX() < 0)
               || (step.getY() > 9 || step.getY() < 0);
    }

    private Step finish(Field enemyField, Cell woundedCell){
        if
    }

}
