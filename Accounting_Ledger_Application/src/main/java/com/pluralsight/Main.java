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
                System.out.print("Enter description: ");
                String descr = sc.nextLine();
                System.out.print("Enter vendor: ");
                String ven = sc.nextLine();
                System.out.print("Enter amount: ");
                double am = sc.nextDouble();
                Transaction.addDeposit(descr,ven,am);
            }
            else if (firstChoose == 2) {
                System.out.print("Enter description: ");
                String descr = sc.nextLine();
                System.out.print("Enter vendor: ");
                String ven = sc.nextLine();
                System.out.print("Enter amount: ");
                double am = sc.nextDouble();
                Transaction.addPayment(descr,ven,am);
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
                        if (deposits.isEmpty()){   //Check if line is null or not
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
                                        System.out.println(field.getDate() + " | " + field.getTime() + " | " + field.getDescription() + " | " + field.getVendor() + " | " + field.getAmount());
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
                                ArrayList<Transaction> filtered = Transaction.getYearToDate();
                                if (filtered.isEmpty()) {
                                    System.out.println("No transactions found for this year.");
                                } else {
                                    for (Transaction t : filtered) {
                                        System.out.println(t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | " + t.getAmount());
                                    }
                                }
                            } else if (thirdChoose == 4) {
                                ArrayList<Transaction> previousYear = Transaction.getPreviousYear();
                                if(previousYear.isEmpty()){
                                    System.out.println("No transactions found for the previous year.");
                                }
                                else{
                                    for(Transaction t : previousYear){
                                        System.out.println(t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | " + t.getAmount());
                                    }
                                }
                            } else if (thirdChoose == 5) {
                                System.out.print("Enter vendor name to search: ");
                                String vendorName = sc.nextLine();
                                ArrayList<Transaction> results = Transaction.searchByVendor(vendorName);
                                if (results.isEmpty()) {
                                    System.out.println("No transactions found for vendor: " + vendorName);
                                } else {
                                    for (Transaction t : results) {
                                        System.out.println(t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | " + t.getAmount());
                                    }
                                }
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