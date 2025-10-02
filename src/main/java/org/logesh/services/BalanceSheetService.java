package org.logesh.services;

import org.logesh.models.Expense;
import org.logesh.models.Group;
import org.logesh.models.User;

import java.util.Map;

public interface BalanceSheetService {
    void updateBalance(Group group, Expense expense);
}
