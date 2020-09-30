package com.epam.tasks.fourth.view;

import org.junit.Assert;
import org.junit.Test;
import java.io.*;

public class FileOutputServiceTest {
    private File file = new File("src/test/resources/toTestFileOutputService");
    private FileOutputService outputService = new FileOutputService(file);
    private BufferedReader reader = new BufferedReader(new FileReader( file));

    public FileOutputServiceTest() throws IOException {
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

        for (int number : array) {
            stringBuilder.append(number);
            stringBuilder.append(" ");
        }

        //remove last space
        int length = stringBuilder.length();
        stringBuilder.delete(length - 1, length);

        return stringBuilder.toString();
    }
}
