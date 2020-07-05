package by.micro.telebookmicro.service.DTO;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
public class NumberDTO {
    @NotBlank
    @NotNull
    @Size(min = 7, max = 7)
    private String telNum;
    @NotBlank
    @NotNull
    private Long telOperatorID;
    @NotBlank
    @NotNull
    private Long abonentID;
}
