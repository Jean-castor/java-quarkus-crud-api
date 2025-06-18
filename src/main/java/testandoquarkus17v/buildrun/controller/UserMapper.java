package testandoquarkus17v.buildrun.controller;

import testandoquarkus17v.buildrun.dto.*;
import testandoquarkus17v.buildrun.entity.AddressEntity;
import testandoquarkus17v.buildrun.entity.ProfessionEntity;
import testandoquarkus17v.buildrun.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    // Métodos para user
    public static UserResponseDTO toResponseDTO(UserEntity entity){

        // Evita NullPointerException ao tentar acessar propriedades de um objeto nulo
        if(entity == null) return null;

        /*
            Cria uma nova instância do DTO que será retornado
        */
        UserResponseDTO dto = new UserResponseDTO();

        /*
            Passando o id de usuário para o DTO
        */
        dto.setUserId(entity.getUserId());

        /*
            Passando nome de usuário para o DTO
        */
        dto.setUsername(entity.getUsername());

        /*
            Passando a idade do usuário para o DTO
        */
        dto.setAge(entity.getAge());

        /*
            Se a entidade de endereço NÃO for nula.
            O endereço é passado para a entidade de user
            No final, retorna o dto com os atributos
        */
        if(entity.getAddress() != null){
            dto.setAddress(toDTO(entity.getAddress()));
        }
        return dto;
    }

    public static UserEntity toEntity(UserRequestDTO dto) {
        if (dto == null) return null;

        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setAge(dto.getAge());

        if (dto.getAddress() != null) {
            entity.setAddress(toEntity(dto.getAddress()));
        }
        return entity;
    }

    public static List<UserResponseDTO> toDTOList(List<UserEntity> entities) {
        return entities.stream()
                .map(UserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Métodos para Address
    public static AddressResponseDTO toDTO(AddressEntity entity) {
        if (entity == null) return null;

        AddressResponseDTO dto = new AddressResponseDTO();
        dto.setAddressId(entity.getAddressId());
        dto.setCity(entity.getCity());
        dto.setNumber(entity.getNumber());
        dto.setState(entity.getState());

        return dto;
    }

    public static AddressEntity toEntity(AddressRequestDTO dto) {
        if (dto == null) return null;

        AddressEntity entity = new AddressEntity();
        entity.setCity(dto.getCity());

        return entity;
    }

    // Métodos para Profession
// Métodos para Profession
    public static ProfessionResponseDTO toDTO(ProfessionEntity entity) {
        if (entity == null) return null;

        ProfessionResponseDTO dto = new ProfessionResponseDTO();
        dto.setProfessionId(entity.getProfessionId());
        dto.setName(entity.getProfession()); // Observação: o campo na entidade se chama "profession", não "name"

        return dto;
    }

    public static ProfessionEntity toEntity(ProfessionRequestDTO dto) {
        if (dto == null) return null;

        ProfessionEntity entity = new ProfessionEntity();
        entity.setProfession(dto.getName()); // Convertendo name do DTO para profession da entidade

        return entity;
    }



}
