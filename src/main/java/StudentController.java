import java.io.File;
import java.util.List;
import java.util.Scanner;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void printStudents(){

        System.out.println(" student service " +
                "\n 1 - students of ef" +
                "\n 2 - student's surnames " +
                "\n 3 - students sorted by age" +
                "\n 4 - students with GPA > 6 " +
                "\n 5 - students of FISE and budget type of education " +
                "\n 6 - students with surname ...-a " +
                "\n enter number (1-6) : ");

        Scanner in = new Scanner(System.in);
        int k = in.nextInt();

        studentService.makeList(k).forEach(x -> System.out.println(x.getSurname() + " " + x.getName()));

    }
}

