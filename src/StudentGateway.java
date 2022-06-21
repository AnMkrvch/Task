import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentGateway {

    private final File file;

    public StudentGateway(File file) {
        this.file = file;
    }

    private ArrayList <String> readStudents(){
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

    public List<Student> getStudents () {
        return readStudents().stream().map(this::createStudent).collect(Collectors.toList());
    }

   private Student createStudent ( String str ) {

        String [] data = str.split(" ");

        Student student = new Student();
        student.setSurname(data[0]);
        student.setName(data[1]);
        student.setPatronymic(data[2]);

        student.setBirthday(Utils.getDate(data[3]));

        student.setFaculty(data[4]);
        student.setGPA(Double.parseDouble(data[5]));
        student.setType(data[6]);

        return student;
    }

}
