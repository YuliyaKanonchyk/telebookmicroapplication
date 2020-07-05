package by.micro.telebookmicro.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeleBookDTO {
    @NotBlank
    @NotNull
    private Long cityID;
    private List<AbonentDTO> abonentList;
}
