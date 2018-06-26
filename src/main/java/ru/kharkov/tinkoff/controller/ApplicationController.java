package ru.kharkov.tinkoff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kharkov.tinkoff.dto.ApplicationDTO;
import ru.kharkov.tinkoff.entity.Application;
import ru.kharkov.tinkoff.repository.ApplicationRepository;

/**
 * @author m.kharkov
 * @since 22.06.18
 */
@RequestMapping(value = "application")
@RestController
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @RequestMapping(value = "/findLatestByContractId", method = RequestMethod.GET)
    public ResponseEntity findLastApplicationByContractIdJson(@RequestParam("id") Long id) {
        Application application = applicationRepository.findLatestByContractId(id);
        return ResponseEntity.ok(new ApplicationDTO(application));
    }
}
