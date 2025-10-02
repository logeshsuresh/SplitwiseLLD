package org.logesh.models;

import lombok.Data;
import org.logesh.enums.SplitType;

import java.util.List;
import java.util.UUID;

@Data
public class Expense {

    private final String expenseId;
    private final String description;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;
    private final SplitType splitType;

    public Expense(String description, double amount, User paidBy, List<Split> splits, SplitType splitType) {
        this.expenseId = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.splitType = splitType;
    }

}
