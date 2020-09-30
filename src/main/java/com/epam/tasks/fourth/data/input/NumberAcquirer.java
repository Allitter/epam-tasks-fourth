package com.epam.tasks.fourth.data.input;

import java.io.Closeable;

public abstract class NumberAcquirer implements Closeable {

    public abstract int readNumber();

    public int[] readNumbers(int amount) {
        int[] array = new int[amount];

        for (int i = 0; i < amount; i++) {
            array[i] = readNumber();
        }

        return array;
    }

}
