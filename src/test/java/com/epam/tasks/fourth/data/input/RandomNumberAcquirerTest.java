package com.epam.tasks.fourth.data.input;

import org.junit.Assert;
import org.junit.Test;

public class RandomNumberAcquirerTest {
    private RandomNumberAcquirer acquirer = new RandomNumberAcquirer();

    @Test
    public void testReadNumbersShouldReadNumbers() {
        int expectedLength = 5;

        int[] actual = acquirer.readNumbers(5);
        int actualLength = actual.length;

        Assert.assertEquals(expectedLength, actualLength);
    }
}