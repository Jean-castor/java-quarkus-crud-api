package testandoquarkus17v.buildrun.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import testandoquarkus17v.buildrun.controller.UserMapper;
import testandoquarkus17v.buildrun.dto.UserRequestDTO;
import testandoquarkus17v.buildrun.dto.UserResponseDTO;
import testandoquarkus17v.buildrun.entity.UserEntity;
import testandoquarkus17v.buildrun.repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    /*Create user reotna u*/
    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userDTO){
        UserEntity user = UserMapper.toEntity(userDTO);
        userRepository.persist(user);
        return UserMapper.toResponseDTO(user);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll().stream().toList();
    }
}























// Atua como intermediário entre a camada de controle (Controllers) e a camada de acesso a dados (Repositories/DAOs)

// Abriga regras de negócio mais cemplexas e importantes
// Interage com as entidades e repositórios
// Para executar operações de maneira que combinem lógica de negócio.

// PODE CONTER REGRAS COMO:
// - Validação entre múltiplas entidades ou valores externos;
// - Processamento de dados que precisa seguir fluxos ou condições específicas;
// - Integração de dados com outras partes do sistema (como APIs ou repositórios).

// - Sempre que a lógica de negócio não puder ser confinada
//   A uma única entidade ou necessitar de múltiplas interações.
