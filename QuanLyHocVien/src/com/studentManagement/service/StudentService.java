package com.studentManagement.service;
import com.studentManagement.dal.StudentDB;
import com.studentManagement.model.Student;
import java.util.*;

public class StudentService {
    StudentDB studentDB = new StudentDB();
    Scanner sc = new Scanner(System.in);

    public void loadFile(){
        studentDB.read();
    }

    public void updateFile(){
        studentDB.write();
    }

    public void status(){
        System.out.println("--Chao mung ban den voi he thong quan ly hoc vien--");
    }

    public void displayMenu(){
        System.out.println("\t1. Xem danh sach hoc vien");
        System.out.println("\t2. Them hoc vien");
        System.out.println("\t3. Sua thong tin hoc vien");
        System.out.println("\t4. Xoa hoc vien");
        System.out.println("\t5. Nhap diem hoc vien");
        System.out.println("\t6. Sua nhap diem hoc vien");
        System.out.println("\t7. Xep loai hoc vien");
        System.out.println("\t0. Thoat");

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
                displayStudentList();
                chooseYN();
                break;
            case "2":
                addStudent();
                chooseYN();
                break;
            case "3":
                editStudent();
                chooseYN();
            case "4":
                deleteStudent();
                chooseYN();
                break;
            case "5":
                inputScore();
                chooseYN();
                break;
            case "6":
                editScore();
                chooseYN();
                break;
            case "7":
                studentSort();
                chooseYN();
                break;
            case "0":
                System.out.println("Thoat");
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
                    System.out.println("Thoat");
                    System.exit(0);
                default:
                    chooseYN();
            }
        }while (true);
    }

    public String inputStudentID(){
        System.out.println("Nhap ID hoc vien: ");
        while(!sc.hasNextLine()){
            System.out.println("Khong tim thay hoc vien. Yeu cau nhap lai: ");
        }
        String id = sc.nextLine();
        for (Student std: studentDB.studentList) {
            if((std.getId().equals(id))){
                System.out.println("Trung ID !!");
                inputStudentID();
            }
        }
        return id;
    }

    public String inputStudentName(){
        String name;
        do{
            System.out.println("Nhap ten: ");
            name = toUpperCase(sc.nextLine());
        }while (name == null);
        return name;
    }
    public String inputStudentDOB(){
        System.out.println("Nhap ngay sinh: ");
        String dob = sc.nextLine();

        return dob;
    }

    public String inputStudentGender(){
        System.out.println("Nhap gioi tinh: ");
        String gender = toUpperCase(sc.nextLine());
        return gender;
    }


    public Student inputStudentInformation(){

        String id = inputStudentID();
        String name = inputStudentName();
        String dateOfBirth = inputStudentDOB();
        String gender = inputStudentGender();

        Student student = new Student(id,name,dateOfBirth,gender);
        return student;
    }

    public void setStudentScore(Student student){
        System.out.println("nhap diem HS1(1):");
        student.setScoreFactor1_1(scoreStudent());

        System.out.println("nhap diem HS1(2):");
        student.setScoreFactor1_2(scoreStudent());

        System.out.println("nhap diem HS2:");
        student.setScoreFactor2(scoreStudent());

        System.out.println("nhap diem HS3:");
        student.setScoreFactor3(scoreStudent());
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

    public void displayStatus(){
        System.out.printf("| %3s | %4s | %20s | %12s | %10s | %12s | %12s | %12s | %12s | %12s |"
                ,"STT","MaHV","Ten","Ngay sinh","Gioi tinh","Diem HS1(1)","Diem HS1(2)","Diem HS2","Diem HS3","Diem TB");
        System.out.println();
    }



    private void studentSort() {
        Collections.sort(studentDB.studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getMediumScore() >= o2.getMediumScore()) ? -1 : 1;
            }
        });
        displayStatus();
        for (int i = 0; i < studentDB.studentList.size(); i++) {
            studentDB.studentList.get(i).displayStudentInformation();
            System.out.println();
        }
    }

    private void editScore() {
        System.out.println("Nhap ID hoc vien: ");
        String id = sc.nextLine();
        boolean check = false;
        for (Student student: studentDB.studentList) {
            if (student.getId().equals(id)) {
                student.displayStudentInformation();
                System.out.println();

                setStudentScore(student);
                updateFile();
                displayStudentList();
                chooseYN();


            }
        }
    }

    private float scoreStudent() {
        float score;
        do {
            System.out.println("(0 <= Diem <= 10) ");
            score = sc.nextFloat();
        } while (!checkSc(score));
        sc.nextLine();
        return score;
    }

    private boolean checkSc(float score){
       return (score < 0 || score > 10.0) ? false:true;
    }


    private void inputScore() {
        System.out.println("Nhap ID hoc vien: ");
        String id = sc.nextLine();
        boolean check = false;
        for (Student student: studentDB.studentList) {
            if (student.getId().equals(id)) {
                check = true;
                student.displayStudentInformation();

                if(student.getMediumScore() > 0){
                    System.out.println("HS nay da duoc nhap diem !");
                    chooseYN();
                }else{
                    setStudentScore(student);
                    updateFile();
                    displayStudentList();
                    chooseYN();
                }

            }
        }
        if(!check){
            System.out.println("Khong tim thay hoc vien");
        }
    }

    private void deleteStudent() {
        System.out.println("Nhap ID hoc vien: ");
        String id = sc.nextLine();
        boolean check = false;
        for (Student student: studentDB.studentList) {
            if(student.getId().equals(id)){
                System.out.println("Xoa thong tin hoc vien: ");
                displayStatus();
                student.displayStudentInformation();
                System.out.println("Ban muon xoa thong tin hoc vien nay (Y(xoa)/Other(quay lai)) ?");
                switch (toUpperCase(sc.nextLine())){
                    case "Y":
                        studentDB.studentList.remove(student);
                        check = true;
                        displayStudentList();
                        studentDB.write();
                        chooseYN();
                        break;
                    default:
                        chooseYN();
                }
            }
        }
        if(!check){
            System.out.println("Khong tim thay hoc vien");
        }
    }


    private void editStudent() {

        System.out.println("Nhap ID hoc vien: ");
        String id = sc.nextLine();
        boolean check = false;
        for (Student student: studentDB.studentList) {
            if(student.getId().equals(id)){
                System.out.println("Sua thong tin hoc vien: ");
                displayStatus();
                student.displayStudentInformation();

                System.out.println("Ban muon sua thong tin hoc vien nay (Y(sua)/Other(quay lai)) ?");
                switch (toUpperCase(sc.nextLine())){
                    case "Y":
                        student.setName(inputStudentID());
                        student.setDob(inputStudentDOB());
                        student.setGender(inputStudentGender());
                        setStudentScore(student);
                        System.out.println("Lam moi thong tin hoc vien: ");
                        displayStatus();
                        student.displayStudentInformation();

                        check = true;
                        studentDB.write();
                        break;
                    default:
                        chooseYN();
                }
            }
        }
        if(!check){
            System.out.println("Khong tim thay hoc vien");
        }
    }

    private void addStudent() {
        Student student = inputStudentInformation();
        studentDB.studentList.add(student);
        studentDB.write();
        displayStatus();
        student.displayStudentInformation();

    }


    private void displayStudentList(){
        displayStatus();
        sortByNumber();

    }
    private void sortByNumber() {
        Collections.sort(studentDB.studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getNumber() >= o2.getNumber()) ? 1 : -1;
            }
        });

        for (int i = 0; i < studentDB.studentList.size(); i++) {
            studentDB.studentList.get(i).displayStudentInformation();

        }

    }


    private void sortByID(){
        Collections.sort(studentDB.studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getId().compareTo(o2.getId()) >= 0 ){
                    return 1;
                }
                return -1;

            }
        });
        for (int i = 0; i< studentDB.studentList.size();i++) {
            studentDB.studentList.get(i).displayStudentInformation();

        }
    }



}
