package pl.sda.elections;

import pl.sda.elections.model.ElectionsResult;
import pl.sda.elections.model.Vote;
import pl.sda.elections.repositories.VoteRepository;

public class ElectionFacade {

    private VoteRepository voteRepository = new VoteRepository();

    public boolean vote(Vote vote){
        Vote savedVote = voteRepository.save(vote);
        return savedVote.getId() != null;
    }

    public ElectionsResult getResults(Long electionsId) {
        return null;
    }

    public static void main(String[] args) {
        ElectionFacade facade = new ElectionFacade();
        for (int i= 0; i < 100000; i++){
        facade.vote(new Vote(1L,1L));
        facade.vote(new Vote(3L,1L));
        facade.vote(new Vote(4L,1L));
        facade.vote(new Vote(5L,1L));
        facade.vote(new Vote(6L,1L));
        facade.vote(new Vote(6L,1L));
        facade.vote(new Vote(7L,1L));
        facade.vote(new Vote(0L,1L));
        facade.vote(new Vote(7L,1L));
        facade.vote(new Vote(1L,1L));
        facade.vote(new Vote(1L,1L));
        }
    }
}
