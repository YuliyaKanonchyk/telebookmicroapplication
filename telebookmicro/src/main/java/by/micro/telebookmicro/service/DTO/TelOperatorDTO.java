package by.micro.telebookmicro.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelOperatorDTO {
    @NotBlank
    @NotNull
    @Size(min = 2, max = 10,message = "Too long or too short name of TelOperator")
    private String operator;
}
