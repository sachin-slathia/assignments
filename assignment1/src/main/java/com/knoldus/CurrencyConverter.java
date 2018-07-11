package com.knoldus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class CurrencyConverter {
    static Scanner scan = new Scanner(System.in);

    private static void convertor(String to, String from, int amount) throws Exception {

        try {

            InputStream inputStream = CurrencyConverter.class.getClass()
                    .getResourceAsStream("/currencyinformation/information.xml");
            Properties property = new Properties();
            property.loadFromXML(inputStream);
            inputStream.close();
            Double result;
            if (from.equalsIgnoreCase("inr")) {
                result = Double.parseDouble(property.getProperty(to));
                System.out.println((double) amount * result);
            } else if (to.equalsIgnoreCase("inr")) {
               result = Double.parseDouble(property.getProperty(from));
                System.out.println((double) amount / result);
            } else {
                result = Double.parseDouble(property.getProperty(to));
                Double result1= Double.parseDouble(property.getProperty(from));
                System.out.println(result * (double) amount/ result1);
            }
        } catch (FileNotFoundException e ){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] var0) throws Exception {
        System.out.println("Available Currencies INR,USD,E,UKP,YEN,PESO");
        System.out.println("To");
        String to= scan.next();
        System.out.println("Enter amount to be converted");
        int amount = scan.nextInt();
        System.out.println("FROM");
        String from = scan.next();
        convertor(to,from,amount );
    }
}
