package lms.models;

public class Lesson {
    private Long id;
    private String name;
    private String description;

    private static Long generateId = 1L;
    public Lesson() {
        this.id= generateId++;
    }

    public Lesson( String name, String description) {
        this.id= generateId++;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lesson" +
                "\nId:          " + id +
                "\nName:        " + name +
                "\nDescription: " + description
                ;
    }
}
