package itemlease.renderer;

import itemlease.Lease;

/**
 * The TextStatementRenderer class implements the StatementRenderer interface
 * to generate a plain text statement for a customer's leases.
 */
public class TextStatementRenderer implements StatementRenderer {

    @Override
    public String render(StatementData data) {
        StringBuilder result = new StringBuilder("Games leased by " + data.getCustomerName() + "\n");
        for (Lease each : data.getLeases()) {
            result.append("\t")
                    .append(each.getGame().getTitle())
                    .append("\t")
                    .append(each.getCharge())
                    .append("\n");
        }
        result.append("Amount is ")
                .append(data.getTotalAmount())
                .append("\n")
                .append("You earned ")
                .append(data.getLoyaltyPoints())
                .append(" loyalty points");
        return result.toString();
    }
}
