package org.logesh.services;

import org.logesh.enums.DebtSimplificationAlgorithm;
import org.logesh.enums.SplitType;
import org.logesh.models.Group;
import org.logesh.models.Split;
import org.logesh.models.User;

import java.util.List;
import java.util.Map;

public interface GroupService {
    void createGroup(String groupName, List<User> members);
    Group findGroupById(String groupId);
    List<Group> findAllGroups();
    void addMemberToGroup(String groupId, User user);
    void addExpense(String groupId, double totalAmount, String description, User paidBy, List<User> participants, SplitType splitType, Map<User, Double> meta);
    void simplifyDebt(String groupId, DebtSimplificationAlgorithm debtSimplificationAlgorithm);
}
