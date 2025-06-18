package testandoquarkus17v.buildrun.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import testandoquarkus17v.buildrun.entity.AddressEntity;
import testandoquarkus17v.buildrun.repository.AddressRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;

@QuarkusTest
class AddressServiceTest {

    @Inject
    AddressRepository addressRepository;

    @Test
    @Transactional
    public void createAddress() {
        var address = new AddressEntity();
        address.setCity("Curitiba");
        address.setStreet("200");
        address.setNumber("110");
        address.setState("PR");

        addressRepository.persist(address);
    }

    @Test
    @Transactional
    public void findAll() {
        List<AddressEntity> addresses = addressRepository.listAll();

        // Verificando se a lista não é nulaaa;
        assertNotNull(addresses);

        // Verificando se a lista está vazia;
        assertTrue(addresses.size() >= 0);
    }
}