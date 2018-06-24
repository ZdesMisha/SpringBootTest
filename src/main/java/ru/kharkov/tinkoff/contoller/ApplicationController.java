package ru.kharkov.tinkoff.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kharkov.tinkoff.entity.Application;
import ru.kharkov.tinkoff.exception.ConversionException;
import ru.kharkov.tinkoff.projection.ApplicationProjection;
import ru.kharkov.tinkoff.repository.ApplicationRepository;
import ru.kharkov.tinkoff.schema.ApplicationXml;
import ru.kharkov.tinkoff.service.Converter;


/**
 * @author m.kharkov
 * @since 22.06.18
 */
@RequestMapping(value = "application")
@RestController
public class ApplicationController {

    @Autowired
    private Converter<ApplicationXml, Application> applicationConverter;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ProjectionFactory projectionFactory;

    @RequestMapping(value = "/findLatestByContractIdJson", method = RequestMethod.GET)
    public ResponseEntity findLastApplicationByContractIdXml(@RequestParam("id") Long id) {
        Application application = applicationRepository.findLatestByContractId(id);
        return ResponseEntity.ok(projectionFactory.createProjection(ApplicationProjection.MainProjection.class, application));
    }

    @RequestMapping(value = "/findLatestByContractIdXml", method = RequestMethod.GET)
    public ResponseEntity findLastApplicationByContractIdJson(@RequestParam("id") Long id) throws ConversionException{
        Application application = applicationRepository.findLatestByContractId(id);
        return ResponseEntity.ok(applicationConverter.convert(application));
    }
}
