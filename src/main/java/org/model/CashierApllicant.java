package org.model;

public class CashierApllicant{
    private String name;
    private Integer age;
    private Address address;
    private Qualification qualification;

    private String contact;

    public CashierApllicant(String name, Integer age, Address address, Qualification qualification,String contact) {

        this.name = name;
        this.age = age;
        this.address = address;
        this.qualification = qualification;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public String getContact(){
        return contact;
    }
//
//    @Override
//    public void sell() {
//        Cashies.super.sell();
//    }
}
