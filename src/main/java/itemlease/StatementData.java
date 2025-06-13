package itemlease;

import java.util.List;

/**
 * The StatementData class encapsulates the data needed to generate a statement for a customer.
 */
public class StatementData {

    private final String customerName;
    private final List<Lease> leases;
    private final double totalAmount;
    private final int loyaltyPoints;

    public StatementData(String customerName, List<Lease> leases, double totalAmount, int loyaltyPoints) {
        this.customerName = customerName;
        this.leases = leases;
        this.totalAmount = totalAmount;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Lease> getLeases() {
        return leases;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}