package com.epam.tasks.fourth.data.input;

import java.util.Random;

public class RandomNumberAcquirer extends NumberAcquirer {
    private Random random = new Random();

    public int readNumber() {
        return random.nextInt();
    }

    @Deprecated
    public void close() {
    }
}
