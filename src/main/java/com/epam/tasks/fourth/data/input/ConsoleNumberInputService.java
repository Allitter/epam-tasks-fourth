package com.epam.tasks.fourth.data.input;

import com.epam.tasks.fourth.data.filters.FilterNotToCloseSystemIn;
import java.util.Scanner;

public class ConsoleNumberInputService implements NumberInputService {
    private Scanner scanner = new Scanner(new FilterNotToCloseSystemIn(System.in));

    public int readNumber() {
        return scanner.nextInt();
    }

    public int[] readNumbers(int amount) {
        int[] array = new int[amount];

        for (int i = 0; i < amount; i++) {
            array[i] = readNumber();
        }

        return array;
    }

    public void close() {
        scanner.close();
    }
}
