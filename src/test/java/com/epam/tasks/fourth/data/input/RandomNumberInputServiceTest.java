package com.epam.tasks.fourth.data.input;

import org.junit.Assert;
import org.junit.Test;

public class RandomNumberInputServiceTest {
    private RandomNumberInputService inputService = new RandomNumberInputService();

    @Test
    public void testReadNumbersShouldReadNumbers() {
        int expectedLength = 5;

        int[] actual = inputService.readNumbers(5);
        int actualLength = actual.length;

        Assert.assertEquals(expectedLength, actualLength);
    }
}