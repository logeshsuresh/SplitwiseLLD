package org.logesh.factories;

import org.logesh.enums.SplitType;
import org.logesh.strategies.split.EqualSplitStrategy;
import org.logesh.strategies.split.PercentageSplitStrategy;
import org.logesh.strategies.split.SplitStrategy;

public class SplitStrategyFactory {

    public static SplitStrategy getStrategy(SplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualSplitStrategy();
            case PERCENTAGE -> new PercentageSplitStrategy();
        };
    }

}
