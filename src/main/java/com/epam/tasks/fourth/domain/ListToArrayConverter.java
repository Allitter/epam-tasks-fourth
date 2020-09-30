package com.epam.tasks.fourth.domain;

import java.util.List;

public class ListToArrayConverter {

    public int[] convertIntegerListToIntArray(List<Integer> list) {
        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
