package com.bsu.by;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Realisation {
    public static List<String> readFromFile(String fileName) throws IOException {
        List<String> arrayOfLines = new ArrayList<String>();
        FileReader readerOfUsers = new FileReader(fileName);
        try (BufferedReader bufReaderOfUsers = new BufferedReader(readerOfUsers)) {
            String line;
            while ((line = bufReaderOfUsers.readLine()) != null) {
                arrayOfLines.add(line);
            }
            bufReaderOfUsers.close();
            readerOfUsers.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return arrayOfLines;
    }


    public static List<User> createListOfUsers(List<String> arrayOfLinesUsers) throws IOException {
        List<User> listOfUsers = new ArrayList<User>();
        int i = 0;
        while (i < arrayOfLinesUsers.size()) {
            User user = new User(arrayOfLinesUsers.get(i), arrayOfLinesUsers.get(i + 1), arrayOfLinesUsers.get(i + 2), arrayOfLinesUsers.get(i + 3), arrayOfLinesUsers.get(i + 4));
            listOfUsers.add(user);
            i += 5;
        }
        return listOfUsers;
    }


    public static List<Aircraft> createListOfAircrafts(List<String> arrayOfLinesAircrafts) throws IOException {
        List<Aircraft> ListOfProducts = new ArrayList<Aircraft>();
        int i = 0;
        while (i < arrayOfLinesAircrafts.size()) {
            Aircraft acrft = new Aircraft(arrayOfLinesAircrafts.get(i), arrayOfLinesAircrafts.get(i + 1), arrayOfLinesAircrafts.get(i + 2), arrayOfLinesAircrafts.get(i + 3), arrayOfLinesAircrafts.get(i + 4), arrayOfLinesAircrafts.get(i + 5), arrayOfLinesAircrafts.get(i + 6));
            ListOfProducts.add(acrft);
            i += 7;
        }
        return ListOfProducts;
    }

}
