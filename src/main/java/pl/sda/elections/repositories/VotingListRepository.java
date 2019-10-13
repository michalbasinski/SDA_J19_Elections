package pl.sda.elections.repositories;

import pl.sda.elections.model.Candidate;
import pl.sda.elections.model.VotingList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VotingListRepository {
    private List<VotingList> votingLists = new ArrayList<>();

    private CandidateListRepository candidateListRepository;

    public VotingListRepository(CandidateListRepository candidateListRepository) {
        votingLists.add(new VotingList(0L, 1L, "Komitet wyborczy Java", 1L));
        votingLists.add(new VotingList(1L, 1L, "Komitet wyborczy APL", 2L));
        votingLists.add(new VotingList(2L, 1L, "Komitet wyborczy Python", 3L));
        votingLists.add(new VotingList(3L, 1L, "Komitet wyborczy PHP", 4L));

        this.candidateListRepository = candidateListRepository;
    }

    public List<Candidate> findCandidatesByListIdAndElectionsId(Long listId, Long electionsId) {
        return candidateListRepository.findCandidatesByListId(listId);
    }

    public List<VotingList> getVotingListsByElectionsId(Long electionsId) {
        return votingLists.stream()
                .filter(x -> electionsId.equals(x.getElectionsId()))
                .collect(Collectors.toList());
    }
}
