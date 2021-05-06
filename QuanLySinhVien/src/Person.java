import java.sql.SQLOutput;
import java.util.Scanner;

public class Person {
    String name;
    String gender;
    String birthday;
    String address;

    public Person() {
    }

    public Person(String name, String gender, String birthday, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public void inputInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        name = sc.nextLine();

        System.out.println("Nhap gioi tinh: ");
        gender = sc.nextLine();

        System.out.println("Nhap nam sinh: ");
        birthday = sc.nextLine();

        System.out.println("Nhap dia chi: ");
        address = sc.nextLine();
    }

    public void showInfo(){
        System.out.println("Ten: "+name
                +", gioi tinh: "+gender
                +", ngay sinh: "+birthday
                +", dia chi: "+address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
