package itemlease;

/**
 * The Lease class represents a customer leasing a game.
 */
public class Lease {

    private LeaseItem _leaseItem;
    private int _daysLeased;

    public Lease(LeaseItem leaseItem, int daysLeased) {
        _leaseItem = leaseItem;
        _daysLeased = daysLeased;
    }

    public int getDaysLeased() {
        return _daysLeased;
    }

    public LeaseItem getGame() {
        return _leaseItem;
    }

    /**
     * Calculates the charge for this lease based on the game's price code and lease duration
     * @return The cost of the lease
     */
    public double getCharge() {
        double result = 0;
        switch (getGame().getPriceCode()) {
            case LeaseItem.REGULAR:
                result += 2;
                if (getDaysLeased() > 2)
                    result += (getDaysLeased() - 2) * 1.5;
                break;
            case LeaseItem.NEWLY_RELEASED:
                result += getDaysLeased() * 3;
                break;
            case LeaseItem.CHILDREN:
                result += 1.5;
                if (getDaysLeased() > 3)
                    result += (getDaysLeased() - 3) * 1.5;
                break;
            default: // Handle unexpected price codes
                throw new IllegalArgumentException("Unknown price code: " + getGame().getPriceCode());
        }
        return result;
    }

    /**
     * Calculates the loyalty points earned for this lease
     * @return The number of loyalty points
     */
    public int getLoyaltyPoints() {
        // Add bonus for a two-day new release lease
        if ((getGame().getPriceCode() == LeaseItem.NEWLY_RELEASED) && getDaysLeased() > 1) {
            return 2;
        }
        return 1;
    }
}
