package org.logesh.models;

import lombok.Builder;
import lombok.Data;

import java.util.*;

@Data
public class Group {

    private final String groupId;
    private final String groupName;
    private final List<User> members;
    private final List<Expense> expenses;
    private final Map<User, BalanceSheet> balancesSheets;

    public Group(String groupName) {
        this.groupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.balancesSheets = new HashMap<>();
    }

    public Group(String groupName, List<User> members) {
        this.groupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.members = members;
        this.expenses = new ArrayList<>();
        this.balancesSheets = new HashMap<>();
    }

    public void addMember(User user) {
        this.members.add(user);
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }

    public BalanceSheet getBalanceSheetOfUser(User user) {
        return this.balancesSheets.get(user);
    }

}
