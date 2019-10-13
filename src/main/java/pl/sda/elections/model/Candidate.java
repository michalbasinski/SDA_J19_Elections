package pl.sda.elections.model;

public class Candidate {
    private Long id;
    private String name;
    private String lastName;

    public Candidate(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
