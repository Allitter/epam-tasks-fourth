package com.epam.tasks.fourth.view;

import com.epam.tasks.fourth.view.exceptions.UnableToCreateFileException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// TODO Realise class

public class FileOutputService implements OutputService {
    private BufferedWriter writer;
    private File file;

    public FileOutputService(File file) throws IOException {
        this.file = file;

        if (!file.exists()) {
            tryCreateNewFile();
        }
    }

    @Override
    public void printArray(int[] array, boolean append) throws IOException {
        if (array == null || array.length < 1) {
            return;
        }

        open(append);
        int lastElementIndex = array.length - 1;

        writer.write('[');
        for (int i = 0; i < lastElementIndex; i++) {
            writer.write(String.format("%d ", array[i]));
        }
        writer.write(String.valueOf(array[lastElementIndex]));
        writer.write(']');
        writer.write("\r\n");

        close();
    }

    @Override
    public void printLine(String line, boolean append) throws IOException {
        open(append);
        writer.write(line);
        writer.write("\r\n");
        close();
    }

    private void tryCreateNewFile() throws IOException {
        boolean isCreated = file.createNewFile();

        if (!isCreated) {
            throw new UnableToCreateFileException();
        }
    }

    protected void close() throws IOException {
        writer.flush();
        writer.close();
    }

    protected void open(boolean append) throws IOException {
        writer = new BufferedWriter(new FileWriter(file, append));
    }
}
