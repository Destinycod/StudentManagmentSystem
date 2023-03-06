package entities;

import java.util.*;

public class Student{
    private String name;
    private String lastName;
    private Long nid;
    private String password;
    private int totalCourses;

    private List<Enrollment> enrollments;
    private List<Qualification> qualifications;

    public Student(){
        this.enrollments = new ArrayList<>();
        this.qualifications = new ArrayList<>();
    }
//TODO REFACTORIZAR, ELIMINAR ESTE METODO Y CAMBIAR EN DONDE SE LO USE
    public Student(Long nid, String name, String lastName){
        this();
        this.name = name;
        this.lastName = lastName;
        this.nid = nid;
    }

    public Student(Long nid, int totalCourses){
        this();
        this.nid = nid;
        this.totalCourses = totalCourses;
    }

    public Student(String name, String lastName, Long nid, String password){
        this();
        this.name = name;
        this.lastName = lastName;
        this.nid = nid;
        this.password = password;
    }

    public Student(String name, String lastName, Long nid, String password, int totalCourses){
        this();
        this.name = name;
        this.lastName = lastName;
        this.nid = nid;
        this.password = password;
        this.totalCourses = totalCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(int totalCourses) {
        this.totalCourses = totalCourses;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getName(), student.getName()) && Objects.equals(getLastName(), student.getLastName()) && getNid().equals(student.getNid()) && Objects.equals(getPassword(), student.getPassword()) && Objects.equals(getEnrollments(), student.getEnrollments()) && Objects.equals(getQualifications(), student.getQualifications());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getNid(), getPassword(), getEnrollments(), getQualifications());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nid=" + nid +
                ", password='" + password + '\'' +
                ", totalCourses=" + totalCourses +
                ", enrollments=" + enrollments +
                ", qualifications=" + qualifications +
                '}';
    }
}
