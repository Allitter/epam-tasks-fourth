package com.epam.tasks.fourth.data.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileNumberInputService implements NumberInputService {
    private Scanner scanner;

    public FileNumberInputService(File file) throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream(file));
    }

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
