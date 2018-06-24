package ru.kharkov.tinkoff.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.kharkov.tinkoff.entity.Application;
import ru.kharkov.tinkoff.exception.SimpleDataException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ApplicationRepositoryImpl implements ApplicationRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Application findLatestByContractId(Long contractId) {
        List<Application> applications = em.createQuery(
                "SELECT a FROM Application a WHERE a.contract.id =:contractId", Application.class)
                .setParameter("contractId", contractId)
                .setMaxResults(1)
                .getResultList();
        if(applications.size() == 0){
            throw new SimpleDataException(String.format("Заявки с Id = %d не найдено.",contractId));
        }else{
            return applications.get(0);
        }
    }
}
