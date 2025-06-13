package itemlease;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Lease> leases = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addLease(Lease lease) {
        leases.add(lease);
    }

    public String getName() {
        return name;
    }

    /**
     * Generates a statement using the provided renderer.
     *
     * @param renderer The renderer to use for formatting the statement.
     * @return A formatted string statement.
     */
    public String statement(StatementRenderer renderer) {
        StatementData data = new StatementData(getName(), leases, getTotalCharge(), getTotalLoyaltyPoints());
        return renderer.render(data);
    }

    private double getTotalCharge() {
        return leases.stream()
                .mapToDouble(Lease::getCharge)
                .sum();
    }

    private int getTotalLoyaltyPoints() {
        return leases.stream()
                .mapToInt(Lease::getLoyaltyPoints)
                .sum();
    }
}