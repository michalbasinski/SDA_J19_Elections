package pl.sda.elections.repositories;

import pl.sda.elections.model.Candidate;
import pl.sda.elections.model.CandidateList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CandidateListRepository {
    private List<CandidateList> candidateLists = new ArrayList<>();

    private CandidateRepository candidateRepository;

    public CandidateListRepository(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public CandidateListRepository() {
        candidateLists.add(new CandidateList(0L, 0L, 0L));
        candidateLists.add(new CandidateList(1L, 1L, 0L));
        candidateLists.add(new CandidateList(2L, 3L, 3L));
        candidateLists.add(new CandidateList(3L, 4L, 1L));
        candidateLists.add(new CandidateList(4L, 5L, 4L));
        candidateLists.add(new CandidateList(5L, 6L, 3L));
        candidateLists.add(new CandidateList(6L, 7L, 3L));
    }

    public List<Candidate> findCandidatesByListId(Long listId) {
        List<Long> candidateLists = this.candidateLists
                .stream()
                .filter(x -> listId.equals(x.getListId()))
                .map(x -> x.getCandidateId())
                .collect(Collectors.toList());

        List<Candidate> candidates = new ArrayList<>();
        candidateLists.stream().forEach(x -> candidates.add(candidateRepository.findById(x)));
        return candidates;
    }
}
