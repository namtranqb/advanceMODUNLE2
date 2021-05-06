package com.contact_management.model;

public class Contact {
    private int serialContact;
    private String phoneNumber;
    private String contactGroup;
    private String fullName;
    private String dob;
    private String address;
    private String email;

    public Contact() {
    }

    public Contact(int serialContact, String phoneNumber, String contactGroup, String fullName, String dob, String address, String email) {
        this.serialContact = serialContact;
        this.phoneNumber = phoneNumber;
        this.contactGroup = contactGroup;
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.email = email;
    }
    public Contact(String phoneNumber, String contactGroup, String fullName, String dob, String address, String email) {
        this.phoneNumber = phoneNumber;
        this.contactGroup = contactGroup;
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.email = email;
    }

    public Contact(String contactGroup, String fullName, String dob, String address, String email) {
        this.contactGroup = contactGroup;
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.email = email;
    }

    public int getSerialContact(){
        return serialContact;
    }

    public void setSerialContact(int serialContact) {
        this.serialContact = serialContact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(String contactGroup) {
        this.contactGroup = contactGroup;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public String toStringCSV(){
        return serialContact+","+phoneNumber+","+contactGroup+","+fullName+","+dob+","+address+","+email+"\n";
    }

    public void displayContact(){
        System.out.printf("|| %11s | %20s | %30s | %11s | %30s | %25s ||",phoneNumber,contactGroup,fullName,dob,address,email);
        System.out.println();
    }
    public void displayContactNonEmail(){
        System.out.printf("|| %11s | %20s | %30s | %11s | %30s ||",phoneNumber,contactGroup,fullName,dob,address);
        System.out.println();
    }

}
