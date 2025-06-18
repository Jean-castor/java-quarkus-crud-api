package testandoquarkus17v.buildrun.repository;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import testandoquarkus17v.buildrun.entity.ProfessionEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ProfessionRepositoryTest {
    @Inject
    ProfessionRepository professionRepository;

    @Test
    @Transactional
    public void testPersistAndFind(){
        ProfessionEntity profession = new ProfessionEntity();

        // Preparando as informações definidas em testProfessionEntityDto;
        profession.setProfession("Programador");
        profession.setRemuneration(1000);
        profession.setOperatingTime("8 horas");


        // Persistindo as informações;
        professionRepository.persist(profession);
        professionRepository.flush();
        assertNotNull(profession.getProfessionId());

        ProfessionEntity found = professionRepository.find("professionId", profession.getProfessionId()).firstResult();
        assertEquals("Programador", found.getProfession());
        assertEquals(1000, found.getRemuneration());
        assertEquals("8 horas", found.getOperatingTime());
        assertNotNull(found);

    }


@Test
@Transactional
public void testListAll(){
    List<ProfessionEntity> all = professionRepository.listAll();
    assertNotNull(all); // lista não deve ser nula
}

@Test
@Transactional
public void testDelete(){

    // Criano, persistindo e deletando entidade
    var profession = new ProfessionEntity();
    profession.setProfession("Programador");
    profession.setRemuneration(1000);
    profession.setOperatingTime("8 horas");

    professionRepository.persist(profession);
    professionRepository.flush();
    UUID professionId = profession.getProfessionId();

    // deleteById() = fornecido pelo PanacheRepositoryBaseee
    boolean deleted = professionRepository.deleteById(professionId);
    assertTrue(deleted);

    ProfessionEntity deletedEntity = professionRepository.findById(professionId);
    assertNull(deletedEntity);

    }
}