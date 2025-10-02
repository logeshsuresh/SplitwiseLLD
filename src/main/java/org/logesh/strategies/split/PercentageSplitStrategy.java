package org.logesh.strategies.split;

import org.logesh.models.Split;
import org.logesh.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> splitExpense(Double totalAmount, List<User> participants, Map<User, Double> expenseMetadata) {
        double totalPercentage = expenseMetadata.values().stream().mapToDouble(Double::doubleValue).sum();
        if (totalPercentage != 100) throw new IllegalArgumentException(String.format("Percentage values don't sum up to 100. Percentage Sum: {}", totalPercentage));
        List<Split> splitList = new ArrayList<>();
        for (User participant : participants) {
            double splitForParticipant = totalAmount * expenseMetadata.get(participant);
            Split split = new Split(participant, splitForParticipant);
            splitList.add(split);
        }
        return splitList;
    }

}
