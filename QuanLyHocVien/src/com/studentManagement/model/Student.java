package com.studentManagement.model;

public class Student {
    private int number;
    private String id;
    private String name;
    private String dob;
    private String gender;
    private float scoreFactor1_1;
    private float scoreFactor1_2;
    private float scoreFactor2;
    private float scoreFactor3;

    public Student() {

    }

    public Student(String id, String name, String dob, String gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public Student(int number, String id, String name, String dob, String gender, float scoreFactor1_1, float scoreFactor1_2, float scoreFactor2, float scoreFactor3) {
        this.number = number;
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.scoreFactor1_1 = scoreFactor1_1;
        this.scoreFactor1_2 = scoreFactor1_2;
        this.scoreFactor2 = scoreFactor2;
        this.scoreFactor3 = scoreFactor3;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
            this.dob = dob;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getScoreFactor1_1() {
        return scoreFactor1_1;
    }

    public void setScoreFactor1_1(float scoreFactor1_1) {
        this.scoreFactor1_1 = scoreFactor1_1;
    }

    public float getScoreFactor1_2() {
        return scoreFactor1_2;
    }

    public void setScoreFactor1_2(float scoreFactor1_2) {
        this.scoreFactor1_2 = scoreFactor1_2;
    }

    public float getScoreFactor2() {
        return scoreFactor2;
    }

    public void setScoreFactor2(float scoreFactor2) {
        this.scoreFactor2 = scoreFactor2;
    }

    public float getScoreFactor3() {
        return scoreFactor3;
    }

    public void setScoreFactor3(float scoreFactor3) {
        this.scoreFactor3 = scoreFactor3;
    }

    public float getMediumScore() {
        float mediumScore = (scoreFactor1_1 + scoreFactor1_2 + (scoreFactor2 * 2) + (scoreFactor3 * 3))/7;
        return mediumScore;
    }

    public String toStringCSV(){
        return number+","+id+","+name+","+ dob +","+gender+","+scoreFactor1_1+","+scoreFactor1_2+","+scoreFactor2+","+scoreFactor3+","+getMediumScore()+"\n";
    }


    public void displayStudentInformation() {
        System.out.printf("| %3d | %4s | %20s | %12s | %10s | %12.02f | %12.02f | %12.02f | %12.02f | %12.02f |"
                ,number,id,name, dob,gender,scoreFactor1_1,scoreFactor1_2,scoreFactor2,scoreFactor3,getMediumScore());
        System.out.println();
    }

}
