package org.concept.oops.compare;

public class Employee {
    private int eid;
    private String name;
    private String mobile;

    public Employee(int eid, String name, String mobile) {
        this.eid = eid;
        this.name = name;
        this.mobile = mobile;

    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
