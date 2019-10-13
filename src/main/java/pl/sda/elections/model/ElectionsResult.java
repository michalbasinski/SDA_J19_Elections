package pl.sda.elections.model;

import java.util.Map;

public class ElectionsResult {
    private Long id;
    private Long electionsId;
    private Map<Long, Long> committeeMandates;

    public ElectionsResult(Long id, Long electionsId, Map<Long, Long> committeeMandates) {
        this.id = id;
        this.electionsId = electionsId;
        this.committeeMandates = committeeMandates;
    }

    public Long getId() {
        return id;
    }

    public Long getElectionsId() {
        return electionsId;
    }

    public Map<Long, Long> getCommitteeMandates() {
        return committeeMandates;
    }
}
