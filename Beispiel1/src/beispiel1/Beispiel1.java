/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beispiel1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author dfischer17
 */
public class Beispiel1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDateTime beforeDate = LocalDateTime.of(2018, Month.JANUARY, 1, 0, 0);
        LocalDateTime afterDate = LocalDateTime.of(2019, Month.JANUARY, 1, 0, 0);

//        // 1.1)
//        execute11(beforeDate, afterDate);
//
//        // 1.2)
//        execute12(afterDate, afterDate);
        
        // 1.3)
        execute13();
    }

    private static void execute11(LocalDateTime a, LocalDateTime b) {
        long years = ChronoUnit.YEARS.between(a, b);
        long months = ChronoUnit.MONTHS.between(a, b);
        long days = ChronoUnit.DAYS.between(a, b);
        long hours = ChronoUnit.HOURS.between(a, b);
        long minutes = ChronoUnit.MINUTES.between(a, b);
        long seconds = ChronoUnit.SECONDS.between(a, b);

        System.out.println("Jahre " + years);
        System.out.println("Monate " + months);
        System.out.println("Tage " + days);
        System.out.println("Minuten " + minutes);
        System.out.println("Sekunden " + seconds);
    }

    private static void execute12(LocalDateTime a, LocalDateTime b) {
        while (!a.equals(b)) {
            a = a.plusDays(1);
            System.out.println("Ausgabe Tage zwischen beforeDate und afterDate:" + a.format(DateTimeFormatter.ISO_DATE));;
        }
    }

    private static void execute13() {
        Scanner scanner = new Scanner(System.in);
        String input;
        LocalDateTime result;

        // Eingabe von Nutzer einlesen
        System.out.println("Geben Sie ein Datum im Format [yyyy.MM.dd.hh.mm.ss] ein:");
        input = scanner.next();

        // Eingabe splitten
        String[] temp = input.split("\\.");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);
        int hour = Integer.parseInt(temp[3]);
        int minute = Integer.parseInt(temp[4]);
        int second = Integer.parseInt(temp[5]);

        // LocalDateTime aus Eingabe erstellen                
        result = LocalDateTime.of(year, month, day, hour, minute, second);
        
        // Nutzer ueber Speicherung informieren
        System.out.println("Sie haben folgendes Datum gespeichert:" + result.format(DateTimeFormatter.ISO_DATE));
    }
}
