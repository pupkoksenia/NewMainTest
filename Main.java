package com.bsu.by;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> arrayOfLinesUsers = Realisation.readFromFile("C:\\Users\\MainTest\\users.txt");
        List<String> arrayOfLinesAircrafts = Realisation.readFromFile("C:\\Users\\MainTest\\aircrafts.txt");

        List<User> listOfUsers = Realisation.createListOfUsers(arrayOfLinesUsers);
        List<Aircraft> listOfAircrafts = Realisation.createListOfAircrafts(arrayOfLinesAircrafts);


        Scanner sc = new Scanner(System.in);
        System.out.println("\n" +
                "If you want to register write-0," + "\n" +
                "login (login and password)-1\n" +
                "view all product records-2\n" +
                "aircraft search by number (only for admin)-3\n" +
                "displaying statistics for each airline: how many planes,average quality rating-4\n" +
                "exit-5\n"
        );
        int choice = sc.nextInt();

        switch (choice) {
            case 0:
                Cases.case0(sc, listOfUsers);
                if (Cases.exit(sc)) break;
            case 1:
                Cases.case1(sc, listOfUsers);
                if (Cases.exit(sc)) break;
            case 2:
                Cases.case2(listOfAircrafts);
                if (Cases.exit(sc)) break;
            case 3:
                System.out.println("Write number");
                int number = sc.nextInt();
                boolean isStatusAdmin = Cases.isStatusAdmin(listOfUsers, sc);
                Cases.case3(isStatusAdmin, listOfAircrafts, number);
                if (Cases.exit(sc)) break;
            case 4:
                Cases.case4(listOfAircrafts);
                if (Cases.exit(sc)) break;
        }
        sc.close();

    }


}
