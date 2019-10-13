package pl.sda.elections.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

//Odpowiednik w SQL: tabela asocjacyjna
@AllArgsConstructor
@Getter
public class CandidateList {
    private Long id;
    private Long candidateId;
    private Long listId;
}