package itemlease.statement;

import itemlease.Customer;
import itemlease.Lease;

public abstract class StatementFormatter {

    protected final StatementModel statementModel;

    public StatementFormatter() {
        this.statementModel = new StatementModel(0, 0);
    }

    public final String format(Customer customer) {
        StringBuilder result = new StringBuilder(header(customer));
        result.append(formatLeases(customer));
        result.append(footer());
        return result.toString();
    }

    protected abstract String header(Customer customer);

    protected String formatLeases(Customer customer) {
        return customer.getLeases().stream().reduce(
                new StringBuilder(),
                (leasesResult, lease) -> {
                    double amount = statementModel.addLeaseAndReturnAmountAdded(lease);
                    leasesResult.append(formatLeaseRow(lease, amount));
                    return leasesResult;
                },
                StringBuilder::append
            ).toString();
    }

    protected abstract String formatLeaseRow(Lease lease, double amount);

    protected abstract String footer();

}