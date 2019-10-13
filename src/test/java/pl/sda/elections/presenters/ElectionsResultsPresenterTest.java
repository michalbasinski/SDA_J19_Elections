package pl.sda.elections.presenters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.sda.elections.counters.VoteCounter;
import pl.sda.elections.model.ElectionsResult;
import pl.sda.elections.model.VotingList;
import pl.sda.elections.repositories.VotingListRepository;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ElectionsResultsPresenterTest {

    @Mock
    private VoteCounter voteCounter;

    @Mock
    private VotingListRepository votingListRepository;

    @InjectMocks
    private ElectionsResultsPresenter presenter = new ElectionsResultsPresenter(voteCounter, votingListRepository);

    @Test
    public void getResults() {

        when(votingListRepository.getVotingListsByElectionsId(1L))
                .thenReturn(Arrays.asList(new VotingList(0L, 1L, "Komitet wyborczy Java", 1L)
                        , new VotingList(1L, 1L, "Komitet wyborczy APL", 2L)));

        when(voteCounter.count(1L, 0L)).thenReturn(10000L);
        when(voteCounter.count(1L, 1L)).thenReturn(5000L);

        ElectionsResult results = presenter.getResults(1L, 50L);
    }
}