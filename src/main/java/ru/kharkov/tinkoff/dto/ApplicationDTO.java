package ru.kharkov.tinkoff.dto;

import lombok.Getter;
import lombok.Setter;
import ru.kharkov.tinkoff.entity.Application;

/**
 * @author m.kharkov
 * @since 26.06.18
 */
@Getter
@Setter
public class ApplicationDTO {

    private Long application_id;
    private String product_name;
    private String dt_created;
    private Long contract_id;


    public ApplicationDTO(Application app) {
        this.application_id = app.getId();
        this.product_name = app.getProductName();
        this.dt_created = app.getDtCreatedPretty();
        this.contract_id = app.getContract() == null ? null : app.getContract().getId();
    }
}
