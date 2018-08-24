package fiap.lab.microservices.apiexample.model;

public class Sample {

    private Integer id;

    private String description;

    public Sample(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
