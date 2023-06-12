package task1;

public class Student implements Comparable<Student> {
    private int id;
    private String fullName;
    private String dob;
    private String universityName;
    private String departmentCode;
    private String departmentName;
    private int yearOfEnrollment;

    public Student(int id, String fullName, String dob, String universityName, String departmentCode, String departmentName, int yearOfEnrollment) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.universityName = universityName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public int getStudentID() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dob;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
}
