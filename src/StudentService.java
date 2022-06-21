import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    void printFacultyEF(List<Student> listOfStudents){
       listOfStudents.stream()
               .filter(x-> x.getFaculty().equals("EF"))
               .forEach(l-> System.out.println(l.getSurname()+ " " +  l.getName() ));
    }
    List<String> findSurname (List<Student> listOfStudents){
        return listOfStudents.stream()
                .map(Student::getSurname)
                .collect(Collectors.toList());
    }
    void sortByAge(List<Student> listOfStudents){
        listOfStudents.stream()
                .sorted(Comparator.comparing(Student::getBirthday)).toList()
                .forEach(x-> System.out.println(x.getSurname() + " " + x.getName() ));

    }
    void filterByGPA (List<Student> listOfStudents){
        listOfStudents.stream()
                .filter(x->x.getGPA()>6)
                .forEach(l-> System.out.println(l.getSurname() + " " + l.getName()));

    }
    void printBudgetFISE (List<Student> listOfStudents){
        listOfStudents.stream().filter(x->x.getFaculty().equals("FISE")&&x.getType().equals("budget"))
                .forEach(l-> System.out.println(l.getSurname() + " " + l.getName()));
    }
    void filterBySurname (List<Student> listOfStudents){
        listOfStudents.stream()
                .filter(x->x.getSurname().endsWith("a"))
                .forEach(l-> System.out.println(l.getSurname()+ " "+ l.getName()));
    }

}
