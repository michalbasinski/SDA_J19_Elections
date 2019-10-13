package pl.sda.elections;

import pl.sda.elections.counters.VoteCounter;
import pl.sda.elections.model.ElectionsResult;
import pl.sda.elections.model.Vote;
import pl.sda.elections.presenters.ElectionsResultsPresenter;
import pl.sda.elections.repositories.CandidateListRepository;
import pl.sda.elections.repositories.CandidateRepository;
import pl.sda.elections.repositories.VoteRepository;
import pl.sda.elections.repositories.VotingListRepository;

public class ElectionFacade {

    private VoteRepository voteRepository = new VoteRepository();

    public boolean vote(Vote vote){
        Vote savedVote = voteRepository.save(vote);
        return savedVote.getId() != null;
    }

    public ElectionsResult getResults(Long electionsId) {
        VoteRepository voteRepository = new VoteRepository();
        CandidateRepository candidateRepository = new CandidateRepository();
        CandidateListRepository candidateListRepository = new CandidateListRepository(candidateRepository);
        VotingListRepository votingListRepository = new VotingListRepository(candidateListRepository);
        VoteCounter counter = new VoteCounter(votingListRepository, voteRepository);

        ElectionsResultsPresenter presenter = new ElectionsResultsPresenter(counter, votingListRepository);
        return presenter.getResults(electionsId, 60L);
    }


}
