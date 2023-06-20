package de.lubowiecki.oca.playground.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationTest {

    public static void main(String[] args) {

        // Es werden passende properties Dateien als auch Java-Dateien (ListResourceBundles) geladen

        ResourceBundle bundle = ResourceBundle.getBundle("de.lubowiecki.keys", Locale.ENGLISH);

        //BaseName muss fully quallified vorgegeben werden d.h. inkl package
        // bundle = ResourceBundle.getBundle("keys"); // Verwendet Default-Locale
        System.out.println(bundle.getString("btn1"));
        System.out.println(bundle.getString("btn2"));
        System.out.println(bundle.getString("btn3"));


    }
}
