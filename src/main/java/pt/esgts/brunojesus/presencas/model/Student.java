package pt.esgts.brunojesus.presencas.model;

/**
 * The student model, represents a student in the repository
 *
 * @author Bruno Jesus
 * @since 2022-04-21
 * @version 1.0
 */
public class Student {

    private long id;
    private String name;

    public Student() {
    }

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Creates a Student instance
     *
     * @param id The student id
     * @param name The student name
     * @return The Student instance
     */
    public static Student of(long id, String name) {
        return new Student(id, name);
    }

    public long getId() {
        return id;
    }

    public Student setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }
}
