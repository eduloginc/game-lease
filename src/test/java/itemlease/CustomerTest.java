package itemlease;
import static junit.framework.Assert.assertEquals;

import itemlease.statement.HtmlStatementFormatter;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void test() {
        Customer customer = new Customer("Bob");
        customer.addLease(new Lease(new LeaseItem("Call Of Duty", LeaseItem.REGULAR), 2));
        customer.addLease(new Lease(new LeaseItem("Golden Eye", LeaseItem.REGULAR), 3));
        customer.addLease(new Lease(new LeaseItem("Short New", LeaseItem.NEWLY_RELEASED), 1));
        customer.addLease(new Lease(new LeaseItem("Long New", LeaseItem.NEWLY_RELEASED), 2));
        customer.addLease(new Lease(new LeaseItem("Super Mario", LeaseItem.CHILDREN), 3));
        customer.addLease(new Lease(new LeaseItem("Threes", LeaseItem.CHILDREN), 4));

        String expected = "" +
                "Games leased by Bob\n" +
                "\tCall Of Duty\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tSuper Mario\t1.5\n" +
                "\tThrees\t3.0\n" +
                "Amount is 19.0\n" +
                "You earned 7 loyalty points";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void testHtmlStatement() {
        Customer customer = new Customer("Martin");
        customer.addLease(new Lease(new LeaseItem("The Brain", LeaseItem.REGULAR), 3));
        customer.addLease(new Lease(new LeaseItem("Virus of the mind", LeaseItem.REGULAR), 2));
        String expected = "" +
                "<h1>Games leased by <em>Martin</em></h1>\n" +
                "<table>\n" +
                "    <tr><td>The Brain</td><td>3.5</td></tr>\n" +
                "    <tr><td>Virus of the mind</td><td>2.0</td></tr>\n" +
                "</table>\n" +
                "<p>Amount is <em>5.5</em></p>\n" +
                "<p>You earned <em>2</em> loyalty points</p>\n";
        assertEquals(expected, customer.statement(new HtmlStatementFormatter()));
    }
}
