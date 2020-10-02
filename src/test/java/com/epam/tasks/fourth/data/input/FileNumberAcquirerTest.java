package com.epam.tasks.fourth.data.input;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;

public class FileNumberAcquirerTest {
    private final File file = new File("src/test/resources/toTestFileNumberAcquirer");
    private final FileNumberAcquirer acquirer = new FileNumberAcquirer(file);

    public FileNumberAcquirerTest() throws FileNotFoundException {
    }

    @Test
    public void testReadNumberShouldReadNumber() {
        int expected = 1;
        int actual = acquirer.readNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadNumbersShouldReadNumbers() {
        int[] expected = {1, 2, 3, 4, 5};

        int[] actual = acquirer.readNumbers(5);

        Assert.assertArrayEquals(expected, actual);
    }

}
