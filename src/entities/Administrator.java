package entities;

public class Administrator {
    private String name;
    private String lastName;
    private Long nid;
    private String password;

    public Administrator(){

    }

    public Administrator(String name, String lastName, Long nid, String password){
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
}
