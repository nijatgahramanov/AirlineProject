package com.company;

import com.company.context.Context;
import com.company.dao.inter.CompanyInter;
import com.company.dao.inter.CustomerInter;
import com.company.dao.inter.CustomerTicketInter;
import com.company.dao.inter.DirectoryInter;
import com.company.entity.Company;
import com.company.entity.Directory;

public class Main {

    public static void main(String[] args) {

        CustomerTicketInter dao = Context.getInstanceofCustomerTicket();
        System.out.println(dao.getAlLTickets());


    }
}
