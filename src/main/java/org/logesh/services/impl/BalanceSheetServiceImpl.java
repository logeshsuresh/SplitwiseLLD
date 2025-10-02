package org.logesh.services.impl;

import org.logesh.models.*;
import org.logesh.services.BalanceSheetService;

public class BalanceSheetServiceImpl implements BalanceSheetService {

    @Override
    public void updateBalance(Group group, Expense expense) {
        User paidBy = expense.getPaidBy();
        // Ensure payer has a balance sheet
        BalanceSheet payerSheet = group.getBalancesSheets().computeIfAbsent(paidBy, u -> new BalanceSheet(0.0, 0.0));
        // Add to payer's total paid
        payerSheet.addTotalPaid(expense.getAmount());
        // Iterate through each split (who owes how much)
        for (Split split : expense.getSplits()) {
            User participant = split.getUser();
            double share = split.getAmount();
            // Ensure participant has a balance sheet
            BalanceSheet participantSheet = group.getBalancesSheets().computeIfAbsent(participant, u -> new BalanceSheet(0.0, 0.0));
            // Update participant's total expense
            participantSheet.addTotalExpense(share);
            // If participant is not the payer → update balances
            if (!participant.equals(paidBy)) {
                // Participant owes payer
                participantSheet.addBalance(paidBy, -share);  // negative means owes
                payerSheet.addBalance(participant, share);    // positive means to receive
            } else {
                // If payer is also part of splits, count their share as expense
                payerSheet.addTotalExpense(share);
            }
        }
    }
}