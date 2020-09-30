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
    private NumberAcquirerFactory factory = new NumberAcquirerFactory();

    @Test
    public void testCreateNumberInputServiceShouldReturnConsoleNumberInputService()
            throws FileNotFoundException, FactoryNotExistsException {

        Class expected = ConsoleNumberAcquirer.class;

        NumberAcquirer inputService =
                factory.createService(CONSOLE_FACTORY_NAME, "");
        Class actual = inputService.getClass();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateNumberInputServiceShouldReturnFileNumberInputService()
            throws FileNotFoundException, FactoryNotExistsException {

        Class expected = FileNumberAcquirer.class;

        NumberAcquirer inputService =
                factory.createService(FILE_FACTORY_NAME, PATH_TO_EMPTY_FILE);
        Class actual = inputService.getClass();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateNumberInputServiceShouldReturnRandomNumberInputService()
            throws FileNotFoundException, FactoryNotExistsException {

        Class expected = RandomNumberAcquirer.class;

        NumberAcquirer inputService =
                factory.createService(RANDOM_FACTORY_NAME, "");
        Class actual = inputService.getClass();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FactoryNotExistsException.class)
    public void testCreateNumberInputServiceWithIncorrectFactory()
            throws FileNotFoundException, FactoryNotExistsException {

        Class expected = RandomNumberAcquirer.class;

        NumberAcquirer inputService =
                factory.createService(NOT_EXISTING_FACTORY_NAME, "");
        Class actual = inputService.getClass();

        Assert.assertEquals(expected, actual);
    }
}
