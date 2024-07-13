package com.zelzazor.platzi_market.domain;

public class Customer {

    private int id;

    private String name;

    private String lastNames;

    private Double cellphoneNumber;


    private String address;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public Double getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(Double cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
