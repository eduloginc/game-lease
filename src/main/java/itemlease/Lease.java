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

    public double getAmount() {
        double amount = 0;
        switch (this.getGame().getPriceCode()) {
            case LeaseItem.REGULAR:
                amount += 2;
                if (this.getDaysLeased() > 2)
                    amount += (this.getDaysLeased() - 2) * 1.5;
                break;
            case LeaseItem.NEWLY_RELEASED:
                amount += this.getDaysLeased() * 3;
                break;
            case LeaseItem.CHILDREN:
                amount += 1.5;
                if (this.getDaysLeased() > 3)
                    amount += (this.getDaysLeased() - 3) * 1.5;
                break;
        }
        return amount;
    }
}
