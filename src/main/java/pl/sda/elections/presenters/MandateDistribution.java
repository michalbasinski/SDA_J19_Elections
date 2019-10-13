package pl.sda.elections.presenters;

import java.util.Map;

public interface MandateDistribution {
    Map<Long, Long> getMandates(Long mandates, Map<Long, Long> listResults);
}
