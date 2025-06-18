package testandoquarkus17v.buildrun.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import testandoquarkus17v.buildrun.entity.ProfessionEntity;
import testandoquarkus17v.buildrun.repository.ProfessionRepository;

import java.util.List;

@ApplicationScoped
public class ProfessionService {

    @Inject
    ProfessionRepository professionRepository;

    @Transactional
    public ProfessionEntity createProfession(ProfessionEntity professionEntity) {
        professionRepository.persist(professionEntity);
        return professionEntity;
    }

    public List<ProfessionEntity> findAll(){
        return professionRepository.findAll().stream().toList();
    }
}
