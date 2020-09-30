package com.epam.tasks.fourth.data.input;

import com.epam.tasks.fourth.data.filters.FilterNotToCloseSystemIn;
import java.util.Scanner;

public class ConsoleNumberAcquirer extends NumberAcquirer {
    private Scanner scanner = new Scanner(new FilterNotToCloseSystemIn(System.in));

    public int readNumber() {
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}
