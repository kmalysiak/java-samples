package pl.coderstrust.pascal_triangle;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PascalTriangleTest {
    private final ByteArrayOutputStream stdOutputContent = new ByteArrayOutputStream();
    PascalTriangle triangle = new PascalTriangle();
    private String newLine = System.getProperty("line.separator");

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(stdOutputContent));
    }

    @Test
    public void shouldReturnTriangleWithCorrectRowSum() {
        triangle.printPascalTriangle(50);
        String output[] = stdOutputContent.toString().split(newLine);
        long outputRowSum[] = new long[output.length];
        long shouldRowSum[] = new long[output.length];
        for (int i = 0; i < output.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(output[i], " ");
            outputRowSum[i] = 0l;
            while (tokenizer.hasMoreTokens()) {
                outputRowSum[i] += Long.parseLong(tokenizer.nextToken());
            }
            shouldRowSum[i] = (long) Math.pow(2, i);
        }
        assertArrayEquals(shouldRowSum, outputRowSum);
    }

    @Test
    public void shouldReturn1ForSize0() {
        triangle.printPascalTriangle(0);
        StringTokenizer tokenizer = new StringTokenizer(stdOutputContent.toString(), " ");
        String output = tokenizer.nextToken().toString();
        output = output.replace(newLine, "");
        assertEquals(1, Integer.parseInt(output));
    }

    @Test
    public void shouldNotReturnExceptionForAnyTriangleSize() {
        int i = 0;
        try {
            for (i = -100; i < 1000; i++) {
                triangle.printPascalTriangle(i);
            }
        } catch (Exception e) {
            Assert.fail("Exception thrown by triangle.printPascalTriangle(i) at i:" + i);
            e.printStackTrace();
        }
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }
}