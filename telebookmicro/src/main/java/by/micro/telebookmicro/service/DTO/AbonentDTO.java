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
public class AbonentDTO {

    @NotBlank
    @NotNull
    @Size(min = 1, max = 10)
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 10)
    private String surName;

    @NotBlank
    @NotNull
    private Long telebookId;
}
