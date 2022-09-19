package com.company.entity;

public class CustomerTicket {
    private Integer id;
    private Directory directory;
    private Customer customer;
    private String price;
    private int customerId;

    public CustomerTicket(){

    }

    public CustomerTicket(Integer customerId,Directory directory, Customer customer, String price) {
        this.customerId=customerId;
        this.directory = directory;
        this.customer = customer;
        this.price = price;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", directory=" + directory +
                ", customer=" + customer +
                ", price='" + price + '\'' +
                '}';
    }
}
