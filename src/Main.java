import java.io.File;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String filePath = "students.txt";
        StudentService studentService = new StudentService(filePath);

        StudentController studentController = new StudentController(studentService);
        studentController.printStudents();

    }
}
