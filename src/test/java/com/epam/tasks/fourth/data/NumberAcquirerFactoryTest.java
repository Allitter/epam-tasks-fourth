package com.epam.tasks.fourth.data;

import com.epam.tasks.fourth.data.exceptions.FactoryNotExistsException;
import com.epam.tasks.fourth.data.input.ConsoleNumberAcquirer;
import com.epam.tasks.fourth.data.input.FileNumberAcquirer;
import com.epam.tasks.fourth.data.input.NumberAcquirer;
import com.epam.tasks.fourth.data.input.RandomNumberAcquirer;
import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class NumberAcquirerFactoryTest {
    private static final String NOT_EXISTING_FACTORY_NAME = "not existing factory";
    private static final String FILE_FACTORY_NAME = "file";
    private static final String PATH_TO_EMPTY_FILE = "src/test/resources/emptyFile";
    private static final String CONSOLE_FACTORY_NAME = "console";
    private static final String RANDOM_FACTORY_NAME = "random";
    private final NumberAcquirerFactory factory = new NumberAcquirerFactory();

    @Test
    public void testCreateNumberAcquirerShouldReturnConsoleNumberAcquirer()
            throws FileNotFoundException, FactoryNotExistsException {

        NumberAcquirer acquirer =
                factory.createAcquirer(CONSOLE_FACTORY_NAME, "");

        Assert.assertTrue(acquirer instanceof ConsoleNumberAcquirer);
    }

    @Test
    public void testCreateNumberAcquirerShouldReturnFileNumberAcquirer()
            throws FileNotFoundException, FactoryNotExistsException {

        NumberAcquirer acquirer =
                factory.createAcquirer(FILE_FACTORY_NAME, PATH_TO_EMPTY_FILE);

        Assert.assertTrue(acquirer instanceof FileNumberAcquirer);
    }

    @Test
    public void testCreateNumberAcquirerShouldReturnRandomNumberAcquirer()
            throws FileNotFoundException, FactoryNotExistsException {

        NumberAcquirer acquirer =
                factory.createAcquirer(RANDOM_FACTORY_NAME, "");

        Assert.assertTrue(acquirer instanceof RandomNumberAcquirer);
    }

    @Test(expected = FactoryNotExistsException.class)
    public void testCreateNumberAcquirerWithIncorrectFactory()
            throws FileNotFoundException, FactoryNotExistsException {

        factory.createAcquirer(NOT_EXISTING_FACTORY_NAME, "");
    }
}
