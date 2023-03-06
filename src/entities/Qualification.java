package entities;

import java.util.HashSet;
import java.util.Set;
//TODO CHECK
public class Qualification {

    private Long id;
    private int qualification;
    private Course course;
    private Student student;
    private Teacher teacher;
    private Long teacher_id;
    private Long course_id;
    private Long student_id;

    private Set<QualificationType> qualificationTypes;

    public Qualification(){
        this.qualificationTypes = new HashSet<>();
    }

    public Qualification(Long id, int qualification) {
        this();
        this.id = id;
        this.qualification = qualification;
    }

    public Qualification(Long id, int qualification, Teacher teacher, Course course, Student student) {
        this();
        this.id = id;
        this.qualification = qualification;
        this.course = course;
        this.teacher = teacher;
        this.student = student;
    }

    public Qualification(Long id, int qualification, Long teacher_id, Long course_id, Long student_id) {
        this();
        this.id = id;
        this.qualification = qualification;
        this.course_id = course_id;
        this.teacher_id = teacher_id;
        this.student_id = student_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public Set<QualificationType> getQualificationTypes() {
        return qualificationTypes;
    }

    public void setQualificationTypes(Set<QualificationType> qualificationTypes) {
        this.qualificationTypes = qualificationTypes;
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

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
//TODO CHECK
    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
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
        return "Qualification{" +
                "id=" + id +
                ", qualification=" + qualification +
                ", qualificationTypes=" + qualificationTypes +
                ", course=" + course +
                ", teacher=" + teacher +
                ", student=" + student +
                ", course_id=" + course_id +
                ", teacher_id=" + teacher_id +
                ", student_id=" + student_id +
                '}';
    }
}
