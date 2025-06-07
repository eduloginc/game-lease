package itemlease.statement;

import itemlease.Customer;
import itemlease.Lease;

public abstract class StatementFormatter {

    protected final Statement statement
            ;
    protected final StringBuilder result;

    public StatementFormatter() {
        this.statement = new Statement(0, 0);
        this.result = new StringBuilder();
    }

    public final String format(Customer customer) {
        result.append(header(customer));
        result.append(formatLeases(customer));
        result.append(footer());
        return result.toString();
    }

    protected abstract String header(Customer customer);

    protected StringBuilder formatLeases(Customer customer) {
        return customer.getLeases().stream().reduce(
                new StringBuilder(),
                (leasesResult, lease) -> {
                    double amount = statement.addLeaseAndReturnAmountAdded(lease);
                    leasesResult.append(formatLeaseRow(lease, amount));
                    return leasesResult;
                },
                StringBuilder::append
            );
    }

    protected abstract String formatLeaseRow(Lease lease, double amount);

    protected abstract String footer();

}