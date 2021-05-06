package com.contact_management.data;

import com.contact_management.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDB {
    public final String FILE_CONTACT = "src/Contacts.csv";
    int countContact = 0;
    private File file = new File(FILE_CONTACT);
    public List<Contact> contactList = new ArrayList<>();

    public void write(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(FILE_CONTACT);
            bufferedWriter = new BufferedWriter(fileWriter);
            countContact = 0;
            for(Contact ct:contactList){
                ct.setSerialContact(++countContact);
                bufferedWriter.write(ct.toStringCSV());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void add(Contact contact){
        contact.setSerialContact(++countContact);
        contactList.add(contact);
    }

    public void read(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(FILE_CONTACT);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                String[] string = line.split(",");
                Contact contact = new Contact(Integer.parseInt(string[0]),string[1],string[2],string[3],string[4],string[5],string[6]);
                add(contact);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
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
