package org.logesh.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BalanceSheet {

    private double totalPaid;
    private double totalExpense;
    private final Map<User, Double> balances;

    public BalanceSheet(double totalPaid, double totalExpense) {
        this.totalPaid = 0.0;
        this.totalExpense = 0.0;
        this.balances = new HashMap<>();
    }

    public void addTotalPaid(double amount) {
        this.totalPaid += amount;
    }

    public void addTotalExpense(double expense) {
        this.totalExpense += expense;
    }

    public void addBalance(User other, double amount) {
        balances.put(other, balances.getOrDefault(other, 0.0) + amount);
        if (Math.abs(balances.get(other)) < 1e-6) balances.remove(other);
    }

    public void clearBalances() {
        this.balances.clear();
    }

}
