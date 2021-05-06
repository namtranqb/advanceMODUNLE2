package com.contact_management.presentation;

import com.contact_management.service.ContactService;


import java.util.Scanner;

public class Main {
    static Main main = new Main();
    static ContactService contactService = new ContactService();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        contactService.loadFromFile();
        main.status();
        main.chooseMenu();

    }

    public void status(){
        System.out.println("-----CHUONG TRINH QUAN LY DANH BA-----");
        System.out.println("Chon chuc nang theo so (de tiep tuc): ");
    }

    public void displayMenu(){
        System.out.println("\t1. Xem danh sach");
        System.out.println("\t2. Them moi");
        System.out.println("\t3. Cap nhat");
        System.out.println("\t4. Xoa");
        System.out.println("\t5. Tim kiem");
        System.out.println("\t6. Doc tu file");
        System.out.println("\t7. Ghi vao file");
        System.out.println("\t8. Thoat");
        System.out.println("--------------------------------------");


    }

    public void chooseMenu(){

        displayMenu();
        System.out.println("Chon chuc nang: ");
        String choose = sc.nextLine();

        switch (choose){
            case "1":
                contactService.displayContactList();
                chooseYN();
                break;
            case "2":
                contactService.addContact();
                chooseYN();
                break;
            case "3":
                contactService.updateContact();
                chooseYN();
                break;
            case "4":
                contactService.deleteContact();
                chooseYN();
                break;
            case "5":
                contactService.searchContact();
                chooseYN();
                break;
            case "6":
                contactService.readFromFile();
                chooseYN();
                break;
            case "7":
                contactService.writeToFile();
                chooseYN();
                break;
            case "8":
                System.exit(0);
            default:
                System.out.println("Nhap sai !");
                chooseMenu();
        }
    }

    public void chooseYN(){
        System.out.println("--------------------------------------");
        System.out.println("Chon Y(tiep tuc) / N(thoat) :");
        String chooseYN;
        do{
            chooseYN = sc.nextLine();
            switch (contactService.toUpperCase(chooseYN)){
                case "Y":
                    chooseMenu();
                    break;
                case "N":
                    System.out.println("Thoat");
                    System.exit(0);
                default:
                    chooseYN();
            }
        }while (true);
    }
}
