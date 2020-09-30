package com.epam.tasks.fourth.data.input;

import java.util.Random;

public class RandomNumberInputService implements NumberInputService {
    private Random random = new Random();

    public int readNumber() {
        return random.nextInt();
    }

    public int[] readNumbers(int amount) {
        int[] array = new int[amount];

        for (int i = 0; i < amount; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }

    @Deprecated
    public void close() { }
}
