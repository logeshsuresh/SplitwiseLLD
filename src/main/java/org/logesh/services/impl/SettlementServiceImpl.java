package org.logesh.services.impl;

import org.logesh.enums.DebtSimplificationAlgorithm;
import org.logesh.factories.DebtSimplificationStrategyFactory;
import org.logesh.models.Group;
import org.logesh.services.SettlementService;

public class SettlementServiceImpl implements SettlementService {

    @Override
    public void simplifyDebt(Group group, DebtSimplificationAlgorithm debtSimplificationAlgorithm) {
        DebtSimplificationStrategyFactory.getDebtSimplificationStrategy(debtSimplificationAlgorithm).simplifyDebt(group);
    }

}
