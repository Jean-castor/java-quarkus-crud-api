package testandoquarkus17v.buildrun.entity;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@Getter
@Setter
public class ProfessionEntityTest {

    @Test
    @Transactional
    public void testProfessionEntity(){
        // Preparar
        var professionEntity = new ProfessionEntity();
        UUID uuid = UUID.randomUUID();
        String name = "Programador";
        int remuneration = 1000;
        String operatingTime = "8 horas";

        // Executar
        /*
            Enviando os dados mockados para a entidade de profissão
        */
        professionEntity.setProfessionId(uuid);
        professionEntity.setProfession(name);
        professionEntity.setRemuneration(remuneration);
        professionEntity.setOperatingTime(operatingTime);

        // Verificar
        assertEquals(uuid, professionEntity.getProfessionId());
        assertEquals(name, professionEntity.getProfession());
        assertEquals(remuneration, professionEntity.getRemuneration());
        assertEquals(operatingTime, professionEntity.getOperatingTime());
    }

    /*
        Testa de o método setUser e getUser da ProfessionEntity estão funcionando corretamente;
        Testa se o objeto setado no atributo user da classe ProfessionEntity está sendo armazenado e recuperado corretamente
    */

    @Test
    @Transactional
    public void testProfessionRelationship() {
        /*
            Novas instâncias de:
              var profession = new ProfessionEntity();
              var user = new UserEntity();
            Sendo criadas vazias
        */

        // Preparar
        var profession = new ProfessionEntity();
        var user = new UserEntity();

        // Executar
        profession.setUser(user);

        // Verificar
        /*
            profession.getProfession()
            Deve garantir que não está sendo criada uma nova instância de usuário
            com os mesmos dados
            Deve retornar  exatamente o objeto que foi passado
        */

        /*
            assertSame Compara as refs de memória
            Não apenas os valores
        */
        assertSame(user, profession.getUser());
    }

}
