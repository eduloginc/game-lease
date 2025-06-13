package itemlease;

/**
 * The TextStatementRenderer class implements the StatementRenderer interface
 * to generate a plain text statement for a customer's leases.
 */
public class TextStatementRenderer implements StatementRenderer {

    @Override
    public String render(StatementData data) {
        String result = "Games leased by " + data.getCustomerName() + "\n";
        for (Lease each : data.getLeases()) {
            result += "\t" + each.getGame().getTitle() + "\t" + each.getCharge() + "\n";
        }
        result += "Amount is " + data.getTotalAmount() + "\n";
        result += "You earned " + data.getLoyaltyPoints() + " loyalty points";
        return result;
    }
}
