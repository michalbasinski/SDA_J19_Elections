package pl.sda;

import pl.sda.elections.ElectionFacade;
import pl.sda.elections.model.Vote;

public class App
{
    public static void main( String[] args )
    {
        ElectionFacade facade = new ElectionFacade();
        facade.vote(new Vote(1L,1L));
        facade.vote(new Vote(2L,1L));
        facade.vote(new Vote(1L,1L));
        facade.vote(new Vote(5L,1L));
        facade.vote(new Vote(8L,1L));
    }
}
