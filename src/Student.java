import java.time.LocalDate;


public class Student {
   private  String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private String faculty;
    private double GPA;
    private String type;

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public String getFaculty() {
        return faculty;
    }
    public double getGPA() {
        return GPA;
    }
    public String getType() {
        return type;
    }

}
