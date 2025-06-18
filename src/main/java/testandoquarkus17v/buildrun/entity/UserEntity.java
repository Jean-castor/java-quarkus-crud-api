package testandoquarkus17v.buildrun.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import org.wildfly.common.annotation.NotNull;

import java.util.UUID;

@Entity                                                                                                            // REPRESENTA UMA TABELA NO BANCO DE DADOS (ENTIDADE)
@Table(name = "tb_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;                                                                                         // UUID -> COMPOSTO POR VALORES LONG INTERNAMENTE

    @NotNull                                                                                                   
    @Column(name = "name")                                                                                      // DEFINE O NOME DA COLUNA DE NOME DO USUÁRIO
    private String username;

    @NotNull
    private Integer age;

    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.REFRESH}, fetch = FetchType.EAGER)                     // VÁRIOS USUÁRIOS PODEM TER O MESMO ENDEREÇO
    private AddressEntity address;

    @JoinColumn(name = "profession", referencedColumnName = "professionId")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProfessionEntity profession;

}


/*
    ALL: Todas as operações de persistência (inserção, atualização, remoção, etc.) realizadas na entidade principal também serão aplicadas à entidade associada.
*/

/*
     O `trim()` remove espaços em branco no ínicio e no final de uma cadeia
     Ele não altera a string original, mas retorna uma nova string com os espaços removidos.
 */

/*
  A entidade `UserEntity`, é uma classe que representa diretamente a tabela de usuário no banco de dados.
    Serve principalmente para mapear os dados persistidos e transitá-los dentro do sistema.
    Regras de negócio pesadas não vão em entidades
*/
/*
    Regras de validação simples ou comportamentos focados nos próprios dados da entidade.
    EXEMPLO:
        Garantir consistência entre atributos internos (ex.: ajustar o nome para sempre salvar em formato normalizado);
        Regras básicas relacionadas à forma como os dados da própria entidade são manipulados.
*/

 /*
    Active Recod Pattern -> padrão de acesso padara DB
    PanacheEntityBase -> permite acesso direto ao banco de dados
    GeneratedValue(strategy = GenerationType.UUID) GERA O ID DO USER AUTOMÁTICAMENTE
 */
