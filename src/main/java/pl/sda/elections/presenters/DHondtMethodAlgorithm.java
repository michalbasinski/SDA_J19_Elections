package pl.sda.elections.presenters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DHondtMethodAlgorithm implements MandateDistribution {

    @Override
    public Map<Long, Long> getMandates(Long mandates, Map<Long, Long> listResults) {
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
        return comiteeMandates;
    }

    private List<Quotient> getQuotientsForList(Long voteCount, Long mandates, Long listId) {
        List<Quotient> results = new ArrayList<>();
        for (int i = 1; i <= mandates; i++) {
            results.add(new Quotient(i, voteCount / i, listId));
        }
        return results;
    }
}
