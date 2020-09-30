package com.epam.tasks.fourth.domain;

import java.util.LinkedList;
import java.util.List;

public class Array {
    private int[] array;

    public Array(int size) {
        array = new int[size];
    }

    public Array(int...array) {
        this.array = array;
    }

    public int getElement(int index) {
        return array[index];
    }

    public void setElement(int index, int element) {
        array[index] = element;
    }

    public int getLength() {
        return array != null ? array.length : 0;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    /*package friendly for test*/ int[] getArray() {
        return array;
    }

    public void sort(boolean ascending) {
        if (ascending) {
            insertionSortAscending(array);
        } else {
            insertionSortDescending(array);
        }
    }

    public int[] getThreeDigitNumsWithNoDuplicates() {
        List<Integer> resultNumbers = new LinkedList<>();
        ListToArrayConverter converter = new ListToArrayConverter();

        for (int number : array) {
            if (isThreeDigitNumber(number) && !hasDuplicateDigits(number)) {
                resultNumbers.add(number);
            }
        }

        return converter.convertIntegerListToIntArray(resultNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Array array1 = (Array)o;
        if (array.length != array1.array.length) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != array1.array[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        if (array == null) {
            return 0;
        }

        int result = 1;
        for (int element : array) {
            result = 31 * result + element;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append('[');
        for (int element : array) {
            stringBuilder.append(String.format("%d, ", element));
        }

        //remove ", " from the end
        int length = stringBuilder.length();
        stringBuilder.delete(length - 2, length);

        stringBuilder.append(']');

        return stringBuilder.toString();
    }

    private boolean hasDuplicateDigits(int number) {
        boolean[] used = new boolean[10];
        int digit;

        while (number > 0) {
            digit = number % 10;
            number /= 10;

            if (!used[digit]) {
                used[digit] = true;
            } else {
                return true;
            }
        }

        return false;
    }

    private boolean isThreeDigitNumber(int number) {
        return number < 1000 && number > 99;
    }

    private void insertionSortAscending(int[] array) {
        int buff;
        int j;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                buff = array[i];
                j = i;

                while (j > 0 && array[j - 1] > buff) {
                    array[j] = array[j - 1];
                    j--;
                }

                array[j] = buff;
            }
        }
    }

    private void insertionSortDescending(int[] array) {
        int buff;
        int j;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                buff = array[i];
                j = i;

                while (j > 0 && array[j - 1] < buff) {
                    array[j] = array[j - 1];
                    j--;
                }

                array[j] = buff;
            }
        }
    }
}
