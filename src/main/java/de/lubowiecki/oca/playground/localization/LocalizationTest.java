package de.lubowiecki.oca.playground.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationTest {

    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("keys", Locale.ENGLISH);
        System.out.println(bundle.getString("btn1"));
        System.out.println(bundle.getString("btn2"));
        System.out.println(bundle.getString("btn3"));


    }
}
