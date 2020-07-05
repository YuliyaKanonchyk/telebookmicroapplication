package by.micro.telebookmicro.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TelNum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 7, max = 7)
    @Getter
    @Setter
    private String telNum;

    @OneToOne
    @Setter
    @Getter
    private TelOperator telOperator;

    @ManyToOne
    @Setter
    private Abonent abonent;

    @Override
    public String toString() {
        return "TelNum{" +
                "id=" + id +
                ", telNum='" + telNum + '\'' +
                ", telOperator=" + telOperator +
                ", abonent=" + abonent.getId() +
                '}';
    }
}
