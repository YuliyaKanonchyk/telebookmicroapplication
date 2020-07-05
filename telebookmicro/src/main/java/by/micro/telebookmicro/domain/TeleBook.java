package by.micro.telebookmicro.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeleBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long id;

    @OneToOne
    @Setter
    @Getter
    private City city;

    @OneToMany
    @Setter
    private List<Abonent> abonentList;
}
