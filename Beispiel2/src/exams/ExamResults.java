/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author rsickinger
 */
public class ExamResults {

    public static final String DELIMITER = ",";
    private List<Submission> results = new ArrayList<>();

    // Fuegt eine neues Klausurergebnis hinzu
    // Hier brauchst du keine Streambs bzw. Lambdas verwenden.
    public void addSubmission(String name, int[] points) {
        results.add(new Submission(name, points));
    }

    // Ermittelt die Namen aller , die bestanden haben
    // D.h. deren Gesamtpunkzahl groesser als ein Schwellwert (threshold) ist
    // Verwende nur fluent Programming Streams und Lambdas!
    public List<String> getPassed(final int threshold) {
        return results.stream().filter(r -> r.getSum() > threshold).map(r -> r.getName()).collect(Collectors.toList());
    }

    // Ermittelt den Mittelwert der Klausurergebnisse
    // Loest eine RuntimeException aus , wenn die List der
    // Klausurergebnisse leer ist
    // Wirf eine Runtime Exception wenn der Mittelwert nicht ermittelt werden kann
    // Verwende nur fluent Programming Streams und Lambdas!
    public double getAverage() {
        if (results.isEmpty()) {
            throw new RuntimeException();
        }

        return results.stream().mapToDouble(r -> r.getSum()).average().getAsDouble();
    }

    // Liefert eine Liste mit den Namen der Klausurteilnehmer ,
    // aufsteigend sortiert nach erreichter Gesamtpunktzahl ,
    // bei Punktegleichstand nach Name
    // Verwende nur fluent Programming Streams und Lambdas;
    public List<String> getSorted() {
        return results.stream().sorted(new Comparator<Submission>() {
            @Override
            public int compare(Submission o1, Submission o2) {
                if (o1.getSum() == o2.getSum()) {
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getSum() - o2.getSum();
            }
        ;
        }).map(s -> s.getName()).collect(Collectors.toList());
    }

    // Iteriere durch die datei mit einem br.lines(). <- hier nächste intermediate operation einsetzen
    // Verwende nur fluent Programming Streams und Lambdas!
    public void readCsv(File file) throws FileNotFoundException {
        try {
            // pro Zeile Name und Punkte einlesen
            this.results = Files.readAllLines(file.toPath())
                    .stream().map(r -> r.split(",")).map(r -> new Submission(r[0], Arrays.stream(r[1].replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("|", "").split("")).mapToInt(Integer::parseInt).toArray())).collect(Collectors.toList());
                                       
        } catch (IOException ex) {
            Logger.getLogger(ExamResults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Suche mit filter und findFirst und verwende ein Optional
    // Verwende nur fluent Programming Streams und Lambdas!
    public int[] getSubmission(String searchName) {
        // Wie gemeint?
        return results.stream().filter(r -> r.getName().equalsIgnoreCase(searchName)).findFirst().map(r -> r.getPoints()).orElse(null);
    }

      
    // Finde Die Top n besten results. Verwende die Methode limit!
    // Verwende nur fluent Programming Streams und Lambdas!
    public List<String> getTopN(final int n) {
        return results.stream().sorted(new Comparator<Submission>() {
            @Override
            public int compare(Submission o1, Submission o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).limit(n).map(r -> r.getName()).collect(Collectors.toList());                
    }

}
