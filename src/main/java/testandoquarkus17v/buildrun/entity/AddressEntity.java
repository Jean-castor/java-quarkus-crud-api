package testandoquarkus17v.buildrun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.wildfly.common.annotation.NotNull;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_user_address")
@Getter
@Setter
public class AddressEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID addressId;

    @NotNull
    @Column(name = "user_address")
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String number;

    @NotNull
    private String state;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<UserEntity> users;


}
