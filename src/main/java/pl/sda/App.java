package pl.sda;

import pl.sda.elections.ElectionFacade;
import pl.sda.elections.counters.VoteCounter;
import pl.sda.elections.model.Vote;
import pl.sda.elections.repositories.CandidateListRepository;
import pl.sda.elections.repositories.CandidateRepository;
import pl.sda.elections.repositories.VoteRepository;
import pl.sda.elections.repositories.VotingListRepository;

public class App
{
    public static void main( String[] args )
    {
        ElectionFacade facade = new ElectionFacade();
        facade.vote(new Vote(1L,1L));
        facade.vote(new Vote(3L,1L));
        facade.vote(new Vote(1L,1L));
        facade.vote(new Vote(1L,1L));
        facade.vote(new Vote(4L,1L));

        VoteRepository voteRepository = new VoteRepository();
        CandidateRepository candidateRepository = new CandidateRepository();
        CandidateListRepository candidateListRepository = new CandidateListRepository(candidateRepository);
        VotingListRepository votingListRepository = new VotingListRepository(candidateListRepository);
        VoteCounter counter = new VoteCounter(votingListRepository, voteRepository);

        System.out.println(counter.count(1L, 0L));
        System.out.println(counter.count(1L, 1L));
        System.out.println(counter.count(1L, 2L));
        System.out.println(counter.count(1L, 3L));


    }
}
