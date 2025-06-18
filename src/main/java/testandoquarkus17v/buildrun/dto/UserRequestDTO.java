package testandoquarkus17v.buildrun.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Data // gera automaticamente getters, setters, equals, hashCode e toString
@AllArgsConstructor //  gera um construtor com todos os campos como parâmetros;
@NoArgsConstructor // - gera um construtor sem parâmetro
@Getter
@Setter
public class UserRequestDTO implements Serializable {
    @NotBlank(message = "O nome de usuário é obrigatório")
    private String username;

    @Min(value = 18, message = "Idade mínima é 18 anos")
    private Integer age;

    private AddressRequestDTO address;
    private ProfessionRequestDTO profession;

}


