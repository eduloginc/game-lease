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

    /**
     * Generates a statement using the provided renderer.
     * @param renderer The renderer to use for formatting the statement.
     * @return A formatted string statement.
     */
    public String statement(StatementRenderer renderer) {
        StatementData data = new StatementData(getName(), _leases, getTotalCharge(), getTotalLoyaltyPoints());
        return renderer.render(data);
    }

    private double getTotalCharge() {
        double result = 0;
        for (Lease each : _leases) {
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalLoyaltyPoints() {
        int result = 0;
        for (Lease each : _leases) {
            result += each.getLoyaltyPoints();
        }
        return result;
    }
}
