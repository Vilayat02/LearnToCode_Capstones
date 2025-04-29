package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run){
            System.out.println("\n1.Add deposit\n2.Make Payment (Debit)\n3.Ledger\n4.Exit");
            int firstChoose = sc.nextInt();
            sc.nextLine();
            if (firstChoose == 1){
                Transaction.addDeposit();
            }
            else if (firstChoose == 2) {
                Transaction.addPayment();
            }
            else if (firstChoose == 3){
                boolean run2 = true;
                while(run2) {
                    System.out.println("\n1.All\n2.Deposits\n3.Payments\n4.Reports\n5.Home");
                    int secondChoose = sc.nextInt();
                    sc.nextLine();
                    if (secondChoose == 1) {
                        ArrayList<Transaction> tra = Transaction.getAllTransactions();
                        for (Transaction field : tra) {
                            System.out.println(field.getDate() + " | " + field.getTime() + " | " + field.getDescription() + " | " + field.getVendor() + " | " + field.getAmount());
                        }
                    } else if (secondChoose == 2) {
                        ArrayList<Transaction> deposits = Transaction.getDeposits();
                        if (deposits.isEmpty()){
                            System.out.println("Deposits not found");
                        }
                        else {
                            for (Transaction field : deposits) {
                                System.out.println(field.getDate() + " | " + field.getTime() + " | " + field.getDescription() + " | " + field.getVendor() + " | " + field.getAmount());
                            }
                        }
                    } else if (secondChoose == 3) {
                        ArrayList<Transaction> payments = Transaction.getPayments();
                        if (payments.isEmpty()){
                            System.out.println("Payments not found");
                        }
                        else {
                            for (Transaction field : payments) {
                                System.out.println(field.getDate() + " | " + field.getTime() + " | " + field.getDescription() + " | " + field.getVendor() + " | " + field.getAmount());
                            }
                        }
                    } else if (secondChoose == 4) {
                        boolean run3 = true;
                        while(run3) {
                            System.out.println("Search by:\n1.Month to Date\n2.Previous Month\n3.Year to Date\n4.Previous Year\n5.Search by Vendor\n0.Back");
                            int thirdChoose = sc.nextInt();
                            sc.nextLine();
                            if (thirdChoose == 1) {
                                ArrayList<Transaction> filtered = Transaction.getMonthToDate();
                                if (filtered.isEmpty()) {
                                    System.out.println("No transactions found in this range.");
                                } else {
                                    for (Transaction field : filtered) {
                                        System.out.println(field.getDate() + " | " +
                                                field.getTime() + " | " +
                                                field.getDescription() + " | " +
                                                field.getVendor() + " | " +
                                                field.getAmount());
                                    }
                                }
                            } else if (thirdChoose == 2) {
                                ArrayList<Transaction> filtered = Transaction.getPreviousMonth();
                                if (filtered.isEmpty()) {
                                    System.out.println("No transactions found in previous month.");
                                } else {
                                    for (Transaction field : filtered) {
                                        System.out.println(field.getDate() + " | " + field.getTime() + " | " + field.getDescription() + " | " + field.getVendor() + " | " + field.getAmount());
                                    }
                                }
                            } else if (thirdChoose == 3) {

                            } else if (thirdChoose == 4) {

                            } else if (thirdChoose == 5) {

                            } else if (thirdChoose == 0) {
                                run3 = false;
                            } else {
                                System.out.println("Wrong option!");
                            }
                        }
                    } else if (secondChoose == 5) {
                        run2 = false;
                    } else {
                        System.out.println("Wrong choice!");
                    }
                }

            }
            else if (firstChoose == 4){
                run = false;
                System.out.println("Closing...");
            }
        }

    }
}
