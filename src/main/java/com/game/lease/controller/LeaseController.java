package com.game.lease.controller;

import com.game.lease.model.Customer;
import com.game.lease.model.Lease;
import com.game.lease.model.LeaseItem;
import org.springframework.web.bind.annotation.*;

@RestController
public class LeaseController {

    private Customer customer;

    public LeaseController() {
        customer = new Customer("Martin");
        customer.addLease(new Lease(new LeaseItem("The Brain", LeaseItem.REGULAR), 3));
        customer.addLease(new Lease(new LeaseItem("Virus of the mind", LeaseItem.NEWLY_RELEASED), 2));
    }

    @GetMapping(value = "/statement", produces = "text/plain")
    public String getStatement() {
        return customer.statement();
    }

    @GetMapping(value = "/statementHtml", produces = "text/html")
    public String getStatementHtml() {
        return customer.statementHtml();
    }

}