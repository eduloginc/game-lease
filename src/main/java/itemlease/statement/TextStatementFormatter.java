package itemlease.statement;

import itemlease.Customer;
import itemlease.Lease;

public class TextStatementFormatter implements StatementFormatter {

    @Override
    public String format(Customer customer) {

        StatementModel statementModel = new StatementModel(0, 0);

        StringBuilder result = new StringBuilder("Games leased by " + customer.getName() + "\n");

        for (Lease lease : customer.getLeases()) {
            double amount = statementModel.addLeaseAndReturnAmountAdded(lease);
            result.append("\t").append(lease.getGame().getTitle()).append("\t").append(amount).append("\n");
        }
        result.append("Amount is ").append(statementModel.getTotalAmount()).append("\n");
        result.append("You earned ").append(statementModel.getNbLoyaltyPoints()).append(" loyalty points");
        return result.toString();
    }
}