package pl.sda.elections.counters;

import lombok.AllArgsConstructor;
import pl.sda.elections.model.Candidate;
import pl.sda.elections.model.Vote;
import pl.sda.elections.repositories.VoteRepository;
import pl.sda.elections.repositories.VotingListRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class VoteCounter {

    private VotingListRepository votingListRepository;
    private VoteRepository voteRepository;

    public Long count(Long electionId, Long listId) {
        List<Candidate> candidatesByListIdAndElectionsId
                = votingListRepository.findCandidatesByListIdAndElectionsId(listId, electionId);

        List<Vote> votes = voteRepository.getVotes(electionId);

        List<Long> collect = candidatesByListIdAndElectionsId.stream()
                .map(x -> x.getId())
                .collect(Collectors.toList());

        return (long) votes.stream()
                .filter(x -> collect.contains(x.getCandidateId()))
                .collect(Collectors.toList()).size();

    }
}
