package pl.sda.elections.repositories;

import pl.sda.elections.model.Vote;

import java.util.Map;

public class MapToVoteAdapter extends Vote {
    private Map<String, Object> votesRaw;

    public MapToVoteAdapter(Map<String, Object> votesRaw) {
        this.votesRaw = votesRaw;
    }

    @Override
    public Long getId() {
        return Long.parseLong( votesRaw.get("id").toString());
    }

    @Override
    public void setId(Long id) {
        votesRaw.put("id", id);
    }

    @Override
    public Long getCandidateId() {
        return  Long.parseLong(votesRaw.get("candidateId").toString());
    }

    @Override
    public Long getElectionsId() {
        return Long.parseLong(votesRaw.get("electionsId").toString());
    }
}
