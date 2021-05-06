package com.contact_management.service;

import com.contact_management.data.ContactDB;
import com.contact_management.model.Contact;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactService {
    ContactDB contactDB = new ContactDB();
    Scanner sc = new Scanner(System.in);

    public void writeToFile() {
        contactDB.write();
    }

    public void loadFromFile(){
        contactDB.read();
    }

    public void readFromFile() {
        displayHeader();
        for (Contact ct: contactDB.contactList
             ) {
            ct.displayContact();
        }

    }


    public void searchContact() {
        boolean check = false;
        System.out.println("Nhap SDT tim kiem: ");
        String phoneNumber = sc.nextLine();
        for (Contact ct: contactDB.contactList) {
            if(ct.getPhoneNumber().equals(phoneNumber)){
                check = true;
                displayHeader();
                ct.displayContact();
            }
        }
        if(!check){
            System.out.println("Khong tim thay SDT !");
        }
    }

    public void deleteContact() {
        boolean check = false;
        System.out.println("Nhap SDT can xoa: ");
        String phoneNumber = sc.nextLine();
        for (int i = 0; i < contactDB.contactList.size(); i++) {
            if(contactDB.contactList.get(i).getPhoneNumber().equals(phoneNumber)){
                check = true;
                Contact temp = contactDB.contactList.get(i);
                contactDB.contactList.remove(contactDB.contactList.get(i));
                contactDB.write();
                displayHeader();
                temp.displayContact();
                System.out.println("Ban vua xoa <"+temp.getFullName()+"> khoi danh ba !");

            }
        }
        if(!check){
            System.out.println("Khong tim thay SDT !");
        }
    }

    public void updateContact() {
        System.out.println("Nhap SDT tim kiem: ");
        boolean check = false;
        String phoneNumber = sc.nextLine();
        for (Contact ct: contactDB.contactList) {
            if(ct.getPhoneNumber().equals(phoneNumber)){
                check = true;
                ct.setContactGroup(inputContactGroup());
                ct.setFullName(inputName());
                ct.setDob(inputDOB());
                ct.setAddress(inputAddress());
                ct.setEmail(inputEmail());
                contactDB.write();
                displayHeader();
                ct.displayContact();
                System.out.println("Ban vua cap nhat <"+ct.getFullName()+"> vao danh ba !");
            }
        }
        if(!check){
            System.out.println("Khong tim thay SDT !");
        }
    }

    public void addContact() {
        String phoneNumber = inputPhoneNumber();
        String name = inputName();
        String contactGroup = inputContactGroup();
        String dob = inputDOB();
        String address = inputAddress();
        String email = inputEmail();
        Contact contact = new Contact(0,phoneNumber,contactGroup,name,dob,address,email);
        contactDB.contactList.add(contact);
        contactDB.write();
        displayHeader();
        contact.displayContact();
        System.out.println("Ban vua them <"+name+"> vao danh ba !");

    }

    public void displayContactList() {

        int size = contactDB.contactList.size();
        if(size == 0){
            System.out.println("Danh ba trong !");
        }else {
            displayHeaderNonEmail();
            for (int i = 0; i < size; i++) {
                if(i==0 || (i)%5 != 0 ){
                    contactDB.contactList.get(i).displayContactNonEmail();
                }else {
                    System.out.print("Nhan enter de xem tiep ");
                    switch (sc.nextLine()){
                        case "":
                            displayHeaderNonEmail();
                            contactDB.contactList.get(i).displayContactNonEmail();
                            break;
                        default:
                            System.out.println("Exit !");
                            return;
                    }
                }
            }

        }

    }

    public String inputPhoneNumber(){
        String phoneNumber;
        do{
            System.out.println("Nhap SDT: ");
            phoneNumber = sc.nextLine();

        }while (!checkPhoneNumber(phoneNumber) || checkPhoneNumberExists(phoneNumber));

        return phoneNumber;
    }


    public boolean checkPhoneNumberExists(String phoneNumber){
        for (Contact ct: contactDB.contactList) {
            if(ct.getPhoneNumber().equals(phoneNumber)){
                System.out.println("Da ton tai trong danh ba !");
                return true;
            }
        }
        return false;
    }

    public boolean checkEmailExists(String email){
        for (Contact ct: contactDB.contactList) {
            if(ct.getEmail().equals(email) ){
                System.out.println("Da ton tai trong danh ba !");
                return true;
            }
        }
        return false;
    }



    public boolean checkPhoneNumber(String phoneNumber){
        String regex = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find()? true:false;
    }

    public String inputName(){
        System.out.println("Nhap ten: ");
        String name = toUpperCase(sc.nextLine());
        return name;
    }

    public boolean checkName(String name){
        String regex = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.find()? true:false;
    }


    public String inputContactGroup(){
        System.out.println("Nhap nhom danh ba: ");
        String contactGroup = toUpperCase(sc.nextLine());
        return contactGroup;
    }

    public String inputDOB(){
        String dob;
        do {
            System.out.println("Nhap ngay sinh: ");
            dob = sc.nextLine();
        }while (!checkDOB(dob));
        return dob;
    }

    public boolean checkDOB(String dob){
        String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/1|2[0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dob);
        return matcher.find()? true:false;
    }

    public String inputAddress(){
        System.out.println("Nhap dia chi: ");
        String address = toUpperCase(sc.nextLine());
        return address;
    }


    public String inputEmail(){
        String email;
        do{
            System.out.println("Nhap email: ");
            email = sc.nextLine();
        }while (!checkEmail(email) || checkEmailExists(email));

        return email;
    }

    public boolean checkEmail(String email){
        String regex = "^[a-zA-Z]+[a-zA-Z0-9]*@{1}+[\\w+mail]|[outlook]+.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find()? true:false;
    }



    public String toUpperCase(String string){
        char[] charArray = string.toCharArray();
        boolean foundSpace = true;
        for(int i = 0; i < charArray.length; i++) {
            charArray[i] = Character.toLowerCase(charArray[i]);
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

    public void displayHeader(){
        System.out.printf("|  %11s | %20s | %30s | %11s | %30s | %25s  |","So DT","Nhom danh ba","Ho ten","Ngay sinh","Dia chi","Email");
        System.out.println();
    }

    public void displayHeaderNonEmail(){
        System.out.printf("|  %11s | %20s | %30s | %11s | %30s  |","So DT","Nhom danh ba","Ho ten","Ngay sinh","Dia chi");
        System.out.println();
    }
}
