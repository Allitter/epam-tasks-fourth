package com.epam.tasks.fourth.data.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNumberAcquirer extends NumberAcquirer {
    private Scanner scanner;

    public FileNumberAcquirer(File file) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(file);
        scanner = new Scanner(inputStream);
    }

    public int readNumber() {
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}
