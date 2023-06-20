package de.lubowiecki.oca.playground.localization;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormat {

    public static void main(String[] args) {

        Instant start = Instant.now();

        LocalDate ld = LocalDate.now();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MMM.yyyy");
        // fmt = DateTimeFormatter.ofPattern("HH:mm"); // Exception: ist im Datum nicht drin
        System.out.println(fmt.format(ld));
        System.out.println(ld.format(fmt));

        // Locale.GERMAN // Nur Sprache
        // Locale.GERMANY // Sprache und ländertypische Schreibweisen für Zahlen und Datum

        Locale.setDefault(Locale.US); // Ändert die Standardsprache
        // Locale.setDefault(Locale.FRANCE);

        fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(fmt.format(ld));
        fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(ld.format(fmt));
        fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(ld.format(fmt));
        fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(ld.format(fmt));

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);

        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        zdt = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("Asia/Tokyo"));
        System.out.println(zdt);

        System.out.println();

        Instant ende = Instant.now();

        Duration dur = Duration.between(start, ende);
        System.out.println(dur.toMillis());

        LocalTime lt1 = LocalTime.now();
        LocalTime lt2 = LocalTime.of(12, 25);
        System.out.println(Duration.between(lt1, lt2));

        Locale.Builder builder = new Locale.Builder();
        Locale loc = builder.setLanguage("de").setRegion("DE").build();

        System.out.println();

        Locale.setDefault(Locale.GERMANY);

        System.out.println(loc.getCountry());
        System.out.println(loc.getDisplayCountry()); // Verwendet das Default-Locale
        System.out.println(loc.getDisplayCountry(Locale.CHINESE));

    }
}
