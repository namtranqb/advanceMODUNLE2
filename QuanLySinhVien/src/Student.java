import java.util.Scanner;

public class Student extends Person {
    String rollNo;
    float mark;
    String email;

    public Student() {
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println(", ma SV: "+rollNo
                        +", DTB: "+ mark
                        +", email: "+email);
    }

    @Override
    public void inputInfo(){
        super.inputInfo();

        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ma sinh vien: ");
        while (true){
            String rollNoInput = input.nextLine();
            boolean check = setRollNo(rollNoInput);
            if(check){
                break;
            }

        }
        // code thu gon
//        while(!setRollNo(input.nextLine()));

        System.out.println("Nhap diem: ");
        while (true){
            float markInput = Float.parseFloat(input.nextLine());
            boolean check = setMark(markInput);
            if(check){
                break;
            }

        }

        System.out.println("Nhap email: ");
        while (true){
            String emailInput = input.nextLine();
            boolean check = setEmail(emailInput);
            if(check){
                break;
            }
        }
    }

    public String getRollNo() {
        return rollNo;
    }

    public boolean setRollNo(String rollNo) {
        if(rollNo != null && rollNo.length() == 8){
            this.rollNo = rollNo;
            return true;
        }else{
            System.err.println("Nhap lai ma sinh vien :");
            return false;
        }
    }

    public float getMark() {
        return mark;
    }

    public boolean setMark(float mark) {
        if(mark >= 0 && mark <= 10){
            this.mark = mark;
            return true;
        }else{
            System.err.println("Nhap lai diem (0 < diem < 10) :");
            return false;
        }


    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email != null && email.contains("@") && !email.contains(" ")){
            this.email = email;
            return true;
        }else{
            System.err.println("Nhap lai email: ");
            return false;
        }

    }

    public boolean checkScholarship(){
        return (mark >= 8)? true:false;

    }
}
