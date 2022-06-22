import java.io.File;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("src\\students.txt");
        StudentService studentService = new StudentService(file);

        StudentController studentController = new StudentController(studentService);
        studentController.printStudents();

    }
}
