package com.customerManagement.service;

import com.customerManagement.dal.CustomerDB;
import com.customerManagement.model.Customer;
import java.util.Scanner;

public class CustomerService {
    Scanner sc = new Scanner(System.in);
    CustomerDB customerDB = new CustomerDB();

    public void loadFile(){
        customerDB.read();
    }


    public void updateFile(){
        customerDB.write();

    }
    public void status(){
        System.out.println("--Chao mung ban den voi he thong quan ly khach hang--");
    }

    public void displayMenu(){
        System.out.println("\tBam 1 de nhap khach hang");
        System.out.println("\tBam 2 de tim kiem khach hang");
        System.out.println("\tBam 3 de sua thong tin khach hang");
        System.out.println("\tBam 4 de xoa thong tin khach hang");
        System.out.println("\tBam 5 de in thong tin khach hang");
        System.out.println("\tBam 6 de in toan bo danh sach khach hang");
        System.out.println("\tBam 7 de tang so don hang cho khach");
        System.out.println("\tBam 0 de thoat");

    }

    public void chooseMenu(){
        Scanner sc = new Scanner(System.in);
        String choose;
        displayMenu();
        System.out.println("******************************");
        System.out.println("Nhap lua chon: ");
        choose = sc.nextLine();
        switch (choose) {
            case "1":
                addCustomer();
                chooseYN();
                break;
            case "2":
                findCustomer();
                chooseYN();
                break;
            case "3":
                editCustomer();
                chooseYN();
            case "4":
                deleteCustomer();
                chooseYN();
                break;
            case "5":
                customerInformation();
                chooseYN();
                break;
            case "6":
                listOfCustomerInformation();
                chooseYN();
                break;
            case "7":
                increaseOrders();
                chooseYN();
                break;
            case "0":
                System.out.println("He thong Quan ly khach hang vua shutdown");
                System.exit(0);
            default:
                System.out.println("Nhap sai !");
                chooseMenu();
        }

    }



    public void chooseYN(){
        System.out.println("******************************");
        System.out.println("Chon Y(tiep tuc) / N(thoat) :");
        String chooseYN;
        do{
            chooseYN = sc.nextLine();
            switch (toUpperCase(chooseYN)){
                case "Y":
                    chooseMenu();
                    break;
                case "N":
                    System.out.println("He thong Quan ly khach hang vua shutdown");
                    System.exit(0);
                default:
                    chooseYN();
            }
        }while (true);
    }


    public Customer input(){
        Scanner sc = new Scanner(System.in);
        String name;
        do{
            System.out.println("Nhap ten: ");
            name = toUpperCase(sc.nextLine());
        }while (name == null);


        System.out.println("Nhap dia chi: ");
        String address = toUpperCase(sc.nextLine());


        String email;
        do{
            System.out.println("Nhap email: ");
            email = sc.nextLine();
            if(!email.contains(".com")){
                email = email+".com";
            }
        }while (email.contains(" ") || !email.contains("@") || email == null);

        String phoneNumber;
        do{
            System.out.println("Nhap sdt: ");
            phoneNumber = sc.nextLine();
        }while (phoneNumber == null );


        System.out.println("Nhap gioi tinh: ");
        String gender = toUpperCase(sc.nextLine());
        Customer ctm = new Customer(name,address,phoneNumber,email,gender);
        return ctm;
    }

