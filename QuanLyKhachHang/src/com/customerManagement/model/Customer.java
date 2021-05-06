package com.customerManagement.model;

public class Customer{
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String gender;
    private int numOfOrdersPurchased = 1;

    public Customer() {
    }

    public Customer(String name, String address, String phoneNumber, String email, String gender) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumOfOrdersPurchased() {
        return numOfOrdersPurchased;
    }

    public void setNumOfOrdersPurchased(int numOfOrdersPurchased) {
        this.numOfOrdersPurchased = numOfOrdersPurchased;
    }

    public String toStringCSV(){
        return name+","+address+","+phoneNumber+","+email+","+gender+","+numOfOrdersPurchased+"\n";
    }

    public void split(String line){
        String[] arr = line.split(",");
        try{
            name = arr[0];
            address = arr[1];
            phoneNumber = arr[2];
            email = arr[3];
            gender = arr[4];
            numOfOrdersPurchased = Integer.parseInt(arr[5]);
            toStringCSV();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }finally {

        }
    }

    @Override
    public String toString() {
        return "Khach hang: "+getName()
                +",\tDia chi: "+getAddress()
                +",\tEmail: "+getEmail()
                +",\tSdt: "+getPhoneNumber()
                +",\tGioi tinh: "+getGender()
                +",\tSo don da mua: "+getNumOfOrdersPurchased();
    }
}
