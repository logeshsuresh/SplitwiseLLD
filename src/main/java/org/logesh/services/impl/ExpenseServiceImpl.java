package org.logesh.services.impl;

import org.logesh.enums.SplitType;
import org.logesh.factories.SplitStrategyFactory;
import org.logesh.models.Expense;
import org.logesh.models.Split;
import org.logesh.models.User;
import org.logesh.repositories.ExpenseRepository;
import org.logesh.services.ExpenseService;

import java.util.List;
import java.util.Map;

public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense createExpense(double totalAmount, String description, User paidBy, List<User> participants, SplitType splitType, Map<User, Double> meta) {
        List<Split> splitList = SplitStrategyFactory.getStrategy(splitType).splitExpense(totalAmount, participants, meta);
        Expense expense = expenseRepository.save(new Expense(description, totalAmount, paidBy, splitList, splitType));
        return expense;
    }
}
