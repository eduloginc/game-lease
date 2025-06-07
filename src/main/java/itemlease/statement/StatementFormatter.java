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
        StringBuilder leasesResult = new StringBuilder();
        for (Lease lease : customer.getLeases()) {
            double amount = statementModel.addLeaseAndReturnAmountAdded(lease);
            String row = formatLeaseRow(lease, amount);
            leasesResult.append(row);
        }
        return leasesResult.toString();
    }

    protected abstract String formatLeaseRow(Lease lease, double amount);

    protected abstract String footer();

}