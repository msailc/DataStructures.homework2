package task2;

import task1.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static RedBlackTree<Integer, Student> readFile(String filePath) {
        RedBlackTree<Integer, Student> tree = new RedBlackTree<>();

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
                tree.put(id, student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tree;
    }

}
