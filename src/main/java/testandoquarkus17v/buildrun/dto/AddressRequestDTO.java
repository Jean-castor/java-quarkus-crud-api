package testandoquarkus17v.buildrun.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO implements Serializable {
    // Validação de entrada
    @NotBlank(message = "O campo de rua é obrigatório")
    private String street;

    // Validação de entrada
    @NotBlank(message = "O campo de número é obrigatório")
    private String number;

    // Validação de entrada
    @NotBlank(message = "O campo de cidade é obrigatório")
    @Size(max = 100, message = "A cidade não pode ultrapassar 100 caracteres")
    private String city;

    // Validação de entrada
    @NotBlank(message = "O campo de estado é obrigatório")
    private String state;

}
