package com.epam.tasks.fourth.view;

import java.io.IOException;

public interface OutputService {

    void printArray(int[] array, boolean append) throws IOException;

    void printLine(String line, boolean append) throws IOException;

}
