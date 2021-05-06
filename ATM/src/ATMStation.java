import java.util.Scanner;
import java.util.ArrayList;

public class ATMStation {
    private int balance = 0;
    private final int MIN_INPUT_MONEY = 10000;
    private final int MAX_INPUT_MONEY = 1000000000;
    private String accountHolder ;
    private ArrayList<String> transactionHistory = new ArrayList<>();

    public ATMStation(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public ATMStation(String accountHolder, int balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void welcomeToABCBank(){
        System.out.println("Ngan hang ABC kinh chao Quy khach "+accountHolder);

    }

    public void printsMenu() {
        System.out.println("Menu:");
        System.out.println("\t1. Nhan phim A de kiem tra tai khoan");
        System.out.println("\t2. Nhan phim D de nap tien");
        System.out.println("\t3. Nhan phim W de rut tien");
        System.out.println("\t4. Nhan phim H de xem lich su (3 giao dich gan nhat)");
        System.out.println("\t5. Nhan phim X de thoat");
        System.out.println("===========================================");
    }
    public void login(){
        welcomeToABCBank();
        choiceMenu();
    }

    public void choiceMenu() {
        Scanner sc = new Scanner(System.in);
        while (true){
            printsMenu();
            System.out.println("Nhap lua chon cua ban: ");
            String choice = sc.next();
            switch (choice) {
                case "A": {
                    balanceMessage();
                    continueDealMessage();
                    break;
                }

                case "D": {
                    inputMoneyToAccount();
                    balanceMessage();
                    continueDealMessage();
                    break;
                }

                case "W": {
                    withdrawMoneyFromAccount();
                    balanceMessage();
                    continueDealMessage();
                    break;
                }

                case "H": {
                    printTransactionHistory();
                    balanceMessage();
                    continueDealMessage();
                    break;
                }

                case "X": {
                    System.out.println("Cam on ban da su dung dich vu ATM");
                    System.exit(0);
                }
                default: {
                    System.out.println("Ban nhap sai chuc nang");
                    continueDealMessage();
                }
            }
        }
    }
    public void continueDealMessage(){
        Scanner sc = new Scanner(System.in);
        String choice = "";
            System.out.println("===========================================");
            System.out.println("Ban co muon tiep tuc giao dich ?");
            System.out.println(" Chon Y / N ");
            choice = sc.next();
            switch (choice){
                case "Y":{
                    choiceMenu();
                    break;
                }
                case "N":{
                    System.out.println("Cam on ban da su dung dich vu ATM");
                    System.exit(0);
                }
                default:
                    System.out.println("Ban nhap sai chuc nang");
                    continueDealMessage();
            }
    }


    public void balanceMessage(){

        System.out.println("\nSo du tai khoan khach hang la: "+getBalance()+" VND");
    }

    public void inputMoneyToAccount(){
        System.out.println("Giao dich Nap tien");
        System.out.println("Vui long nhap so tien:");
        int temp = inputMoney();
        int availableBalances = temp + getBalance();
        setBalance(availableBalances);

        System.out.print("Giao dich thanh cong. ");
        System.out.print("Ban vua nap "+temp+" VND thanh cong.");

        transactionHistory.add("Nap tien: "+ temp+" VND");
    }

    public int inputMoney(){
        Scanner sc = new Scanner(System.in);
        int money = 0;

        do{
            if(money != 0){
                System.out.println("So tien ban nhap khong dung : " + money+ " VND");
                System.out.println("Yeu cau nhap lai !");
            }
            money = sc.nextInt();

        }
        while (money <MIN_INPUT_MONEY || money > MAX_INPUT_MONEY);

        return money;
    }

    public void withdrawMoneyFromAccount(){
        System.out.println("Giao dich Rut tien");
        System.out.println("Vui long nhap so tien:");
        int temp = inputMoney();
        int availableBalances = getBalance() - temp;

        if( availableBalances < 0){
            System.out.println("Giao dich khong thanh cong");
            System.out.println("Ban khong the rut so tien hon so du tai khoan");
        }else{
            System.out.print("Giao dich thanh cong. ");
            System.out.print("Ban vua rut "+temp +" VND thanh cong.");
            setBalance(availableBalances);
            transactionHistory.add("Rut tien: "+temp+" VND");
        }
    }

    public void printAllTransactionHistory(){
        int numericalOrder =1;
        for (String i:transactionHistory)
            System.out.println(numericalOrder++ +". "+ i);
    }


    public void mostRecentTransactionHistory(){
        int numericalOrder =1;
        for (int i =transactionHistory.size() - 3 ; i < transactionHistory.size() ; i++)
            System.out.println(numericalOrder++ +". " +transactionHistory.get(i));
    }

    public void printTransactionHistory(){
        System.out.println("Lich su giao dich ");
        int countHistory = transactionHistory.size();
        if(countHistory > 3)
            mostRecentTransactionHistory();
        else
            printAllTransactionHistory();
    }





}
