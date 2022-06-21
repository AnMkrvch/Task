import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("D:\\Angelina\\Documents\\IDEA\\Task\\src\\students.txt");
        StudentGateway st = new StudentGateway();
        List<Student> students = st.getStudents(st.readStudents(file));

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

        StudentService stFilter = new StudentService();

        switch(k){
            case 1:
                stFilter.printFacultyEF(students);
                break;
            case 2:
                System.out.println(stFilter.findSurname(students));
                break;
            case 3:
                stFilter.sortByAge(students);
                break;
            case 4:
                stFilter.filterByGPA(students);
                break;
            case 5:
                stFilter.printBudgetFISE(students);
                break;
            case 6:
                stFilter.filterBySurname(students);
                break;
            default:
                System.out.println("incorrect value");
        }

//        stFilter.printFacultyEF(students);
//        System.out.println(stFilter.findSurname(students));
//        stFilter.sortByAge(students);
//        stFilter.filterByGPA(students);
//        stFilter.printBudgetFISE(students);
//        stFilter.filterBySurname(students);

    }
}
