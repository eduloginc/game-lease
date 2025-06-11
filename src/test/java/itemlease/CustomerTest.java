package itemlease;

import com.game.lease.model.Customer;
import com.game.lease.model.Lease;
import com.game.lease.model.LeaseItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
