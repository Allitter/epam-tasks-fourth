package com.epam.tasks.fourth.view;

import com.epam.tasks.fourth.domain.ArrayHelper;
import org.junit.Assert;
import org.junit.Test;
import java.io.*;

public class FilePrinterTest {
    private File file = new File("src/test/resources/toTestFileOutputService");
    private FilePrinter outputService = new FilePrinter(new ArrayHelper(), file);
    private BufferedReader reader = new BufferedReader(new FileReader( file));

    public FilePrinterTest() throws IOException {
    }

    @Test
    public void testPrintArrayShouldPrintArray() throws IOException {
        int[] array  = {1, 2, 3, 4, 5};
        String expected = arrayToString(array);

        outputService.printArray(array, false);
        String actual = reader.readLine();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintLineShouldPrintLine() throws IOException {
        String expected = "line";

        outputService.printLine(expected, false);
        String actual = reader.readLine();

        Assert.assertEquals(expected, actual);
    }


    private String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append('[');
        for (int number : array) {
            stringBuilder.append(number);
            stringBuilder.append(", ");
        }

        //remove ", " from the end
        int length = stringBuilder.length();
        stringBuilder.delete(length - 2, length);

        stringBuilder.append(']');

        return stringBuilder.toString();
    }
}
