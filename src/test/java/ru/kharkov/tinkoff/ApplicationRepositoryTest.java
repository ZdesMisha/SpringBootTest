package ru.kharkov.tinkoff;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kharkov.tinkoff.entity.Application;
import ru.kharkov.tinkoff.exception.SimpleDataException;
import ru.kharkov.tinkoff.repository.ApplicationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationRepositoryTest {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Test
    public void findLatestByContractIdTest(){
        Application latestByContractId = applicationRepository.findLatestByContractId(1L);
        Assert.assertTrue(latestByContractId.getId().equals(1L));
    }

    @Test(expected = SimpleDataException.class)
    public void findLatestByNotExistingContractIdTest(){
        applicationRepository.findLatestByContractId(9999L);
    }
}
