package com.epam.tasks.fourth.data;

import com.epam.tasks.fourth.data.input.RandomNumberInputService;
import com.epam.tasks.fourth.data.exceptions.FactoryNotExistsException;
import com.epam.tasks.fourth.data.input.ConsoleNumberInputService;
import com.epam.tasks.fourth.data.input.FileNumberInputService;
import com.epam.tasks.fourth.data.input.NumberInputService;
import java.io.File;
import java.io.FileNotFoundException;

public class NumberInputServiceFactory {

    public NumberInputService createService(String name, String path)
            throws FileNotFoundException, FactoryNotExistsException {

        switch (name.toLowerCase()) {
            case "console" :
                return new ConsoleNumberInputService();
            case "file" :
                return new FileNumberInputService(new File(path));
            case "random" :
                return new RandomNumberInputService();
            default:
                throw new FactoryNotExistsException(
                        String.format("%s factory not exists", name));
        }
    }

}
