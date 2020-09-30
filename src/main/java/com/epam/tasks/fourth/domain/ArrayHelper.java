package com.epam.tasks.fourth.domain;

import java.util.List;

public class ArrayHelper {

    public int[] convertIntegerListToIntArray(List<Integer> list) {
        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        int lastElementIndex = array.length - 1;

        stringBuilder.append('[');
        for (int i = 0; i < lastElementIndex; i++) {
            stringBuilder.append(String.format("%d, ", array[i]));
        }
        stringBuilder.append(array[lastElementIndex]);
        stringBuilder.append(']');

        return stringBuilder.toString();
    }

}
