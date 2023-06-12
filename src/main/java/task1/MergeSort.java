package task1;

import java.util.Comparator;

public class MergeSort {
    public static void sort(Student[] students) {
        if (students.length <= 1) { // when there is only 1 or 0 student left return
            return;
        }
        // Calculate the middle index of an array
        int mid = students.length / 2;

        // Create new arrays to hold the left and right halves of the original array
        Student[] left = new Student[mid];
        Student[] right = new Student[students.length - mid];

        // Copy the elements from the original array to the left and right arrays
        System.arraycopy(students, 0, left, 0, mid);
        System.arraycopy(students, mid, right, 0, students.length - mid);

        // Recursively sort the left and right arrays
        sort(left);
        sort(right);

        // Merge the sorted left and right arrays back into the original array
        merge(students, left, right);
    }

    private static void merge(Student[] students, Student[] left, Student[] right) {
        // Initialize the indices for the left, right, and merged arrays
        int i = 0, j = 0, k = 0;

        // Merge the elements from the left and right arrays into the merged array
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                students[k] = left[i];
                i++;
            } else {
                students[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left array to the merged array
        while (i < left.length) {
            students[k] = left[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right array to the merged array
        while (j < right.length) {
            students[k] = right[j];
            j++;
            k++;
        }
    }
}
