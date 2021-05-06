package com.customerManagement.dal;

import com.customerManagement.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerDB {
    Scanner sc = new Scanner(System.in);
    public List<Customer> customerList = new ArrayList<>();
    public final String CUSTOMER_FILE = "Customer.csv";
    File file = new File(CUSTOMER_FILE);

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
            fileWriter = new FileWriter(CUSTOMER_FILE);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Customer ctm: customerList) {
                bufferedWriter.write(ctm.toStringCSV());
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
            fileReader = new FileReader(CUSTOMER_FILE);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                Customer customer = new Customer();
                customer.split(line);
                customerList.add(customer);
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



}
