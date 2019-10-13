package pl.sda;

import pl.sda.elections.ElectionFacade;
import pl.sda.elections.model.ElectionsResult;
import pl.sda.elections.model.Vote;

public class App {
    public static void main(String[] args) {
        ElectionFacade facade = new ElectionFacade();
        facade.vote(new Vote(1L, 1L));
        facade.vote(new Vote(3L, 1L));
        facade.vote(new Vote(1L, 1L));
        facade.vote(new Vote(1L, 1L));
        facade.vote(new Vote(4L, 1L));

        ElectionsResult results = facade.getResults(1L);

    }
}
