package ru.kharkov.tinkoff.repository;

import org.springframework.data.repository.query.Param;
import ru.kharkov.tinkoff.entity.Application;

public interface ApplicationRepositoryCustom {

    Application findLatestByContractId(@Param("contractId") Long contractId);
}
