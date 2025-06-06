package itemlease;

public class TextStatementFormatter implements StatementFormatter {
    @Override
    public String format(Customer customer) {
        double totalAmount = 0;
        int nbLoyaltyPoints = 0;
        StringBuilder result = new StringBuilder("Games leased by " + customer.getName() + "\n");

        for (Lease each : customer.getLeases()) {
            double thisAmount = 0;
            switch (each.getGame().getPriceCode()) {
                case LeaseItem.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysLeased() > 2)
                        thisAmount += (each.getDaysLeased() - 2) * 1.5;
                    break;
                case LeaseItem.NEWLY_RELEASED:
                    thisAmount += each.getDaysLeased() * 3;
                    break;
                case LeaseItem.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysLeased() > 3)
                        thisAmount += (each.getDaysLeased() - 3) * 1.5;
                    break;
            }
            nbLoyaltyPoints++;
            if ((each.getGame().getPriceCode() == LeaseItem.NEWLY_RELEASED) && each.getDaysLeased() > 1)
                nbLoyaltyPoints++;
            result.append("\t").append(each.getGame().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        result.append("Amount is ").append(totalAmount).append("\n");
        result.append("You earned ").append(nbLoyaltyPoints).append(" loyalty points");
        return result.toString();
    }
}