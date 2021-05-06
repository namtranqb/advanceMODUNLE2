package com.studentManagement.presentation;

import com.studentManagement.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.loadFile();
        studentService.status();
        studentService.chooseMenu();
    }
}
