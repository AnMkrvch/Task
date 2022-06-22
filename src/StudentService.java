import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentService {
    private final StudentGateway studentGateway;
    public StudentService (File file){
        this.studentGateway = new StudentGateway(file);
    }

    public List<Student> makeList(int k){
        if (k==1){
            return findFacultyEF();
        } else if (k==2){
           return  findSurname();
        } else if (k==3){
            return sortByAge();
        } else if (k==4){
            return filterByGPA();
        } else if (k==5){
            return printBudgetFISE() ;
        } else if (k==6){
            return filterBySurname();
        } else{
            System.out.println("incorrect value");
            return null;
        }
    }

    private List<Student> findFacultyEF(){
       return studentGateway.getStudents().stream()
               .filter(x-> x.getFaculty().equals("EF"))
               .collect(Collectors.toList());
    }
    private List<Student> findSurname (){
        return studentGateway.getStudents().stream()
                .filter(x->Objects.equals(x.getSurname(), "Ivanova") || Objects.equals(x.getSurname(), "Ivanov"))
                .collect(Collectors.toList());

    }
    private List<Student> sortByAge(){
        return studentGateway.getStudents().stream()
                .sorted(Comparator.comparing(Student::getBirthday)).toList();

    }
    private List<Student> filterByGPA (){
        return studentGateway.getStudents().stream()
                .filter(x->x.getGPA()>6)
                .collect(Collectors.toList());

    }
    private List<Student> printBudgetFISE (){
        return studentGateway.getStudents().stream()
                .filter(x-> Objects.equals(x.getFaculty(), "FISE") && Objects.equals(x.getType(), "budget"))
                .collect(Collectors.toList());
    }
    private List<Student> filterBySurname (){
        return studentGateway.getStudents().stream()
                .filter(x->x.getSurname().endsWith("a"))
                .collect(Collectors.toList());
    }
}
