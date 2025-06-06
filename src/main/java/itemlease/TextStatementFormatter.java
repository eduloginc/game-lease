package itemlease;

public class TextStatementFormatter implements StatementFormatter {
    
    @Override
    public String format(Customer customer) {

        StatementModel statementModel = new StatementModel(0, 0);

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
            statementModel.setNbLoyaltyPoints(statementModel.getNbLoyaltyPoints() + 1);
            if ((each.getGame().getPriceCode() == LeaseItem.NEWLY_RELEASED) && each.getDaysLeased() > 1)
                statementModel.setNbLoyaltyPoints(statementModel.getNbLoyaltyPoints() + 1);
            result.append("\t").append(each.getGame().getTitle()).append("\t").append(thisAmount).append("\n");
            statementModel.setTotalAmount(statementModel.getTotalAmount() + thisAmount);
        }
        result.append("Amount is ").append(statementModel.getTotalAmount()).append("\n");
        result.append("You earned ").append(statementModel.getNbLoyaltyPoints()).append(" loyalty points");
        return result.toString();
    }
}