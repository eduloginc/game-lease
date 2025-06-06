package itemlease.statement;

import itemlease.Customer;

public interface StatementFormatter {
    String format(Customer customer);
}