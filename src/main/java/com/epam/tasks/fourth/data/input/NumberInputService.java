package com.epam.tasks.fourth.data.input;

import java.io.Closeable;

public interface NumberInputService extends Closeable {

    int readNumber();

    int[] readNumbers(int amount);

}
