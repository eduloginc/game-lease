package itemlease;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private List<Lease> _leases = new ArrayList<Lease>();

    public Customer(String name) {
        _name = name;
    }

    public void addLease(Lease arg) {
        _leases.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int nbLoyaltyPoints = 0;
        String result = "Games leased by " + getName() + "\n";

        for (Lease each : _leases) {
            double thisAmount = 0;

            //determine amounts for each line
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

            // add loyalty points
            nbLoyaltyPoints++;
            // add bonus for a two day famous lease
            if ((each.getGame().getPriceCode() == LeaseItem.NEWLY_RELEASED) && each.getDaysLeased() > 1)
                nbLoyaltyPoints++;

            // show figures for this lease
            result += "\t" + each.getGame().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(nbLoyaltyPoints) + " loyalty points";

        return result;
    }
}
