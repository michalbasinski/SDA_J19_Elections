package pl.sda.elections.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class Vote {

    @Setter
    private Long id;
    private Long candidateId;
    private Long electionsId;

    public Vote(Long candidateId, Long electionsId) {
        this.candidateId = candidateId;
        this.electionsId = electionsId;
    }
}