package testandoquarkus17v.buildrun.entity;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserEntityTest {
    @Test
    @Transactional
    public void testUserEntity(){
        // Preparar
        var userEntity = new UserEntity();
        UUID expectedUuid = UUID.randomUUID();
        String expectedName = "string";
        int expectedAge = 10;

        // Executar
        /*
            Enviando os dados mockados para a entidade de usuário
            E faz a validação do estado inicial
        */

        userEntity.setUserId(expectedUuid);
        userEntity.setUsername(expectedName);
        userEntity.setAge(expectedAge);

        // Verificar
        assertNotNull(userEntity, "A entidade de usuário não deveria ser nula");
        assertEquals(expectedUuid, userEntity.getUserId(), "ID do usuário não corresponde");
        assertEquals(expectedName, userEntity.getUsername(), "Nome do usuário não corresponde");
        assertEquals(expectedAge, userEntity.getAge(), "Idade do usuário não corresponde");
    }

    @Test
    @Transactional
    public void testUserRelationship() {
        /*
            Novas instâncias Sendo criadas vazias
              var profession = new ProfessionEntity();
              var user = new UserEntity();
        */

        // Preparar
        var user = new UserEntity();
        List<UserEntity> users = new ArrayList<>();
        var profession = new ProfessionEntity();
        var adderss = new AddressEntity();

        // Executar
        profession.setUser(user);
        assertSame(user, profession.getUser());

        // Verificar
        /*
            profession.getProfession()
            Deve garantir que não está sendo criada uma nova instância de usuário
            com os mesmos dados
            Deve retornar  exatamente o objeto que foi passado
        */

        /*
            assertSame Compara as refs de memória
            Não apenas os valores
        */

        adderss.setUsers(users);
    }

}