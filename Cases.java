package com.bsu.by;

import java.io.IOException;
import java.util.*;

public class Cases {
    public static User registerOfUser(List<String> arrayOfLinesOfOneUsers) throws IOException {
        return Realisation.createListOfUsers(arrayOfLinesOfOneUsers).get(0);
    }
    public static void case0(Scanner sc, List<User> ListOfUsers) throws IOException {
        System.out.println("You are registering:\n" +
                "Write userName\n" +
                "login\n" +
                "email\n" +
                "password\n" +
                "role(user)");
        List<String> arrayOfLinesOfOneUser = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayOfLinesOfOneUser.add(sc.nextLine());
        }
        String remove = arrayOfLinesOfOneUser.remove(0);
        for (int i = 0; i < ListOfUsers.size(); i++) {
            if (!ListOfUsers.get(i).getUserName().equalsIgnoreCase(arrayOfLinesOfOneUser.get(0))) {
                ListOfUsers.add(registerOfUser(arrayOfLinesOfOneUser));
                break;
            }
        }
    }
    public static void case1(Scanner sc, List<User> listOfUsers) throws IOException {
        System.out.println(
                "You are logging in:\n" +
                        "Write login\n" +
                        "password\n"
        );
        String s = sc.nextLine();
        String login = sc.nextLine();
        String password = sc.nextLine();

        int sum = 0;
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (login.equalsIgnoreCase(listOfUsers.get(i).getLogin()) &&
                    password.equalsIgnoreCase(listOfUsers.get(i).getPassword())) {
                sum++;
            }
        }
        if (sum == 0) {
            System.out.println("You are not registered");
        }
    }
    public static void case2(List<Aircraft> listOfAircrafts) {
        for (Aircraft ar : listOfAircrafts) {
           System.out.println(ar.toString());
        }
    }
    public static boolean exit(Scanner sc) {
        System.out.println("If you want to exit choose 5,else choose 9 ");
        int res = sc.nextInt();
        if (res == 5) {
            return true;
        } else return false;

    }


    public static boolean isStatusAdmin(List<User> ListOfUsers, Scanner sc) throws IOException {
        System.out.println("Write login\n");
        String s = sc.nextLine();
        String login = sc.nextLine();


        for (User user : ListOfUsers) {
            if (login.equalsIgnoreCase(user.getLogin())) {
                    return user.getRole().equals("admin");
            }
        }
        return false;
    }
    public static void case3(boolean isStatusAdmin, List<Aircraft> ListOfAircafts, int number) {
        if (isStatusAdmin) {
            for (Aircraft ar : ListOfAircafts) {
                if (number == ar.getNumber()) {
                   System.out.println(ar.toString());
                }
            }
        }
    }

    public static void case4(List<Aircraft> ListOfAircafts) {
        Map<String, Integer> nameOfCompany = new HashMap<String, Integer>();
        Map<String, Double> n = new HashMap<String, Double>();
        for (Aircraft ar : ListOfAircafts) {

            String a = ar.getNameOfCompany();
            int count = isInArray(nameOfCompany, a);
            if (!nameOfCompany.containsKey(a)) {
                nameOfCompany.put(a, count);
                double q = getQualityResults(a, ListOfAircafts);
                n.put(a, q);
            } else nameOfCompany.replace(a, count);
        }
        for (Map.Entry<String, Integer> entry : nameOfCompany.entrySet()) {
            System.out.println("name of company is = " + entry.getKey() + ", amount of aircrafts is = " + entry.getValue() +
                    ", average quality rating is= " + n.get(entry.getKey()) / entry.getValue());
        }

    }

    public static int isInArray(Map<String, Integer> nameOfCompany, String arNameOfCompany) {
        int count = 1;

        Set<String> names = nameOfCompany.keySet();
        for (String n : names) {
            if (arNameOfCompany.equals(n)) {
                count++;

            }
        }
        return count;
    }

    public static Double getQualityResults(String arNameOfCompany, List<Aircraft> ListOfAircafts) {
        double count = 0;


        for (Aircraft a : ListOfAircafts) {
            if (arNameOfCompany.equals(a.getNameOfCompany())) {
                count += a.getQualityControl();
            }
        }
        return count;
    }
}
