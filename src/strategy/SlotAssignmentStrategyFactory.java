package strategy;

import constants.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static  SlotAssignmentStrategy getSlotAssignmentStrategyBy(SlotAssignmentStrategyType type){
        if (type.equals(SlotAssignmentStrategyType.RANDOM)){
            return new RandomSlotAssignmentStrategy();
        }
        else{
            return null;
        }
    }
}
