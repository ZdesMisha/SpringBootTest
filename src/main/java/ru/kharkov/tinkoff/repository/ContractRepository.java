package ru.kharkov.tinkoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kharkov.tinkoff.entity.Contract;

/**
 * @author m.kharkov
 * @since 22.06.18
 */
@Repository
public interface ContractRepository extends CrudRepository<Contract, Long> {
}
