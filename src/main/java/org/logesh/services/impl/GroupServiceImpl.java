package org.logesh.services.impl;

import org.logesh.enums.DebtSimplificationAlgorithm;
import org.logesh.enums.SplitType;
import org.logesh.models.Expense;
import org.logesh.models.Group;
import org.logesh.models.User;
import org.logesh.repositories.GroupRepository;
import org.logesh.services.BalanceSheetService;
import org.logesh.services.ExpenseService;
import org.logesh.services.GroupService;
import org.logesh.services.SettlementService;

import java.util.List;
import java.util.Map;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final ExpenseService expenseService;
    private final BalanceSheetService balanceSheetService;
    private final SettlementService settlementService;

    public GroupServiceImpl(GroupRepository groupRepository, ExpenseService expenseService, BalanceSheetService balanceSheetService, SettlementService settlementService) {
        this.groupRepository = groupRepository;
        this.expenseService = expenseService;
        this.balanceSheetService = balanceSheetService;
        this.settlementService = settlementService;
    }

    @Override
    public void createGroup(String groupName, List<User> members) {
        Group group = new Group(groupName, members);
        groupRepository.save(group);
    }

    @Override
    public Group findGroupById(String groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new RuntimeException(String.format("GroupId: {} not found", groupId)));
    }

    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void addMemberToGroup(String groupId, User user) {
        Group group = findGroupById(groupId);
        group.addMember(user);
        groupRepository.save(group);
    }

    @Override
    public void addExpense(String groupId, double totalAmount, String description, User paidBy, List<User> participants, SplitType splitType, Map<User, Double> meta) {
        Group group = findGroupById(groupId);
        Expense expense = expenseService.createExpense(totalAmount, description, paidBy, participants, splitType, meta);
        group.addExpense(expense);
        balanceSheetService.updateBalance(group, expense);
        groupRepository.save(group);
    }

    @Override
    public void simplifyDebt(String groupId, DebtSimplificationAlgorithm debtSimplificationAlgorithm) {
        Group group = findGroupById(groupId);
        settlementService.simplifyDebt(group, debtSimplificationAlgorithm);
    }

}
