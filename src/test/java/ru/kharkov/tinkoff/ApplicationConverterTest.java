package ru.kharkov.tinkoff;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import ru.kharkov.tinkoff.entity.Application;
import ru.kharkov.tinkoff.entity.Contract;
import ru.kharkov.tinkoff.exception.ConversionException;
import ru.kharkov.tinkoff.schema.ApplicationXml;
import ru.kharkov.tinkoff.service.ApplicationConverter;
import ru.kharkov.tinkoff.service.Converter;

import java.time.LocalDateTime;


/**
 * @author m.kharkov
 * @since 22.06.18
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class ApplicationConverterTest{

    private Converter<ApplicationXml,Application> converter;

    @Before
    public void init(){
        converter = new ApplicationConverter();
    }

    @Test
    public void convertTest() throws ConversionException{
        Application app = prepareApplication();
        ApplicationXml appXlm = converter.convert(app);
        Assert.assertEquals(app.getId().toString(), appXlm.getApplicationId());
    }

    @Test(expected = ConversionException.class)
    public void convertNullTest() throws ConversionException{
        converter.convert(null);
    }

    private Application prepareApplication(){
        Application app = new Application();
        Contract contract = new Contract();
        contract.setId(1L);
        app.setId(1L);
        app.setProductName("Продукт");
        app.setDtCreated(LocalDateTime.now());
        app.setContract(contract);
        return app;
    }
}
