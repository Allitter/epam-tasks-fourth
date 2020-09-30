package com.epam.tasks.fourth.domain;

import org.junit.Assert;
import org.junit.Test;

public class ArrayTest {
    private Array array = new Array(201, 102, 305, 505, 408);

    @Test
    public void testSortShouldSortAscending() {
        int[] expected = {102, 201, 305, 408, 505};

        array.sort(true);
        int[] actual = array.getArray();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortShouldSortDescending() {
        int[] expected = {505, 408, 305, 201, 102};

        array.sort(false);
        int[] actual = array.getArray();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetThreeDigitNumsWithNoDuplicatesShouldReturnThreeDigitNumbersWithNoDuplicates() {
        int[] expected = {201, 102, 305, 408};

        int[] actual = array.getThreeDigitNumsWithNoDuplicates();

        Assert.assertArrayEquals(expected, actual);
    }

}
