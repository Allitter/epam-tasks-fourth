package com.epam.tasks.fourth.data.input;

import org.junit.*;
import java.io.InputStream;
import java.util.Scanner;

public class ConsoleNumberAcquirerTest {
    public static final String NUMBER = "10";
    public static final String NUMBERS = "1 2 3 4 5";
    private static final MockInputStream MOCK_INPUT_STREAM = new MockInputStream();
    private final ConsoleNumberAcquirer acquirer = new ConsoleNumberAcquirer();
    private static InputStream inputStream;

    @BeforeClass
    public static void toDoBeforeAllTests() {
        inputStream = System.in;
        System.setIn(MOCK_INPUT_STREAM);
    }

    @AfterClass
    public static void toDoAfterAllTests() {
        System.setIn(inputStream);
    }

    @Test
    public void testReadNumberShouldReadNumber() {
        MOCK_INPUT_STREAM.setInput(NUMBER);
        int expected = Integer.parseInt(NUMBER);

        int actual = acquirer.readNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadNumbersShouldReadNumbers() {
        MOCK_INPUT_STREAM.setInput(NUMBERS);
        int[] expected = stringToIntArray(NUMBERS);
        
        int[] actual = acquirer.readNumbers(5);

        Assert.assertArrayEquals(expected, actual);
    }

    private int[] stringToIntArray(String line) {
        Scanner scanner = new Scanner(line);
        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {
            result[i] = scanner.nextInt();
        }

        return result;
    }
}
