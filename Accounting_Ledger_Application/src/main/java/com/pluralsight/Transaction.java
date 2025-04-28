package com.pluralsight;

import java.io.*;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static ArrayList<Transaction> getAllTransactions(){  //Shows all entries
        ArrayList<Transaction> tra = new ArrayList<>();
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
            bufReader.readLine();
            String line;
            while((line = bufReader.readLine()) != null){
                String[] parts = line.split("\\|");
                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);
                Transaction transaction = new Transaction(date,time,description,vendor,amount);
                tra.add(transaction);
            }
            bufReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tra;
    }

    public static ArrayList<Transaction> getDeposits(){
        ArrayList<Transaction> transaction = new ArrayList<>();
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
            bufReader.readLine();
            String line;
            while ((line = bufReader.readLine()) != null){
                String[] parts = line.split("\\|");
                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);
                if (amount > 0) {
                    Transaction tra = new Transaction(date, time, description, vendor, amount);
                    transaction.add(tra);
                }
            }
            bufReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transaction;
    }

    public static ArrayList<Transaction> getPayments(){
        ArrayList<Transaction> transaction = new ArrayList<>();
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
            bufReader.readLine();
            String line;
            while ((line = bufReader.readLine()) != null){
                String[] parts = line.split("\\|");
                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);
                if (amount < 0) {
                    Transaction tra = new Transaction(date, time, description, vendor, amount);
                    transaction.add(tra);
                }
            }
            bufReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transaction;
    }

    public static ArrayList<Transaction> addDeposit(){  //Add new Deposit in file
        ArrayList<Transaction> transaction = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = time.format(timeFormatter);
            System.out.print("Enter description: ");
            String descr = sc.nextLine();
            System.out.print("Enter vendor: ");
            String ven = sc.nextLine();
            System.out.print("Enter amount: ");
            double am = sc.nextDouble();
            if (am > 0) {
                String line = date + "|" + formattedTime + "|" + descr + "|" + ven + "|" + am;
                Transaction transaction1 = new Transaction(date, time, descr, ven, am);
                transaction.add(transaction1);
                bufWriter.write(line);
                bufWriter.newLine();
                System.out.println("Added succesfully!");
            }
            else {
                System.out.println("The deposit cannot be a negative value!");

            }
            bufWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace(); // Выводим ошибку в случае неудачи
        }

        return transaction;
    }

    public static ArrayList<Transaction> addPayment(){  //Add new Deposit in file
        ArrayList<Transaction> transaction = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = time.format(timeFormatter);
            System.out.print("Enter description: ");
            String descr = sc.nextLine();
            System.out.print("Enter vendor: ");
            String ven = sc.nextLine();
            System.out.print("Enter amount: ");
            double am = sc.nextDouble();
            if (am < 0) {
                String line = date + "|" + formattedTime + "|" + descr + "|" + ven + "|" + am;
                Transaction transaction1 = new Transaction(date, time, descr, ven, am);
                transaction.add(transaction1);
                bufWriter.write(line);
                bufWriter.newLine();
                System.out.println("Added succesfully!");
            }
            else {
                System.out.println("The entered amount for a payment cannot be positive, it must be a negative value.!");

            }
            bufWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace(); // Выводим ошибку в случае неудачи
        }

        return transaction;
    }


}
