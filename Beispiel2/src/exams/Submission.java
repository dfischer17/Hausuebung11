/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exams;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author rsickinger
 */
public class Submission {

    private int sum;
    private String name;
    private int[] points;

    // berechne die summe mithilfe einer stream methode! (Sum)
    public Submission(String name, int[] points) {
        this.name = name;
        this.points = points;
        this.sum = Arrays.stream(points).sum();//hier dein code!
    }

    // parse den String points mit einem Stream und Lambdas in einen intArray!
    // Tipp: mapToInt und Integer::parseInt
    public Submission(String name, String points) {
        this.name = name;
        this.points = Arrays.stream(points.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getPoints() {
        return points;
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
