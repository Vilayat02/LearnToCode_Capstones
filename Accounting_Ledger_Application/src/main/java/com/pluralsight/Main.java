package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> tra = Transaction.getAllTransactions();
        ArrayList<Transaction> transactions = new ArrayList<>();
        boolean run = true;
        while (run){
            System.out.println("\n1.Add deposit\n2.Make Payment (Debit)\n3.Ledger\n4.Exit");
            int firstChoose = sc.nextInt();
            sc.nextLine();
            if (firstChoose == 1){
                Transaction.addDeposit();
                System.out.println("Added succesfully!");
            }
            else if (firstChoose == 2) {

            }
            else if (firstChoose == 3){
                boolean run2 = true;
                while(run2) {
                    System.out.println("\n1.All\n2.Deposits\n3.Payments\n4.Reports\n5.Home");
                    int secondChoose = sc.nextInt();
                    sc.nextLine();
                    if (secondChoose == 1) {
                        for (Transaction field : tra) {
                            System.out.println(field.getDate() + " | " + field.getTime() + " | " + field.getDescription() + " | " + field.getVendor() + " | " + field.getAmount());
                        }
                    } else if (secondChoose == 2) {

                    } else if (secondChoose == 3) {

                    } else if (secondChoose == 4) {

                    } else if (secondChoose == 5) {
                        run2 = false;
                    } else {
                        System.out.println("Wrong choice!");
                    }
                }

            }
            else if (firstChoose == 4){
                run = false;
            }
        }

    }
}
