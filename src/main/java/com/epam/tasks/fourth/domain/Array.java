package com.epam.tasks.fourth.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Array {
    private int[] array;
    private ArrayHelper helper;

    public Array(final ArrayHelper helper, int size) {
        array = new int[size];
        this.helper = helper;
    }

    public Array(final ArrayHelper helper, int...array) {
        this.array = array;
        this.helper = helper;
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

    /*package friendly for test*/
    int[] getArray() {
        return array;
    }

    public void sort() {
        insertionSortAscending(array);
    }

    public int[] getThreeDigitNumsWithNoDuplicates() {
        List<Integer> resultNumbers = new LinkedList<>();
        for (int number : array) {
            if (isThreeDigitNumber(number) && !hasDuplicateDigits(number)) {
                resultNumbers.add(number);
            }
        }

        return helper.convertIntegerListToIntArray(resultNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array1 = (Array) o;
        return Arrays.equals(array, array1.array) &&
                Objects.equals(helper, array1.helper);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(helper);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return helper.arrayToString(array);
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
}
