package itemlease.statement;

import itemlease.Customer;
import itemlease.Lease;

public class HtmlStatementFormatter implements StatementFormatter {
    @Override
    public String format(Customer customer) {

        StatementModel statementModel = new StatementModel(0, 0);

        StringBuilder result = new StringBuilder("<h1>Games leased by <em>" + customer.getName() + "</em></h1>\n");
        result.append("<table>\n");
        for (Lease lease : customer.getLeases()) {
            double amount = statementModel.addLeaseAndReturnAmountAdded(lease);
            result.append("    <tr><td>").append(lease.getGame().getTitle()).append("</td><td>").append(amount).append("</td></tr>\n");
        }
        result.append("</table>\n");
        result.append("<p>Amount is <em>").append(statementModel.getTotalAmount()).append("</em></p>\n");
        result.append("<p>You earned <em>").append(statementModel.getNbLoyaltyPoints()).append("</em> loyalty points</p>\n");
        return result.toString();
    }
}
