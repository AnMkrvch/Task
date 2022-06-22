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
            return findByFaculty();
        } else if (k==2){
           return  findSurnames();
        } else if (k==3){
            return findByAge();
        } else if (k==4){
            return findByGpa();
        } else if (k==5){
            return findByBudgetFISE() ;
        } else if (k==6){
            return findBySurname();
        } else{
            System.out.println("incorrect value");
            return null;
        }
    }

    private List<Student> findByFaculty(){
       return studentGateway.getStudents().stream()
               .filter(x-> x.getFaculty().equals("EF"))
               .collect(Collectors.toList());
    }
    private List<Student> findSurnames (){
        return studentGateway.getStudents().stream()
                .filter(x->Objects.equals(x.getSurname(), "Ivanova") || Objects.equals(x.getSurname(), "Ivanov"))
                .collect(Collectors.toList());

    }
    private List<Student> findByAge(){
        return studentGateway.getStudents().stream()
                .sorted(Comparator.comparing(Student::getBirthday)).toList();

    }
    private List<Student> findByGpa (){
        return studentGateway.getStudents().stream()
                .filter(x->x.getGpa()>6)
                .collect(Collectors.toList());

    }
    private List<Student> findByBudgetFISE (){
        return studentGateway.getStudents().stream()
                .filter(x-> Objects.equals(x.getFaculty(), "FISE") && Objects.equals(x.getType(), "budget"))
                .collect(Collectors.toList());
    }
    private List<Student> findBySurname (){
        return studentGateway.getStudents().stream()
                .filter(x->x.getSurname().endsWith("a"))
                .collect(Collectors.toList());
    }
}
