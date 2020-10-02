package com.epam.tasks.fourth.domain;

import java.util.Arrays;
import java.util.List;

public class ArrayHelperStub extends ArrayHelper {
    @Override
    public int[] convertIntegerListToIntArray(List<Integer> list) {
        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    @Override
    public String arrayToString(int[] array) {
        return Arrays.toString(array);
    }
}
