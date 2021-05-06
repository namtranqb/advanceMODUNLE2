package com.studentManagement.dal;

import com.studentManagement.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDB {
    Scanner sc = new Scanner(System.in);
    public List<Student> studentList = new ArrayList<>();
    public final String STUDENT_FILE = "Student.csv";
    File file = new File(STUDENT_FILE);
    private int count = 0;

    public void write(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(STUDENT_FILE);
            bufferedWriter = new BufferedWriter(fileWriter);
            count = 0 ;
            for (Student st: studentList) {
                st.setNumber(++count);
                bufferedWriter.write(st.toStringCSV());


            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    public void read(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(STUDENT_FILE);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                String[] str = line.split(",");
                Student student = new Student(Integer.parseInt(str[0]),str[1],str[2],str[3],str[4],Float.parseFloat(str[5]),Float.parseFloat(str[6]),Float.parseFloat(str[7]),Float.parseFloat(str[8]));
                add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void add(Student student){
        student.setNumber(++count);
        studentList.add(student);
    }



}
