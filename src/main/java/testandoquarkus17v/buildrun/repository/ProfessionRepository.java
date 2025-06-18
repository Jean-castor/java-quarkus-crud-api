package testandoquarkus17v.buildrun.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import testandoquarkus17v.buildrun.entity.ProfessionEntity;

import java.util.UUID;

@ApplicationScoped
public class ProfessionRepository implements PanacheRepositoryBase<ProfessionEntity, UUID> {
}

// ESTABELECE A RELAÇÃO COM O BANCO DE DADOS → PanacheRepository
// PanacheRepository ENVIA A ENTIDADE PARA O BANCO DE DADOS
// ProfessionEntity DEFINE NO BANCO (nome da tabela) (nome das colunas)