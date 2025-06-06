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
}