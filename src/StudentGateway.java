import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentGateway {
    ArrayList <String> readStudents(File file){
        ArrayList<String> listOfData = new ArrayList<>();
        try (FileReader read = new FileReader(file);
            BufferedReader bread = new BufferedReader(read)) {
            String str;
            while ((str = bread.readLine()) != null){
                listOfData.add(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfData;
    }

    List<Student> getStudents (ArrayList<String> listOfData) {
        return listOfData.stream().map(e -> createStudent(e)).collect(Collectors.toList());
    }

    Student createStudent ( String str ) {

        String [] data = str.split(" ");

        Student student = new Student();
        student.setSurname(data[0]);
        student.setName(data[1]);
        student.setPatronymic(data[2]);
        try {
            student.setBirthday(new SimpleDateFormat("dd.MM.yyyy").parse(data[3]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        student.setFaculty(data[4]);
        student.setGPA(Double.parseDouble(data[5]));
        student.setType(data[6]);

        return student;
    }

}
