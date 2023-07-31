package com.suraj.factories;

import com.suraj.models.SpotAssignmentStrategyType;
import com.suraj.strategies.NearestSpotAssignmentStrategy;
import com.suraj.strategies.RandomSpotAssignmentStrategy;
import com.suraj.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(
            SpotAssignmentStrategyType spotAssignmentStrategyType){
        if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.NEAREST)){
            return new NearestSpotAssignmentStrategy();
        }else{
            return new RandomSpotAssignmentStrategy();
        }
    }
}
