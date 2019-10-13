package pl.sda.elections.repositories;

import pl.sda.elections.model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateRepository {
    private List<Candidate> candidateList = new ArrayList<>();

    public CandidateRepository() {
        candidateList.add(new Candidate(0L, "Primus", "Javowy"));
        candidateList.add(new Candidate(1L, "Secundus", "Javowy"));
        candidateList.add(new Candidate(3L, "Primus", "PHPowy"));
        candidateList.add(new Candidate(4L, "Tercjusz", "APLowy"));
        candidateList.add(new Candidate(5L, "Tercjusz", "PHPowy"));
        candidateList.add(new Candidate(6L, "Secundus", "Pythonowy"));
        candidateList.add(new Candidate(7L, "Primus", "Pythonowy"));
    }
}
