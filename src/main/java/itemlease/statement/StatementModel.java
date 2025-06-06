package itemlease.statement;

import itemlease.Lease;
import itemlease.LeaseItem;

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

    public double addLeaseAndReturnAmountAdded(Lease each) {
        double amount = each.getAmount();
        this.setNbLoyaltyPoints(this.getNbLoyaltyPoints() + 1);
        if ((each.getGame().getPriceCode() == LeaseItem.NEWLY_RELEASED) && each.getDaysLeased() > 1)
            this.setNbLoyaltyPoints(this.getNbLoyaltyPoints() + 1);
        this.setTotalAmount(this.getTotalAmount() + amount);
        return amount;
    }
}