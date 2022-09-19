package com.company.context;

import com.company.dao.impl.*;
import com.company.dao.inter.*;

public class Context {
    public static CustomerInter getInstanceofCustomer() {
        return new CustomerInterImpl();
    }

    public static CustomerTicketInter getInstanceofCustomerTicket() {
        return new CustomerTicketInterImpl();
    }

    public static DirectoryInter getInstanceofDirectory() {
        return new DirectoryInterImpl();
    }

    public static CompanyInter getInstanceofCompany() {
        return new CompanyInterImpl();
    }
}
