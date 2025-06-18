package testandoquarkus17v.buildrun.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import testandoquarkus17v.buildrun.entity.UserEntity;

import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<UserEntity, UUID> {

}

// Repositórios são responsáveis por interagir diretamente com o banco de dados
// Regras de negócio não deveriam ser implementadas em repositórios

// - Usar para consulta e manipulação de dados no banco
