package com.epam.tasks.fourth;

// TODO Создание типа Array, который является классом оболочкой над массивом
//  целого типа. В данном типе должны быть реализованы конструкторы (позволяющие
//  несколькими способами создавать объекты типа), get-ы, set-ы и
//  переопределенные методы класса Object (toString(), equals(), hasCode()).
//  Программа должна иметь следующие возможности:
//  1. Сортировать массив. (вставки)
//  2. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
//  3. Заполнения элементов массива и с консоли, и с файла и с помощью генерации
//  случайных чисел.

import com.epam.tasks.fourth.data.exceptions.FactoryNotExistsException;
import com.epam.tasks.fourth.data.input.NumberInputService;
import com.epam.tasks.fourth.data.NumberInputServiceFactory;
import com.epam.tasks.fourth.domain.Array;
import com.epam.tasks.fourth.exceptions.IncorrectArgumentException;
import com.epam.tasks.fourth.exceptions.IncorrectCommandLineKeyArgumentsException;
import com.epam.tasks.fourth.exceptions.IncorrectCommandLineKeyException;
import com.epam.tasks.fourth.exceptions.IncorrectCommandLineKeyOrderException;
import com.epam.tasks.fourth.view.FileOutputService;
import com.epam.tasks.fourth.view.OutputService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final String INPUT_KEY = "-i";
    private static final String OUTPUT_KEY = "-o";
    private static final String SORT_KEY = "-s";
    private static final String NO_DUPLICATES_KEY = "-n";
    private static final String KEY_REGEX = "-[A-Za-z]";
    private Array array;
    private OutputService outputService;


    public static void main(String[] args) throws IOException, IncorrectArgumentException {
        Main main = new Main();
        main.run(args);
    }

    public void run(String[] args)
            throws IOException, IncorrectArgumentException {

        String key;
        for (int i = 0; i < args.length; i++) {
            if (args[i].matches(KEY_REGEX)) {
                key = args[i];
                List<String> keyArgs = arrangeKeyArgs(args, i);

                handleCommandKey(key, keyArgs);
            }
        }
    }

    //puts all key arguments into list after key on keyIndex
    private List<String> arrangeKeyArgs(String[] args, int keyIndex) {
        List<String> keyArgs = new LinkedList<>();
        int i = keyIndex + 1;

        while (i < args.length && !args[i].matches(KEY_REGEX)) {
            keyArgs.add(args[i]);
            i++;
        }

        return keyArgs;
    }

    private void handleCommandKey(String key, List<String> args)
            throws IOException, IncorrectArgumentException {

        try {
            switch (key) {
                case INPUT_KEY :
                    inputHandler(args);
                    break;
                case OUTPUT_KEY :
                    outputCreationHandler(args);
                    break;
                case SORT_KEY :
                    sortHandler(args);
                    break;
                case NO_DUPLICATES_KEY :
                    noDuplicatesHandler(args);
                    break;
                default:
                    throw new IncorrectCommandLineKeyException(key);
            }
        } catch (NullPointerException ne) {
            throw new IncorrectCommandLineKeyOrderException();
        } catch (Exception e) {
            throw new IncorrectCommandLineKeyArgumentsException(key + " " + args.toString());
        }
    }

    private void inputHandler(List<String> args) throws IOException, FactoryNotExistsException {
        String inputType = args.get(0);
        String inputSource = inputType.equals("file") ? args.get(1) : "";
        int lastArgIndex = args.size() - 1;
        int amountToRead = Integer.parseInt(args.get(lastArgIndex));

        NumberInputServiceFactory factory = new NumberInputServiceFactory();
        NumberInputService inputService =
                factory.createService(inputType, inputSource);

        array = new Array(inputService.readNumbers(amountToRead));
        inputService.close();

        printResult("Input: ", array.toString(), true);
    }

    private void outputCreationHandler(List<String> args) throws IOException {
        File file = new File(args.get(0));
        outputService = new FileOutputService(file);
    }

    private void sortHandler(List<String> args) throws IOException {
        boolean ascending = args.get(0).startsWith("a");
        array.sort(ascending);

        printResult("Sorted: ", array.toString(), true);
    }

    private void noDuplicatesHandler(List<String> args) throws IOException {
        int[] noDuplicates = array.getThreeDigitNumsWithNoDuplicates();

        printResult("No duplicates three-digit numbers: ", noDuplicates, true);
    }

    private void printResult(String message, String result, boolean append) throws IOException {
        outputService.printLine(message, append);
        outputService.printLine(result, append);
    }

    private void printResult(String message, int[] result, boolean append) throws IOException {
        outputService.printLine(message, append);
        outputService.printArray(result, append);
    }
}
