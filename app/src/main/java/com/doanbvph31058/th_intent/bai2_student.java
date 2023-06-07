package com.doanbvph31058.th_intent;

public class bai2_student {
    private String branch;
    private String name;
    private String addRess;


    public bai2_student(String branch,String name, String addRess ) {
        this.branch = branch;
        this.name = name;
        this.addRess = addRess;

    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddRess() {
        return addRess;
    }

    public void setAddRess(String addRess) {
        this.addRess = addRess;
    }
}
