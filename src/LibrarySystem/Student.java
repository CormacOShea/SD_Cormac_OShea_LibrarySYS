package LibrarySystem;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String Tnumber;
    private String name;
    private String course;
    private static int count=0;


    public Student(String Tnumber,int id, String name, String course) {
        setId();
        setTnumber(Tnumber);
        setName(name);
        setCourse(course);
    }

    public String getTnumber() {
        return Tnumber;
    }

    public void setTnumber(String tnumber) {
        this.Tnumber = tnumber;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        count++;
        this.id = count;
    }

    public static int getCount() {
        return count;
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
