package org.example;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DCommands dCommands = new DCommands();
        String login;
        String password;
        int id;
        while (true) {
            System.out.println("Choose command: info, add, delete,update");
            String userDecision = scan.next();
            if (userDecision.equals("info")) {
                dCommands.infoRecords();
            } else if (userDecision.equals("add")) {
                System.out.println("Write down the login");
                login = scan.next();
                System.out.println("Write down the password");
                password = scan.next();
                dCommands.addRecord(login, password);
            } else if (userDecision.equals("delete")) {
                System.out.println("Write down the login");
                login = scan.next();
                System.out.println("Write down the password");
                password = scan.next();
                dCommands.deleteRecord(login, password);
            } else if (userDecision.equals("update")) {
                System.out.println("Write down the id of the record which you want to change");
                id = scan.nextInt();
                System.out.println("Write down the login");
                login = scan.next();
                System.out.println("Write down the password");
                password = scan.next();
                dCommands.updateRecord(login, password,id);
            }else{
                System.out.println("Error repeat!");
            }
        }
    }
}