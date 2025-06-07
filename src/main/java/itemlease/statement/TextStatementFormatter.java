package itemlease.statement;

import itemlease.Customer;
import itemlease.Lease;

public class TextStatementFormatter extends StatementFormatter {

    @Override
    protected String header(Customer customer) {
        return "Games leased by " + customer.getName() + "\n";
    }

    @Override
    protected String formatLeaseRow(Lease lease, double amount) {
        return "\t" + lease.getGame().getTitle() + "\t" + amount + "\n";
    }

    @Override
    protected String footer() {
        return "Amount is " + statementModel.getTotalAmount() + "\n"
                + "You earned " + statementModel.getNbLoyaltyPoints() + " loyalty points";
    }
}