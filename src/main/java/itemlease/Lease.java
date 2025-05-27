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
}
