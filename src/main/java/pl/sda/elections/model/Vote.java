package pl.sda.elections.model;

public class Vote {
    private Long id;
    private Long candidateId;
    private Long electionsId;

    public Vote(Long candidateId, Long electionsId) {
        this.candidateId = candidateId;
        this.electionsId = electionsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public Long getElectionsId() {
        return electionsId;
    }
}