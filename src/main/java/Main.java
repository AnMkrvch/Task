public class Main {
    public static void main(String[] args) {


        String filePath = "students.txt";
//        File file = new File("src\\main\\resources\\students.txt");
        StudentService studentService = new StudentService(filePath);

        StudentController studentController = new StudentController(studentService);
        studentController.printStudents();

    }
}
