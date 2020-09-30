package com.epam.tasks.fourth.data;

import com.epam.tasks.fourth.data.input.RandomNumberAcquirer;
import com.epam.tasks.fourth.data.exceptions.FactoryNotExistsException;
import com.epam.tasks.fourth.data.input.ConsoleNumberAcquirer;
import com.epam.tasks.fourth.data.input.FileNumberAcquirer;
import com.epam.tasks.fourth.data.input.NumberAcquirer;
import java.io.FileNotFoundException;
import java.io.File;

public class NumberAcquirerFactory {

    public NumberAcquirer createAcquirer(String name, String path)
            throws FileNotFoundException, FactoryNotExistsException {

        switch (name.toLowerCase()) {
            case "console" :
                return new ConsoleNumberAcquirer();
            case "file" :
                return new FileNumberAcquirer(new File(path));
            case "random" :
                return new RandomNumberAcquirer();
            default:
                throw new FactoryNotExistsException(
                        String.format("%s factory not exists", name));
        }
    }

}
