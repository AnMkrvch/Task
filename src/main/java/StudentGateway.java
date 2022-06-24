import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentGateway {
    private final  String filePath;
    public StudentGateway( String filePath) {
        this.filePath = filePath;
    }

    public List<Student> getStudents () {
        return readStudents().stream().map(this::createStudent).collect(Collectors.toList());
    }

    private ArrayList <String> readStudents(){
        ArrayList<String> listOfData = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream(filePath);
             BufferedReader bread = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            while ((str = bread.readLine()) != null){
                listOfData.add(str);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return listOfData;
    }
    private Student createStudent ( String str ) {

        String [] data = str.split(" ");

        Student student = new Student();
        student.setSurname(data[0]);
        student.setName(data[1]);
        student.setPatronymic(data[2]);

        student.setBirthday(Utils.getDate(data[3]));

        student.setFaculty(data[4]);
        student.setGpa(Double.parseDouble(data[5]));
        student.setType(data[6]);

        return student;
    }

}
