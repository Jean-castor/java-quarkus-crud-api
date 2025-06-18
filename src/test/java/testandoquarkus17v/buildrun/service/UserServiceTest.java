package testandoquarkus17v.buildrun.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import testandoquarkus17v.buildrun.entity.AddressEntity;
import testandoquarkus17v.buildrun.entity.UserEntity;
import testandoquarkus17v.buildrun.repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;

@QuarkusTest
class UserServiceTest {

    @Inject
    UserRepository userRepository;

    @Test
    @Transactional
    public void createUser() {
        var user = new UserEntity();
        user.setUsername("string");
        user.setAge(10);

        userRepository.persist(user);
    }

    @Test
    @Transactional
    public void findAll() {
        List<UserEntity> users = userRepository.listAll();

        // Verificando se a lista não é nulaaa;
        assertNotNull(users);

        // Verificando se a lista está vazia;
        assertTrue(users.size() >= 0);
    }
}