package com.epam.tasks.fourth.data.input;

import org.junit.*;
import java.io.InputStream;
import java.util.Scanner;

public class ConsoleNumberInputServiceTest {
    public static final String NUMBER = "10";
    public static final String NUMBERS = "1 2 3 4 5";
    private ConsoleNumberInputService inputService = new ConsoleNumberInputService();
    private static InputStream inputStream;
    private static MockInputStream mockInputStream = new MockInputStream();

    @BeforeClass
    public static void toDoBeforeAllTests() {
        inputStream = System.in;
        System.setIn(mockInputStream);
    }

    @AfterClass
    public static void toDoAfterAllTests() {
        System.setIn(inputStream);
    }

    @Test
    public void testReadNumberShouldReadNumber() {
        mockInputStream.setInput(NUMBER);
        int expected = Integer.parseInt(NUMBER);

        int actual = inputService.readNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadNumbersShouldReadNumbers() {
        mockInputStream.setInput(NUMBERS);
        int[] expected = stringToIntArray(NUMBERS);
        
        int[] actual = inputService.readNumbers(5);

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
