package org.logesh.strategies.split;

import org.logesh.models.Split;
import org.logesh.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> splitExpense(Double totalAmount, List<User> participants, Map<User, Double> expenseMetadata) {
        double sharePerUser = totalAmount / participants.size();
        List<Split> splitList = new ArrayList<>();
        for (User participant : participants) {
            Split split = new Split(participant, sharePerUser);
            splitList.add(split);
        }
        return splitList;
    }

}
