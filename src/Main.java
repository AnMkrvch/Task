import java.io.File;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("src\\students.txt");

        StudentService stFilter = new StudentService(file);

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

        if (k==1){
            stFilter.printStudents(stFilter.findFacultyEF());
        } else if (k==2){
            System.out.println(stFilter.findSurname());
        } else if (k==3){
            stFilter.printStudents(stFilter.sortByAge());
        } else if (k==4){
            stFilter.printStudents(stFilter.filterByGPA());
        } else if (k==5){
            stFilter.printStudents(stFilter.printBudgetFISE()) ;
        } else if (k==6){
            stFilter.printStudents (stFilter.filterBySurname());
        } else{
            System.out.println("incorrect value");
        }

    }
}
