package by.micro.telebookmicro.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Abonent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 10)
    private String name;
    @NotBlank
    @NotNull
    @Size(min = 1, max = 10)
    private String surName;

    @OneToOne
    private TeleBook teleBook;

    @OneToMany(mappedBy = "abonent")
    private List<TelNum> telNumList;
}
