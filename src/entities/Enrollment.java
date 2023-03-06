package entities;

public class Enrollment {

    private Long id;
    private Course course;
    private Student student;
    private Long course_id;
    private Long student_id;

    public Enrollment() {
    }

    public Enrollment(Long id) {
        this.id = id;
    }

    public Enrollment(Long id, Course course, Student student) {
        this.id = id;
        this.course = course;
        this.student = student;
    }

    public Enrollment(Long id, Long student_id, Long course_id) {
        this.id = id;
        this.course_id = course_id;
        this.student_id = student_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
