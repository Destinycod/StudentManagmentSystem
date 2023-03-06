package entities;

import java.util.*;

public class Teacher {
    private String name;
    private String lastName;
    private Long nid;
    private String password;

    private List<Qualification> qualifications;

    public Teacher(){
        this.qualifications = new ArrayList<>();
    }

    public Teacher(Long nid){
        this();
        this.nid = nid;
    }

    public Teacher(String name, String lastName){
        this();
        this.name = name;
        this.lastName = lastName;
    }

    public Teacher(Long nid, String name, String lastName){
        this();
        this.name = name;
        this.lastName = lastName;
        this.nid = nid;
    }

    public Teacher(String name, String lastName, Long nid, String password){
        this();
        this.name = name;
        this.lastName = lastName;
        this.nid = nid;
        this.password = password;
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

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nid=" + nid +
                ", password='" + password + '\'' +
                ", qualifications=" + qualifications +
                '}';
    }
}
