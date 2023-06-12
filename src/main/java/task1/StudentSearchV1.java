package task1;
import java.util.Scanner;

public class StudentSearchV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read from .csv file provided in root folder
        Student[] unsortedStudents = FileUtils.readFile("Global_University_Students.csv");

        // Sort the data in .csv file using mergesort we created
        MergeSort.sort(unsortedStudents);

        // Store students from previous steps to the new .csv file where students are listed ASC by their index
        FileUtils.writeToFile(unsortedStudents, "Sorted_Global_Univesity_Students.csv");

        String continueSearch;
        do {
            System.out.println("Enter a student ID to search:");
            int id = scanner.nextInt();

            int index = BinarySearch.search(unsortedStudents, id);

            if (index != -1) {
                Student student = unsortedStudents[index];
                System.out.println("Student Found:");
                System.out.println("Student ID: " + student.getStudentID());
                System.out.println("Full Name: " + student.getFullName());
                System.out.println("Date of Birth: " + student.getDateOfBirth());
                System.out.println("University Name: " + student.getUniversityName());
                System.out.println("Department Code: " + student.getDepartmentCode());
                System.out.println("Department Name: " + student.getDepartmentName());
                System.out.println("Year of Enrollment: " + student.getYearOfEnrollment());
                System.out.println("Number of Steps: " + BinarySearch.numSteps);
            } else {
                System.out.println("Student Not Found");
                System.out.println("Number of Steps: " + BinarySearch.numSteps);
            }
            // Ask user if he wants to search for another student
            System.out.println("Do you want to search for another student? (y/n)");
            continueSearch = scanner.next();
        } while (continueSearch.equalsIgnoreCase("y"));

        scanner.close();
    }
}
