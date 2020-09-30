package com.epam.tasks.fourth.data;

import com.epam.tasks.fourth.data.exceptions.FactoryNotExistsException;
import com.epam.tasks.fourth.data.input.ConsoleNumberInputService;
import com.epam.tasks.fourth.data.input.FileNumberInputService;
import com.epam.tasks.fourth.data.input.NumberInputService;
import com.epam.tasks.fourth.data.input.RandomNumberInputService;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class NumberInputServiceFactoryTest {
    private static final String NOT_EXISTING_FACTORY_NAME = "not existing factory";
    private static final String FILE_FACTORY_NAME = "file";
    private static final String PATH_TO_EMPTY_FILE = "src/test/resources/emptyFile";
    private static final String CONSOLE_FACTORY_NAME = "console";
    private static final String RANDOM_FACTORY_NAME = "random";
    private NumberInputServiceFactory factory = new NumberInputServiceFactory();

    @Test
    public void testCreateNumberInputServiceShouldReturnConsoleNumberInputService()
            throws FileNotFoundException, FactoryNotExistsException {

        Class expected = ConsoleNumberInputService.class;

        NumberInputService inputService =
                factory.createService(CONSOLE_FACTORY_NAME, "");
        Class actual = inputService.getClass();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateNumberInputServiceShouldReturnFileNumberInputService()
            throws FileNotFoundException, FactoryNotExistsException {

        Class expected = FileNumberInputService.class;

        NumberInputService inputService =
                factory.createService(FILE_FACTORY_NAME, PATH_TO_EMPTY_FILE);
        Class actual = inputService.getClass();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateNumberInputServiceShouldReturnRandomNumberInputService()
            throws FileNotFoundException, FactoryNotExistsException {

        Class expected = RandomNumberInputService.class;

        NumberInputService inputService =
                factory.createService(RANDOM_FACTORY_NAME, "");
        Class actual = inputService.getClass();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FactoryNotExistsException.class)
    public void testCreateNumberInputServiceWithIncorrectFactory()
            throws FileNotFoundException, FactoryNotExistsException {

        Class expected = RandomNumberInputService.class;

        NumberInputService inputService =
                factory.createService(NOT_EXISTING_FACTORY_NAME, "");
        Class actual = inputService.getClass();

        Assert.assertEquals(expected, actual);
    }
}
