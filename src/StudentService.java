import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private final StudentGateway studentGateway;

    public StudentService (File file){
        this.studentGateway = new StudentGateway(file);
    }

    public void printStudents(List<Student>listOfStudents){
        listOfStudents.forEach(x-> System.out.println(x.getSurname() + " " + x.getName()));
    }

    public List<Student> findFacultyEF(){
       return studentGateway.getStudents().stream()
               .filter(x-> x.getFaculty().equals("EF"))
               .collect(Collectors.toList());
    }

    public List<String> findSurname (){
        return studentGateway.getStudents().stream()
                .map(Student::getSurname)
                .collect(Collectors.toList());
    }

    public List<Student> sortByAge(){
        return studentGateway.getStudents().stream()
                .sorted(Comparator.comparing(Student::getBirthday)).toList();

    }

    public List<Student> filterByGPA (){
        return studentGateway.getStudents().stream()
                .filter(x->x.getGPA()>6)
                .collect(Collectors.toList());

    }
    public List<Student> printBudgetFISE (){
        return studentGateway.getStudents().stream().
                filter(x->x.getFaculty().equals("FISE") && x.getType().equals("budget"))
                .collect(Collectors.toList());
    }
    public List<Student> filterBySurname (){
        return studentGateway.getStudents().stream()
                .filter(x->x.getSurname().endsWith("a"))
                .collect(Collectors.toList());
    }

}
