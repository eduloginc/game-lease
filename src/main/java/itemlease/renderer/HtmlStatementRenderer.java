package itemlease.renderer;

import itemlease.Lease;

/**
 * The HtmlStatementRenderer class implements the StatementRenderer interface
 * to generate an HTML formatted statement for a customer's leases.
 */
public class HtmlStatementRenderer implements StatementRenderer {

    @Override
    public String render(StatementData data) {
        StringBuilder result = new StringBuilder();
        result.append("<h1>Games leased by <em>")
                .append(data.getCustomerName())
                .append("</em></h1>\n")
                .append("<table>\n");

        for (Lease each : data.getLeases()) {
            result.append("  <tr><td>")
                    .append(each.getGame().getTitle())
                    .append("</td><td>")
                    .append(each.getCharge())
                    .append("</td></tr>\n");
        }

        result.append("</table>\n")
                .append("<p>Amount is <em>")
                .append(data.getTotalAmount())
                .append("</em></p>\n")
                .append("<p>You earned <em>")
                .append(data.getLoyaltyPoints())
                .append("</em> loyalty points</p>");

        return result.toString();
    }
}