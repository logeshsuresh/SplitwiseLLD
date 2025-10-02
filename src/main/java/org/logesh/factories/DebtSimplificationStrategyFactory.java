package org.logesh.factories;

import org.logesh.enums.DebtSimplificationAlgorithm;
import org.logesh.strategies.debtSimplification.DebtSimplificationStrategy;
import org.logesh.strategies.debtSimplification.DepthFirstSearchDebtSimplificationStrategy;
import org.logesh.strategies.debtSimplification.GreedyDebtSimplificationStrategy;

public class DebtSimplificationStrategyFactory {

    public static DebtSimplificationStrategy getDebtSimplificationStrategy(DebtSimplificationAlgorithm debtSimplificationAlgorithm) {
        return switch (debtSimplificationAlgorithm) {
            case DEPTH_FIRST_SEARCH -> new DepthFirstSearchDebtSimplificationStrategy();
            case GREEDY -> new GreedyDebtSimplificationStrategy();
        };
    }

}
