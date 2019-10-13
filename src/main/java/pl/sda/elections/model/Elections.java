package pl.sda.elections.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Elections {
    private Long id;
    private LocalDate date;
}
