package ru.kharkov.tinkoff.service;

import org.springframework.stereotype.Component;
import ru.kharkov.tinkoff.entity.Application;
import ru.kharkov.tinkoff.exception.ConversionException;
import ru.kharkov.tinkoff.schema.ApplicationXml;

/**
 * @author m.kharkov
 * @since 22.06.18
 */

@Component
public class ApplicationConverter implements Converter<ApplicationXml, Application> {

    @Override
    public ApplicationXml convert(Application from) throws ConversionException{
        if(from == null){
            throw new ConversionException("Ошибка конвертации данных в XML. Не указана заявка");
        }
        ApplicationXml applicationXml = new ApplicationXml();
        applicationXml.setApplicationId(from.getId().toString());
        applicationXml.setDsCreated(from.getDtCreatedPretty());
        applicationXml.setProductName(from.getProductName());
        applicationXml.setContractId(from.getId().toString());
        return applicationXml;
    }
}
