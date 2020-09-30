package com.epam.tasks.fourth.data.input;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNumberAcquirerTest {
    private File file = new File("src/test/resources/toTestFileNumberInputService");
    private FileNumberAcquirer inputService = new FileNumberAcquirer(file);

    public FileNumberAcquirerTest() throws FileNotFoundException {
    }

    @Test
    public void testReadNumberShouldReadNumber() {
        int expected = 1;
        int actual = inputService.readNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadNumbersShouldReadNumbers() {
        int[] expected = {1, 2, 3, 4, 5};

        int[] actual = inputService.readNumbers(5);

        Assert.assertArrayEquals(expected, actual);
    }

    private int[] stringToIntArray(String line) {
        Scanner scanner = new Scanner(line);
        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {
            result[i] = scanner.nextInt();
        }

        return result;
    }

}
