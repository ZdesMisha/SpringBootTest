package ru.kharkov.tinkoff.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import ru.kharkov.tinkoff.entity.Application;

public interface ApplicationProjection {

    @Projection(types = Application.class)
    interface MainProjection {

        @Value("#{target.getId()}")
        String getApplication_id();

        @Value("#{target.getProductName()}")
        String getProduct_name();

        @Value("#{target.getDtCreatedPretty()}")
        String getDt_created();

        @Value("#{target.getContract().getId()}")
        String getContract_id();
    }
}
