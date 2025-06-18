package testandoquarkus17v.buildrun.repository;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import testandoquarkus17v.buildrun.entity.ProfessionEntity;
import testandoquarkus17v.buildrun.entity.UserEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserRepositoryTest {

    @Inject
    UserRepository userRepository;

    @Test
    @Transactional
    public void testPersistAndFind() {
        UserEntity user = new UserEntity();

        user.setUsername("string");
        user.setAge(10);
        user.persist();
        userRepository.flush();
        assertNotNull(user.getUserId());

        UserEntity found = userRepository.find("userId", user.getUserId()).firstResult();
        assertEquals("string", found.getUsername());
        assertEquals( 10, found.getAge());
        assertNotNull(found);
    }

    @Test
    @Transactional
    public void testListAll(){
        List<UserEntity> all = userRepository.listAll();
        assertNotNull(all); // lista não deve ser nula
    }

    @Test
    @Transactional
    public void testDelete(){

        // Criando, persistindo e deletando entidade
        var user = new UserEntity();
        user.setUsername("string");
        user.setAge(10);

        userRepository.persist(user);
        userRepository.flush();
        UUID userId = user.getUserId();

        // deleteById() = fornecido pelo PanacheRepositoryBaseee
        boolean deleted = userRepository.deleteById(userId);
        assertTrue(deleted);

        var deletedEntity = userRepository.findById(userId);
        assertNull(deletedEntity);

    }

}