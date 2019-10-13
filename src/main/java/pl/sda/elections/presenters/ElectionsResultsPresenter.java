package pl.sda.elections.presenters;

import pl.sda.elections.counters.VoteCounter;
import pl.sda.elections.model.ElectionsResult;
import pl.sda.elections.model.VotingList;
import pl.sda.elections.repositories.VotingListRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionsResultsPresenter {

    private VoteCounter voteCounter;
    private VotingListRepository votingListRepository;
    private MandateDistribution distributionAlgorithm;

    public ElectionsResultsPresenter(VoteCounter voteCounter, VotingListRepository votingListRepository) {
        this.voteCounter = voteCounter;
        this.votingListRepository = votingListRepository;
        this.distributionAlgorithm = new DHondtMethodAlgorithm();
    }

    public ElectionsResult getResults(Long electionsId, Long mandates) {
        List<VotingList> votingLists
                = votingListRepository.getVotingListsByElectionsId(electionsId);

        Map<Long, Long> listResults = countVotesForList(electionsId, votingLists);

        Map<Long, Long> comiteeMandates = distributionAlgorithm.getMandates(mandates, listResults);
        return new ElectionsResult(0L, electionsId, comiteeMandates);
    }

    private Map<Long, Long> countVotesForList(Long electionsId, List<VotingList> votingLists) {
        Map<Long, Long> listResults = new HashMap<>();
        votingLists.stream()
                .forEach(x -> listResults.put(x.getId(), voteCounter.count(electionsId, x.getId())));
        return listResults;
    }


}
