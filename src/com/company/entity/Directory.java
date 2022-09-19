package com.company.entity;

public class Directory {
    private Integer id;
    private String fromCity;
    private String toCity;
    private String price;
    private String quantity;

    public Directory() {

    }

    public Directory(String fromCity, String toCity, String price, String quantity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.price = price;
        this.quantity = quantity;
    }
    public Directory(String fromCity, String toCity, String price) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "id=" + id +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
