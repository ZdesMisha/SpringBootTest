package ru.kharkov.tinkoff.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kharkov.tinkoff.entity.Application;
import ru.kharkov.tinkoff.entity.Contract;
import ru.kharkov.tinkoff.repository.ApplicationRepository;
import ru.kharkov.tinkoff.repository.ContractRepository;
import ru.kharkov.tinkoff.schema.ApplicationXml;
import ru.kharkov.tinkoff.service.Converter;

import java.util.Optional;

/**
 * @author m.kharkov
 * @since 22.06.18
 */
@RequestMapping(value = "main")
@RestController
public class ApplicationController {

    @Autowired
    private Converter<ApplicationXml, Application> applicationConverter;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ContractRepository contractRepository;

    @RequestMapping(value = "/getApplication", method = RequestMethod.GET)
    public ResponseEntity findLastApplicationByContractIdXml(@Param("id") Long id) {
        Optional<Application> application = applicationRepository.findById(id);
        return ResponseEntity.ok(application.orElseGet(null));
    }

    @RequestMapping(value = "/getContract", method = RequestMethod.GET)
    public ResponseEntity findLastApplicationByContractIdJson(@Param("id") Long id) {
        Optional<Contract> application = contractRepository.findById(id);
        return ResponseEntity.ok(application.orElseGet(null));
    }
}
