package pl.sda.elections.repositories;

import pl.sda.elections.model.CandidateList;

import java.util.ArrayList;
import java.util.List;

public class CandidateListRepository {
    private List<CandidateList> candidateLists = new ArrayList<>();

    public CandidateListRepository() {
        candidateLists.add(new CandidateList(0L, 0L, 0L));
        candidateLists.add(new CandidateList(1L, 1L, 0L));
        candidateLists.add(new CandidateList(2L, 3L, 3L));
        candidateLists.add(new CandidateList(3L, 4L, 1L));
        candidateLists.add(new CandidateList(4L, 5L, 4L));
        candidateLists.add(new CandidateList(5L, 6L, 3L));
        candidateLists.add(new CandidateList(6L, 7L, 3L));
    }
}
