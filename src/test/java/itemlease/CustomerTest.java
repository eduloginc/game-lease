package itemlease;

import itemlease.renderer.HtmlStatementRenderer;
import itemlease.renderer.TextStatementRenderer;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Bob");
        customer.addLease(new Lease(new LeaseItem("Call Of Duty", LeaseItem.REGULAR), 2));
        customer.addLease(new Lease(new LeaseItem("Golden Eye", LeaseItem.REGULAR), 3));
        customer.addLease(new Lease(new LeaseItem("Short New", LeaseItem.NEWLY_RELEASED), 1));
        customer.addLease(new Lease(new LeaseItem("Long New", LeaseItem.NEWLY_RELEASED), 2));
        customer.addLease(new Lease(new LeaseItem("Super Mario", LeaseItem.CHILDREN), 3));
        customer.addLease(new Lease(new LeaseItem("Threes", LeaseItem.CHILDREN), 4));
    }

    @Test
    public void testTextStatement() {
        String expected = "Games leased by Bob\n" +
                "\tCall Of Duty\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tSuper Mario\t1.5\n" +
                "\tThrees\t3.0\n" +
                "Amount is 19.0\n" +
                "You earned 7 loyalty points";

        // use text statement renderer
        assertEquals(expected, customer.statement(new TextStatementRenderer()));
    }

    @Test
    public void testHtmlStatement() {
        String expected = "<h1>Games leased by <em>Bob</em></h1>\n" +
                "<table>\n" +
                "  <tr><td>Call Of Duty</td><td>2.0</td></tr>\n" +
                "  <tr><td>Golden Eye</td><td>3.5</td></tr>\n" +
                "  <tr><td>Short New</td><td>3.0</td></tr>\n" +
                "  <tr><td>Long New</td><td>6.0</td></tr>\n" +
                "  <tr><td>Super Mario</td><td>1.5</td></tr>\n" +
                "  <tr><td>Threes</td><td>3.0</td></tr>\n" +
                "</table>\n" +
                "<p>Amount is <em>19.0</em></p>\n" +
                "<p>You earned <em>7</em> loyalty points</p>";

        // use html statement renderer
        assertEquals(expected, customer.statement(new HtmlStatementRenderer()));
    }
}
