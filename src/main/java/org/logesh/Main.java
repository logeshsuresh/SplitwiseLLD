package org.logesh;

import org.logesh.enums.SplitType;
import org.logesh.models.*;
import org.logesh.repositories.GroupRepository;
import org.logesh.repositories.ExpenseRepository;
import org.logesh.repositories.impl.InMemoryExpenseRepositoryImpl;
import org.logesh.repositories.impl.InMemoryGroupRepository;
import org.logesh.services.BalanceSheetService;
import org.logesh.services.ExpenseService;
import org.logesh.services.GroupService;
import org.logesh.services.SettlementService;
import org.logesh.services.impl.BalanceSheetServiceImpl;
import org.logesh.services.impl.ExpenseServiceImpl;
import org.logesh.services.impl.GroupServiceImpl;
import org.logesh.services.impl.SettlementServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create users
        User logesh = new User(1, "Logesh");
        User saran = new User(2, "Saran");
        User arun  = new User(3, "Mani");

        // Setup repositories & services
        GroupRepository groupRepository = new InMemoryGroupRepository();
        ExpenseRepository expenseRepository = new InMemoryExpenseRepositoryImpl();
        ExpenseService expenseService = new ExpenseServiceImpl(expenseRepository);
        BalanceSheetService balanceSheetService = new BalanceSheetServiceImpl();
        SettlementService settlementService = new SettlementServiceImpl();
        GroupService groupService = new GroupServiceImpl(groupRepository, expenseService, balanceSheetService, settlementService);

        // Create a group
        groupService.createGroup("Trip to Coimbatore", Arrays.asList(logesh, saran, arun));

        // Fetch the group
        Group group = groupRepository.findAll().get(0);

        // Add expense: Logesh paid 900 for dinner split equally
        groupService.addExpense(
                group.getGroupId(),
                900,
                "Dinner at Anadhas",
                logesh,
                Arrays.asList(logesh, saran, arun),
                SplitType.EQUAL,
                new HashMap<>()
        );

        // Print balances
        System.out.println("\n=== Group Balance Sheets ===");
        for (Map.Entry<User, BalanceSheet> entry : group.getBalancesSheets().entrySet()) {
            User user = entry.getKey();
            BalanceSheet sheet = entry.getValue();
            System.out.println(user.getName() + " -> Paid: " + sheet.getTotalPaid() +
                    ", Expense: " + sheet.getTotalExpense() +
                    ", Balances: " + sheet.getBalances());
        }
    }
}