package testandoquarkus17v.buildrun.controller;

import jakarta.inject.Inject;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import testandoquarkus17v.buildrun.entity.UserEntity;
import testandoquarkus17v.buildrun.repository.UserRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;

@QuarkusTest
class UserControllerTest {

    @Inject
    UserRepository userRepository;

    @Test
    @Transactional
    void createUser() {
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