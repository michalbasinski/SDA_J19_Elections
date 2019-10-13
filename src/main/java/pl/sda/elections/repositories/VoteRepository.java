package pl.sda.elections.repositories;

import pl.sda.converter.SDAFileReader;
import pl.sda.converter.SDAFileWriter;
import pl.sda.converter.factories.FileReaderFactory;
import pl.sda.converter.factories.FileWriterFactory;
import pl.sda.elections.model.Vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VoteRepository {

    private String filePath = "/home/michal/SDA/Java19/Projekty/SDA_J19_Elections/src/main/resources/votes.csv";

    private Long currentId;

    private List<Vote> votes;

    public VoteRepository() {
        FileReaderFactory fileReaderFactory = new FileReaderFactory();
        SDAFileReader db = fileReaderFactory.produce(filePath);
        try {
            List<Map<String, Object>> votesFromFile = db.read(filePath);

            this.votes = votesFromFile.stream()
                    .map(x -> new MapToVoteAdapter(x))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            this.votes = new ArrayList<>();
        }
        currentId = findMaxId(votes);
    }

    public Vote save(Vote vote) {
        FileWriterFactory writerFactory = new FileWriterFactory();
        SDAFileWriter writer = writerFactory.produce(filePath);
        currentId = currentId.equals(Long.MIN_VALUE) ? 0 : currentId + 1;

        vote.setId(currentId);
        votes.add(vote);
        List<Map<String, Object>> dataToSave
                = votes.stream().map(x -> objToMap(x)).collect(Collectors.toList());
        writer.write(dataToSave, filePath);
        return vote;
    }

    public List<Vote> getVotes(Long electionsId) {
        return this.votes.stream()
                .filter(x -> electionsId.equals(x.getElectionsId()))
                .collect(Collectors.toList());
    }

    private Long findMaxId(List<Vote> votes) {
        Long maxId = Long.MIN_VALUE;
        for (Vote vote : votes) {
            if (vote.getId() > maxId) {
                maxId = vote.getId();
            }
        }
        return maxId;
    }

    private Map<String, Object> objToMap(Vote vote) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", vote.getId());
        result.put("candidateId", vote.getCandidateId());
        result.put("electionsId", vote.getElectionsId());
        return result;
    }
}
