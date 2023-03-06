package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Course {
    private Long id;
    private String name;
    private double price;
    private int midtermsRequired;
    private LocalDate startDate;
    private Date endDate;
    private int quota;
    private boolean approved;

    //private List<Enrollment> enrollments;
    private List<Long> enrollments;
    private List<Qualification> qualifications;

    public Course (){
        this.enrollments = new ArrayList<>();
        this.qualifications = new ArrayList<>();
    }

    public Course(Long id, String name){
        this();
        this.name = name;
        this.id = id;
    }

    public Course(Long id, String name, double price){
        this();
        this.name = name;
        this.id = id;
        this.price = price;
    }
//TODO
    public Course (Long id, String name, double price, int midtermsRequired, LocalDate startDate, Date endDate, int quota){
        this();
        this.name = name;
        this.id = id;
        this.price = price;
        this.midtermsRequired = midtermsRequired;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quota = quota;
    }

    public Course (Long id, String name, double price, int midtermsRequired, LocalDate startDate, Date endDate, int quota, boolean approved){
        this();
        this.name = name;
        this.id = id;
        this.price = price;
        this.midtermsRequired = midtermsRequired;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quota = quota;
        this.approved = approved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMidtermsRequired() {
        return midtermsRequired;
    }

    public void setMidtermsRequired(int midtermsRequired) {
        this.midtermsRequired = midtermsRequired;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
/*
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
*/
    public List<Long> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Long> enrollments) {
        this.enrollments = enrollments;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", midtermsRequired=" + midtermsRequired +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", quota=" + quota +
                ", approved=" + approved +
                ", enrollments=" + enrollments +
                ", qualifications=" + qualifications +
                '}';
    }
}
