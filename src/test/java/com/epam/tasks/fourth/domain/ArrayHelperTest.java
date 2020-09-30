package com.epam.tasks.fourth.domain;

import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

public class ArrayHelperTest {
    private final ArrayHelper converter = new ArrayHelper();

    @Test
    public void testConvertIntegerListToIntArrayShouldReturnIntArray() {
        int[] expected = {1, 2, 3, 4, 5};
        List<Integer> list = arrayToList(expected);

        int[] actual = converter.convertIntegerListToIntArray(list);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testArrayToString() {
        int[] input = {1, 2, 3, 4, 5};
        String expected = "[1, 2, 3, 4, 5]";
        String actual = converter.arrayToString(input);

        Assert.assertEquals(expected, actual);
    }

    private List<Integer> arrayToList(int[] array) {
        List<Integer> result = new LinkedList<>();

        for (int number : array) {
            result.add(number);
        }

        return result;
    }

}
