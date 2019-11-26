/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rsickinger
 */
public class ExamResultsTest {
    @Test
    public void testReadCSV() throws FileNotFoundException {
        String testFileContent = "Hubert,{|3|2|4|5|2|}\n" +
                "Franz,{|1|2|4|}\n";


        try (PrintStream out = new PrintStream(new FileOutputStream("test.csv"))) {
            out.print(testFileContent);
        }


        File testFile = new File("test.csv");

        ExamResults er = new ExamResults();
        er.readCsv(testFile);

        int[] points1 = er.getSubmission("Hubert");
        assertNotNull(points1);
        assertTrue(arraysSame(points1, new int[]{3, 2, 4, 5, 2}));

        int[] points2 = er.getSubmission("Franz");
        assertNotNull(points2);
        assertTrue(arraysSame(points2, new int[]{1, 2, 4}));


        testFile.delete();
    }

    private boolean arraysSame(int[] array1, int[] array2) {
        boolean b = true;
        if (array1 != null && array2 != null) {
            if (array1.length != array2.length)
                b = false;
            else
                for (int i = 0; i < array2.length; i++) {
                    if (array2[i] != array1[i]) {
                        b = false;
                    }
                }
        } else {
            b = false;
        }

        return b;
    }

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = new int[0];
        examResults0.addSubmission("z<^#", intArray0);
        int[] intArray1 = examResults0.getSubmission("z<^#");
        assertSame(intArray1, intArray0);
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = new int[0];
        examResults0.addSubmission("z<^#", intArray0);
        List<String> list0 = examResults0.getSorted();
        assertTrue(list0.contains("z<^#"));
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = new int[0];
        examResults0.addSubmission("z<^#", intArray0);
        List<String> list0 = examResults0.getPassed((-1));
        assertTrue(list0.contains("z<^#"));
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = new int[4];
        examResults0.addSubmission("oracle.jrockit.jfr.settings.PresetFile$PresetFileFilter", intArray0);
        double double0 = examResults0.getAverage();
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = new int[2];
        intArray0[0] = 995;
        examResults0.addSubmission("", intArray0);
        double double0 = examResults0.getAverage();
        assertEquals(995.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = new int[5];
        intArray0[0] = (-1);
        examResults0.addSubmission((String) null, intArray0);
        double double0 = examResults0.getAverage();
        assertEquals((-1.0), double0, 0.01);
    }

    @Test(expected = NullPointerException.class)
    public void test11() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = new int[3];
        examResults0.addSubmission((String) null, intArray0);
        examResults0.addSubmission((String) null, intArray0);
        // Undeclared exception!

        examResults0.getSorted();

    }

    @Test(expected = NullPointerException.class)
    public void test12() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        // Undeclared exception!

        examResults0.addSubmission(";", (int[]) null);

    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = new int[4];
        examResults0.addSubmission(",", intArray0);
        int[] intArray1 = examResults0.getSubmission(",");
        assertSame(intArray1, intArray0);
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = examResults0.getSubmission(",");
        assertNull(intArray0);
    }

    @Test(expected = NullPointerException.class)
    public void test15() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        int[] intArray0 = new int[0];
        examResults0.addSubmission((String) null, intArray0);
        // Undeclared exception!

        examResults0.getSubmission((String) null);

    }

    @Test(expected = RuntimeException.class)
    public void test17() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        // Undeclared exception!

        examResults0.getAverage();

    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        List<String> list0 = examResults0.getSorted();
        assertTrue(list0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        ExamResults examResults0 = new ExamResults();
        List<String> list0 = examResults0.getPassed(0);
        assertTrue(list0.isEmpty());
    }
    
}
