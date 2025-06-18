// UserResponseDTO.java
package testandoquarkus17v.buildrun.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO implements Serializable {
    private UUID userId;
    private String username;
    private Integer age;
    private AddressResponseDTO address;
}