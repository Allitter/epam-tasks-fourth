package com.epam.tasks.fourth.view;

import com.epam.tasks.fourth.domain.ArrayHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {
    private BufferedWriter writer;
    private ArrayHelper arrayHelper;
    private File file;

    public FilePrinter(final ArrayHelper arrayHelper, File file) {
        this.file = file;
        this.arrayHelper = arrayHelper;
    }

    @Override
    public void printArray(int[] array, boolean append) throws IOException {
        if (array == null || array.length < 1) {
            return;
        }

        String arraysString = arrayHelper.arrayToString(array);
        printLine(arraysString, append);
    }

    @Override
    public void printLine(String line, boolean append) throws IOException {
        open(append);
        writer.write(line);
        writer.write("\r\n");
        close();
    }

    protected void close() throws IOException {
        writer.flush();
        writer.close();
    }

    protected void open(boolean append) throws IOException {
        writer = new BufferedWriter(new FileWriter(file, append));
    }
}
