package org.logesh.services;

import org.logesh.enums.DebtSimplificationAlgorithm;
import org.logesh.models.Group;

public interface SettlementService {
    void simplifyDebt(Group group, DebtSimplificationAlgorithm debtSimplificationAlgorithm);
}
