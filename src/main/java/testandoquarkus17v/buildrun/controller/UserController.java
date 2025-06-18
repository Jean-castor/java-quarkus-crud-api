package testandoquarkus17v.buildrun.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import testandoquarkus17v.buildrun.dto.UserRequestDTO;
import testandoquarkus17v.buildrun.dto.UserResponseDTO;
import testandoquarkus17v.buildrun.entity.UserEntity;
import testandoquarkus17v.buildrun.service.UserService;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON) // DEFINE O TIPO DE DADO PRODUZIDO
@Consumes(MediaType.APPLICATION_JSON) // DEFINE O TIPO DE DADO CONSUMIDO
@Path("/users")                    // DEFINE A ROTA DE USUÁRIOS
@ApplicationScoped                   // DEFINE UNICIDADE DE INSTÂNCIA
public class UserController {

    @Inject
    UserService userService;

    @GET
    public List<UserResponseDTO> getAllUsers() {
        List<UserEntity> users = userService.findAll();
        return UserMapper.toDTOList(users);
    }

    @POST
    @Transactional
    public Response createUser(UserRequestDTO userDTO) {
        var user = userService.createUser(userDTO);
        return Response.status(201).entity(user).build();
    }

}


// Controllers são responsáveis por lidar com requisições HTTP
// E a comunicação com o mundo externo (ex.: front-end ou APIs externas)
// Eles recebem os dados da solicitação
// Chamam os serviços para processá-los, e retornam as respostas.

// Regras de negócio não são recomendáveis aqui

// Transactional -> Interação direta com DB ( não serve para leitura )
