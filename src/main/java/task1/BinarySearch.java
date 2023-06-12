package task1;

public class BinarySearch {
    // track the number of iterations needed for a search to complete
    public static int numSteps = 0;

    public static int search(Student[] students, int key) {
        numSteps = 0;
        return binarySearch(students, key, 0, students.length - 1);
    }

    private static int binarySearch(Student[] students, int key, int low, int high) { // Low index is first(0) element and high is last element in array
        // Check if the search range is valid
        if (low <= high) {
            int mid = low + (high - low) / 2;  // find the middle index in the middle of the array
            numSteps++;  // Increment the step count

            if (students[mid].getStudentID() == key) {  // Check if the middle element is the key value we look for
                return mid;  // Key found, return the index with value we were looking for
            } else if (students[mid].getStudentID() < key) {  // Check if the key is greater than the middle element
                // Recursively search in the right half of the array for the value we were looking for and do all those steps before until we find it
                return binarySearch(students, key, mid + 1, high);
            } else {
                // Recursively search in the left half of the array same logic as above but we look for the element in the left side of the array when we found mid value
                return binarySearch(students, key, low, mid - 1);
            }
        }

        return -1;  // Key not found, return -1
    }
}
