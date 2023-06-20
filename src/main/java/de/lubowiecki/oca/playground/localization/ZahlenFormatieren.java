package de.lubowiecki.oca.playground.localization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ZahlenFormatieren {

    public static void main(String[] args) {

        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String str = simpleDateFormat.format(date);
        System.out.println(str);

        try {
            date = simpleDateFormat.parse("10.05.1999");
            System.out.println(date);
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        System.out.println(String.format("%.2f", 100019.12345)); // Default Locale wird genutzt

        DecimalFormat decimalFormat = new DecimalFormat();
        System.out.println(decimalFormat.format(100019.12345)); // Default Locale wird genutzt

        //NumberFormat nf = NumberFormat.getCurrencyInstance();
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(nf.format(100019.12345));

        //nf = NumberFormat.getNumberInstance();
        nf = NumberFormat.getNumberInstance(Locale.GERMANY);
        System.out.println(nf.format(100019.12345));

        try {
            Number n = nf.parse("10.000,25");
            int i = n.intValue();
            double d = n.doubleValue();
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
