package org.logesh.services;

import org.logesh.enums.SplitType;
import org.logesh.models.Expense;
import org.logesh.models.User;

import java.util.List;
import java.util.Map;

public interface ExpenseService {
    Expense createExpense(double totalAmount, String description, User paidBy, List<User> participants, SplitType splitType, Map<User, Double> meta);
}
