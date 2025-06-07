package itemlease;

import itemlease.statement.StatementFormatter;
import itemlease.statement.TextStatementFormatter;

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

    public List<Lease> getLeases() {
        return _leases;
    }

    public String statement() {
        return new TextStatementFormatter().format(this);
    }

    public String statement(StatementFormatter formatter) {
        return formatter.format(this);
    }
}
