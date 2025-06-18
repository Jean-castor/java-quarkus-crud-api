package testandoquarkus17v.buildrun.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import testandoquarkus17v.buildrun.entity.AddressEntity;
import testandoquarkus17v.buildrun.repository.AddressRepository;

import java.util.List;

@ApplicationScoped
public class AddressService {

    @Inject
    AddressRepository addressRepository;

    public List<AddressEntity> findAll() {
        return addressRepository.findAll().stream().toList();
    }
}

// Transactional -> Interação direta com DB ( não serve para leitura )

