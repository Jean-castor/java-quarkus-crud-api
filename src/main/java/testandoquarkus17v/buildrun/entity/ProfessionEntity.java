package testandoquarkus17v.buildrun.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.wildfly.common.annotation.NotNull;

import java.util.UUID;

@Entity                                                                 // DEFINE A ENTIDADE / ELA DEVE TER OBRIGATÓRIAMENTE UM CAMPO DE ID
@Table(name = "tb_profession")
@Getter
@Setter
public class ProfessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID professionId;

    @NotNull                                                             // DEFINE QUE O ATRIBUTO NÃO PODE SER NULO
    @Column(name = "profession")
    private String profession;

    @NotNull
    @Column(name = "remuneration")
    private int remuneration;

    @NotNull
    @Column(name = "operating_time")
    private String operatingTime;

    @JsonIgnore
    @OneToOne(mappedBy = "profession")
    private UserEntity user;

}
