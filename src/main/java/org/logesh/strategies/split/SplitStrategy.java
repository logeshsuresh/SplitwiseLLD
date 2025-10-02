package org.logesh.strategies.split;

import org.logesh.models.Split;
import org.logesh.models.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    List<Split> splitExpense(Double totalAmount, List<User> participants, Map<User, Double> expenseMetadata);
}
