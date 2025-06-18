package testandoquarkus17v.buildrun.dto;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfessionRequestDTO implements Serializable {
    private String name;
    private UUID professionId;
}