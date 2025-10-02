package org.logesh.repositories.impl;

import org.logesh.models.Expense;
import org.logesh.repositories.ExpenseRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryExpenseRepositoryImpl implements ExpenseRepository {

    private final Map<String, Expense> expenseMap = new HashMap<>();

    @Override
    public Expense save(Expense expense) {
        expenseMap.put(expense.getExpenseId(), expense);
        return expenseMap.get(expense.getExpenseId());
    }

}
