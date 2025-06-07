package itemlease.statement;

import itemlease.Customer;
import itemlease.Lease;

public class HtmlStatementFormatter extends StatementFormatter {

    @Override
    protected String header(Customer customer) {
        return "<h1>Games leased by <em>" + customer.getName() + "</em></h1>\n<table>\n";
    }

    @Override
    protected String formatLeaseRow(Lease lease, double amount) {
        return "    <tr><td>" + lease.getGame().getTitle() + "</td><td>" + amount + "</td></tr>\n";
    }

    @Override
    protected String footer() {
        return ""
            + "</table>\n"
            + "<p>Amount is <em>" + statement.getTotalAmount() + "</em></p>\n"
            + "<p>You earned <em>" + statement.getNbLoyaltyPoints() + "</em> loyalty points</p>\n";
    }
}