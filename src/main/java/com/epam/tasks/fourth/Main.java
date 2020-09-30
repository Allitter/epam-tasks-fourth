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

// TODO заменить пути на относительные

import com.epam.tasks.fourth.data.exceptions.FactoryNotExistsException;
import com.epam.tasks.fourth.data.NumberAcquirerFactory;
import com.epam.tasks.fourth.data.input.NumberAcquirer;
import com.epam.tasks.fourth.view.FilePrinter;
import com.epam.tasks.fourth.domain.ArrayHelper;
import com.epam.tasks.fourth.view.Printer;
import com.epam.tasks.fourth.domain.Array;
import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException, FactoryNotExistsException {
        NumberAcquirerFactory factory = new NumberAcquirerFactory();
        NumberAcquirer acquirer = factory.createAcquirer("console", "");
        int[] input = acquirer.readNumbers(5);
        ArrayHelper helper = new ArrayHelper();
        Array array = new Array(helper, input);
        acquirer.close();

        array.sort();
        int[] noDuplicates = array.getThreeDigitNumsWithNoDuplicates();

        File outputFile = new File("resultfile.txt");
        Printer printer = new FilePrinter(helper, outputFile);
        printer.printLine(array.toString(), true);
        printer.printArray(noDuplicates, true);
    }
}
