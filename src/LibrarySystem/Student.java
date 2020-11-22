package LibrarySystem;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String course;


    public Student(int id, String name, String course) {
        setId(id);
        setName(name);
        setCourse(course);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "\n\nName: " + getName();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
