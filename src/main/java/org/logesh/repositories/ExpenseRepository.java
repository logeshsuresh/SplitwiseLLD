package org.logesh.repositories;

import org.logesh.models.Expense;

public interface ExpenseRepository {
    Expense save(Expense expense);
}
