package testandoquarkus17v.buildrun.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import testandoquarkus17v.buildrun.entity.ProfessionEntity;

import java.util.UUID;

@ApplicationScoped
public class ProfessionRepository implements PanacheRepositoryBase<ProfessionEntity, UUID> {
}