    public String toUpperCase(String string){
        char[] charArray = string.toCharArray();
        boolean foundSpace = true;
        for(int i = 0; i < charArray.length; i++) {
            if(Character.isLetter(charArray[i])) {
                if(foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            }
            else {
                foundSpace = true;
            }
        }
        String outputString = String.valueOf(charArray);
        return outputString;
    }


    private void addCustomer(){
        Customer ctm = input();
        boolean check = false;
        for(Customer customer: customerDB.customerList){
            if(customer.getPhoneNumber().equals(ctm.getPhoneNumber())  && customer.getEmail().equals(ctm.getEmail())){
                check = true;
                customer.setName(ctm.getName());
                customer.setAddress(ctm.getAddress());
                customer.setGender(ctm.getGender());
                customerDB.write();
                System.out.println("Khach hang da ton tai, He thong vua update thong tin");
                break;
            }

        }
        if(!check){
            System.out.println("So luong don hang: ");
            ctm.setNumOfOrdersPurchased(sc.nextInt());
            customerDB.customerList.add(ctm);
            customerDB.write();
            System.out.println("Ban vua them moi khach hang < "+ctm.getName()+" > thanh cong ");
        }
    }



    private void findCustomer(){
        System.out.println("Nhap sdt khach hang: ");
        String number = sc.nextLine();
        System.out.println("He thong dang tim kiem...");
        boolean check = false;
        for (Customer ctm: customerDB.customerList) {
            if(ctm.getPhoneNumber().equals(number)){
                System.out.println("Ket qua: ");
                System.out.println(ctm.toString());
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("Khong ton tai khach hang");
        }
    }

    private void editCustomer() {

        System.out.println("Nhap sdt khach hang: ");
        String number = sc.nextLine();
        boolean check = false;
        for (Customer ctm: customerDB.customerList) {
            if(ctm.getPhoneNumber().equals(number)){
                System.out.println("Sua thong tin khach hang: ");
                System.out.println(ctm.toString());
                System.out.println();
                System.out.println("Ban muon sua thong tin khach hang nay (Y(sua)/Other(quay lai)) ?");
                switch (toUpperCase(sc.nextLine())){
                    case "Y":
                        Customer customer = input();
                        ctm.setName(customer.getName());
                        ctm.setAddress(customer.getAddress());
                        ctm.setEmail(customer.getEmail());
                        ctm.setPhoneNumber(customer.getPhoneNumber());
                        ctm.setGender(customer.getGender());

                        System.out.println("Lam moi thong tin khach hang: ");
                        System.out.println(ctm.toString());
                        check = true;
                        customerDB.write();
                        break;
                    default:
                        chooseYN();
                }
            }
        }
        if(!check){
            System.out.println("Khong ton tai khach hang");
        }
    }

    private void deleteCustomer(){
        System.out.println("Nhap sdt khach hang: ");
        String number = sc.nextLine();
        boolean check = false;
        for (Customer ctm: customerDB.customerList) {
            if(ctm.getPhoneNumber().equals(number)){
                System.out.println("Xoa thong tin khach hang: ");
                System.out.println(ctm.toString());
                System.out.println();
                System.out.println("Ban muon xoa khach hang nay (Y(xoa)/Other(quay lai)) ?");
                switch (toUpperCase(sc.nextLine())){
                    case "Y":
                        customerDB.customerList.remove(ctm);
                        System.out.println("ban vua xoa khach hang < "+ctm.getName()+" > khoi he thong.");
                        check = true;
                        customerDB.write();
                        break;
                    default:
                        chooseYN();
                }
            }
        }
        if(!check){
            System.out.println("Khong ton tai khach hang");
        }
    }

    private void customerInformation(){
        System.out.println("Nhap sdt khach hang: ");
        String number = sc.nextLine();
        boolean check = false;
        for (Customer ctm: customerDB.customerList) {
            if(ctm.getPhoneNumber().equals(number)){
                System.out.println("Thong tin: ");
                System.out.println(ctm.toString());
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("Khong ton tai khach hang");
        }
    }
    private void listOfCustomerInformation(){
        for(Customer ctm : customerDB.customerList){
            System.out.printf("Khach hang:%7s | Dia chi:%15s | Email:%18s | SDT:%12s | Gioitinh:%3s | So don da mua: %2s\n",
                    ctm.getName(),ctm.getAddress(),ctm.getEmail(),ctm.getPhoneNumber(),ctm.getGender(),ctm.getNumOfOrdersPurchased());
        }
    }

    private void increaseOrders(){
        System.out.println("Nhap sdt khach hang: ");
        String number = sc.nextLine();
        boolean check = false;
        for (Customer ctm: customerDB.customerList) {
            if(ctm.getPhoneNumber().equals(number)){
                System.out.println("Nhap so don hang: ");
                ctm.setNumOfOrdersPurchased(ctm.getNumOfOrdersPurchased()+ sc.nextInt());
                sc.nextLine();
                System.out.println("Thong tin: ");
                System.out.println(ctm.toString());
                updateFile();
                check = true;
                break;

            }
        }
        if(!check){
            System.out.println("Khong ton tai khach hang");
        }
    }
}
