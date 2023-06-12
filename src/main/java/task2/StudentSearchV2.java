package task2;

import task1.Student;

import java.util.Scanner;

public class StudentSearchV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read unsorted file into a red-black tree
        RedBlackTree<Integer, Student> studentTree = FileUtils.readFile("Global_University_Students.csv");

        // Print the number of red links in the tree
        int redLinksCount = studentTree.countRedLinks();
        System.out.println("Number of Red Links: " + redLinksCount);

        String continueSearch;
        do {
            System.out.println("Enter a student ID to search:");
            int id = scanner.nextInt();

            if (id == -1) {
                break;
            }

            // Perform search in the red-black tree
            Student student = studentTree.get(id);
            if (student != null) {
                System.out.println("Student Found:");
                System.out.println("Student ID: " + student.getStudentID());
                System.out.println("Full Name: " + student.getFullName());
                System.out.println("Date of Birth: " + student.getDateOfBirth());
                System.out.println("University Name: " + student.getUniversityName());
                System.out.println("Department Code: " + student.getDepartmentCode());
                System.out.println("Department Name: " + student.getDepartmentName());
                System.out.println("Year of Enrollment: " + student.getYearOfEnrollment());
                System.out.println("Number of Steps: " + studentTree.getNumSteps());
            } else {
                System.out.println("Student Not Found");
                System.out.println("Number of Steps: " + studentTree.getNumSteps());
            }
            // Ask user if he wants to search for another student
            System.out.println("Do you want to search for another student? (y/n)");
            continueSearch = scanner.next();
        } while (continueSearch.equalsIgnoreCase("y"));

        scanner.close();
    }
}
