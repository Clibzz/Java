package com.nhlstenden.highCourt;

import java.util.HashSet;

public class DebtAgency {
    private HashSet<Client> clients;
    private HashSet<CaseOrder> caseOrders;
    private HashSet<Strategy> strategies;

    public DebtAgency() {
        this.clients = new HashSet<>();
        this.caseOrders = new HashSet<>();
        this.strategies = new HashSet<>();
        Strategy itemsFirst = new Strategy("ItemsFirst");
        Strategy cashFirst = new Strategy("CashFirst");
        this.strategies.add(itemsFirst);
        this.strategies.add(cashFirst);
    }

    public HashSet<Strategy> getStrategies() {
        return strategies;
    }

    public void addStrategies(Strategy strategy) {
        this.strategies.add(strategy);
    }

    public HashSet<Client> getClients() {
        return clients;
    }

    public void addClients(Client client) {
        this.clients.add(client);
    }

    public HashSet<CaseOrder> getCaseOrders() {
        return caseOrders;
    }

    public void addCaseOrders(CaseOrder caseOrder) {
        this.caseOrders.add(caseOrder);
    }

    /**
     * Set the strategy of a specific CaseOrder
     * @param caseOrder A CaseOrder
     * @param strategy The strategy for paying off the CaseOrder
     */
    public void setCaseOrderStrategy(CaseOrder caseOrder, Strategy strategy) {
        if (strategies.contains(strategy)) {
            caseOrder.setStrategy(strategy);
        } else {
            System.out.println("The debtAgency currently doesn't use this strategy");
        }
    }

    /**
     * Pay the debt of a CaseOrder
     * @param caseOrder
     * @return true if paid, false if not paid
     * @throws CouldNotClearWritException Exception for when a client can not pay off his or her debt
     */
    public boolean payDebt(CaseOrder caseOrder) throws CouldNotClearWritException {
        if (caseOrder.getStrategy().equals("ItemsFirst")) {
            for (Item item : caseOrder.getItems()) {
                if (caseOrder.getDebtAmount() > 0.00) {
                    caseOrder.setDebtAmount(caseOrder.getDebtAmount() - item.getValue());
                    caseOrder.getItems().remove(item);
                }
            }

            if (caseOrder.getDebtAmount() > 0.00) {
                if (caseOrder.getClient().getCashAmount() >= caseOrder.getDebtAmount()) {
                    caseOrder.getClient().setCashAmount(caseOrder.getClient().getCashAmount() - caseOrder.getDebtAmount());
                } else {
                    throw new CouldNotClearWritException();
                }
            }
            return true;
        }
        if (caseOrder.getStrategy().equals("CashFirst")) {
            if (caseOrder.getClient().getCashAmount() >= caseOrder.getDebtAmount()) {
                caseOrder.getClient().setCashAmount(caseOrder.getClient().getCashAmount() - caseOrder.getDebtAmount());
            } else {
                caseOrder.setDebtAmount(caseOrder.getDebtAmount() - caseOrder.getClient().getCashAmount());
                caseOrder.getClient().setCashAmount(0.00);
                for (Item item : caseOrder.getItems()) {
                    if (caseOrder.getDebtAmount() > 0.00) {
                        caseOrder.setDebtAmount(caseOrder.getDebtAmount() - item.getValue());
                        caseOrder.getItems().remove(item);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Get the total amount of unpaid debt of the clients of the agency
     * @return The total amount of unpaid debt
     */
    public double getTotalUnpaidDebt() {
        double totalUnpaidDebt = 0.00;
        for (CaseOrder caseorder : caseOrders) {
            totalUnpaidDebt += caseorder.getDebtAmount();
        }
        return totalUnpaidDebt;
    }
}
