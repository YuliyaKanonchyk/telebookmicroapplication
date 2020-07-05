package by.learn.mainmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeleBookDTOMain {
    private Long cityID;
    private List<AbonentDTOMain> abonentList;
}
