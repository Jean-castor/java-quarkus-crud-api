package testandoquarkus17v.buildrun.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import testandoquarkus17v.buildrun.entity.ProfessionEntity;
import testandoquarkus17v.buildrun.repository.ProfessionRepository;

@QuarkusTest
class ProfessionServiceTest {

    @Inject
    ProfessionRepository professionRepository;

    @Test
    @Transactional
    public void testCreateProfession() {
        var profession = new ProfessionEntity();
        profession.setProfession("Programador");
        profession.setRemuneration(1000);
        profession.setOperatingTime("Programador");
        profession.setProfession("8 horas");

        professionRepository.persist(profession);
    }

}