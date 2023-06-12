package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static Student[] readFile(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String fullName = parts[1];
                String dob = parts[2];
                String universityName = parts[3];
                String departmentCode = parts[4];
                String departmentName = parts[5];
                int yearOfEnrollment = Integer.parseInt(parts[6]);

                Student student = new Student(id, fullName, dob, universityName, departmentCode, departmentName, yearOfEnrollment);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students.toArray(new Student[0]);
    }

    public static void writeToFile(Student[] students, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                String line = student.getStudentID() + ";" +
                        student.getFullName() + ";" +
                        student.getDateOfBirth() + ";" +
                        student.getUniversityName() + ";" +
                        student.getDepartmentCode() + ";" +
                        student.getDepartmentName() + ";" +
                        student.getYearOfEnrollment();

                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
