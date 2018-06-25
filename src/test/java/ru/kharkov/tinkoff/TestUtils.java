package ru.kharkov.tinkoff;

import ru.kharkov.tinkoff.entity.Application;
import ru.kharkov.tinkoff.entity.Contract;

import java.time.LocalDateTime;

/**
 * @author m.kharkov
 * @since 25.06.18
 */

public class TestUtils {

    public static Application prepareApplication(){
        Application app = new Application();
        Contract contract = new Contract();
        contract.setId(1L);
        app.setId(1L);
        app.setProductName("Тестовый продукт");
        app.setDtCreated(LocalDateTime.now());
        app.setContract(contract);
        return app;
    }
}
