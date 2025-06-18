package testandoquarkus17v.buildrun.repository;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import testandoquarkus17v.buildrun.entity.AddressEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class AddressRepositoryTest {
    @Inject
    AddressRepository addressRepository;

    @Test
    @Transactional
    public void testPersistAndFind(){
        AddressEntity address = new AddressEntity();

        // Preparando as informações definidas em testAddressEntityDto;
        address.setStreet("200");
        address.setNumber("110");
        address.setCity("Curitiba");
        address.setState("PR");

        // Persistindo as informações;
        addressRepository.persist(address);
        addressRepository.flush();
        assertNotNull(address.getAddressId());

        AddressEntity found = addressRepository.find("addressId", address.getAddressId()).firstResult();
        assertEquals("200", found.getStreet());
        assertEquals("110", found.getNumber());
        assertEquals("Curitiba", found.getCity());
        assertEquals("PR", found.getState());

    }

    @Test
    @Transactional
    public void testListAll(){
        List<AddressEntity> all = addressRepository.listAll();
        assertNotNull(all); // lista não deve ser nula
    }

    @Test
    @Transactional
    public void testDelete(){

        // Criano, persistindo e deletando entidade
        var address = new AddressEntity();
        address.setStreet("200");
        address.setNumber("110");
        address.setCity("Curitiba");
        address.setState("PR");

        addressRepository.persist(address);
        addressRepository.flush();
        UUID addressId = address.getAddressId();

        // deleteById() = fornecido pelo PanacheRepositoryBaseee
        boolean deleted = addressRepository.deleteById(addressId);
        assertTrue(deleted);

        AddressEntity deletedEntity = addressRepository.findById(addressId);
        assertNull(deletedEntity);

    }

}