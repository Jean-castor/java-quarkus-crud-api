package testandoquarkus17v.buildrun.entity;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntityTest {
    @Test
    @Transactional
    public void testAddressEntity(){
        // Preparar
        var addressEntity = new AddressEntity();
        UUID uuid = UUID.randomUUID(); // ID aleatório
        String street = "200";
        String number = "110";
        String city = "Curitiba";
        String state = "PR";

        // Executar
        /*
            Enviando os dados mockados para a entidade de address
        */
        addressEntity.setAddressId(uuid);
        addressEntity.setStreet(street);
        addressEntity.setNumber(number);
        addressEntity.setCity(city);
        addressEntity.setState(state);

        // Verificar
        assertSame(uuid, addressEntity.getAddressId());
        assertSame(street, addressEntity.getStreet());
        assertSame(number, addressEntity.getNumber());
        assertSame(city, addressEntity.getCity());
        assertSame(state, addressEntity.getState());
    }

    /*
        Testa de o método setUser e getUser da AddressEntity() estão funcionando corretamente;
        Testa se o objeto setado no atributo user da classe AddressEntity() está sendo armazenado e recuperado corretamente
    */

    @Test
    public void testUserRelationship() {
        /*
            Novas instâncias de:
              var address = new AddressEntity()();
              var user = new UserEntity();
            Sendo criadas vazias
        */

        // Preparar
        var address = new AddressEntity();
        List<UserEntity> users = new ArrayList<>();

        // Executar
        address.setUsers(users);

        // Verificar
        /*

            address.getAddress()
            Deve garantir que não está sendo criada uma instância de usuário
            com os mesmos dados
            Deve retornar  exatamente o objeto que foi passado

            assertSame Compara as refs de memória
            Não apenas os valores
        */
        assertSame(users, address.getUsers());
    }
}