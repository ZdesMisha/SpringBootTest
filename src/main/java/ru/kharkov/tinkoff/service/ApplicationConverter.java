package ru.kharkov.tinkoff.service;

import org.springframework.stereotype.Component;
import ru.kharkov.tinkoff.entity.Application;
import ru.kharkov.tinkoff.schema.ApplicationXml;

/**
 * @author m.kharkov
 * @since 22.06.18
 */

@Component
public class ApplicationConverter implements Converter<ApplicationXml, Application> {
    @Override
    public ApplicationXml convert(Application convertFrom) {
        ApplicationXml applicationXml = new ApplicationXml();
        applicationXml.setApplicationId(convertFrom.getApplication_id().toString());
        applicationXml.setDsCreated(convertFrom.getApplication_id().toString());
        applicationXml.setProductName(convertFrom.getApplication_id().toString());
        applicationXml.setContractId(convertFrom.getApplication_id().toString());
        return applicationXml;
    }
}
