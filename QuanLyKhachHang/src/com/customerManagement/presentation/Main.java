package com.customerManagement.presentation;

import com.customerManagement.service.CustomerService;

public class Main {

    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        customerService.loadFile();
        customerService.status();
        customerService.chooseMenu();
    }
}
