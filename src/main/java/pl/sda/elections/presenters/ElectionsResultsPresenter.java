package pl.sda.elections.presenters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.sda.elections.counters.VoteCounter;
import pl.sda.elections.model.ElectionsResult;
import pl.sda.elections.model.VotingList;
import pl.sda.elections.repositories.VotingListRepository;

import java.util.*;

@AllArgsConstructor
public class ElectionsResultsPresenter {

    private VoteCounter voteCounter;
    private VotingListRepository votingListRepository;

    public ElectionsResult getResults(Long electionsId, Long mandates) {
        List<VotingList> votingLists
                = votingListRepository.getVotingListsByElectionsId(electionsId);

        Map<Long, Long> listResults = new HashMap<>();
        votingLists.stream()
                .forEach(x -> listResults.put(x.getId(), voteCounter.count(electionsId, x.getId())));

        List<Quotient> quotients = new ArrayList<>();

        for (Long listId : listResults.keySet()) {
            quotients.addAll(getQuotientsForList(listResults.get(listId), mandates, listId));
        }

        quotients.sort((Quotient x, Quotient y) -> (int) (y.getValue() - x.getValue()));

        Map<Long, Long> comiteeMandates = new HashMap<>();
        quotients.subList(0, Math.toIntExact(mandates))
                .stream()
                .forEach(x -> {
                    if (comiteeMandates.get(x.getListId()) == null) {
                        comiteeMandates.put(x.getListId(), 0L);
                    }
                    comiteeMandates.put(x.getListId(), comiteeMandates.get(x.getListId()) + 1);
                });
        return new ElectionsResult(0L, electionsId, comiteeMandates);

    }

    private List<Quotient> getQuotientsForList(Long voteCount, Long mandates, Long listId) {
        List<Quotient> results = new ArrayList<>();
        for (int i = 1; i <= mandates; i++) {
            results.add(new Quotient(i, voteCount / i, listId));
        }
        return results;
    }

    @AllArgsConstructor
    @Getter
    private class Quotient {
        private int n;
        private Long value;
        private Long listId;
    }

}
