package org.model;

public abstract class Staff_Information {
    private String name;
    private String contact;
    private Address address;

    public Staff_Information() {
    }

    public Staff_Information(String name, String contact , Address address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    protected void address() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
