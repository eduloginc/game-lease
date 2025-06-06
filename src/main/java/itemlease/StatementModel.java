package itemlease;

public class StatementModel {
    private double totalAmount;
    private int nbLoyaltyPoints;

    public StatementModel(double totalAmount, int nbLoyaltyPoints) {
        this.totalAmount = totalAmount;
        this.nbLoyaltyPoints = nbLoyaltyPoints;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getNbLoyaltyPoints() {
        return nbLoyaltyPoints;
    }

    public void setNbLoyaltyPoints(int nbLoyaltyPoints) {
        this.nbLoyaltyPoints = nbLoyaltyPoints;
    }

    static double leaseAmount(Lease lease) {
        double amount = 0;
        switch (lease.getGame().getPriceCode()) {
            case LeaseItem.REGULAR:
                amount += 2;
                if (lease.getDaysLeased() > 2)
                    amount += (lease.getDaysLeased() - 2) * 1.5;
                break;
            case LeaseItem.NEWLY_RELEASED:
                amount += lease.getDaysLeased() * 3;
                break;
            case LeaseItem.CHILDREN:
                amount += 1.5;
                if (lease.getDaysLeased() > 3)
                    amount += (lease.getDaysLeased() - 3) * 1.5;
                break;
        }
        return amount;
    }

    public double addLeaseAndReturnAmountAdded(Lease each) {
        double amount = leaseAmount(each);
        this.setNbLoyaltyPoints(this.getNbLoyaltyPoints() + 1);
        if ((each.getGame().getPriceCode() == LeaseItem.NEWLY_RELEASED) && each.getDaysLeased() > 1)
            this.setNbLoyaltyPoints(this.getNbLoyaltyPoints() + 1);
        this.setTotalAmount(this.getTotalAmount() + amount);
        return amount;
    }
}