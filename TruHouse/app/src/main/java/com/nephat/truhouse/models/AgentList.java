package com.nephat.truhouse.models;

public class AgentList {

    private final String id;
    private final String reg_no;
    private final String name;
    private final String address;
    private final String qualification;
    private final String phone;
    private final String email;
    private final String locality;

    public AgentList(String id, String reg_no, String name, String address, String qualification, String phone, String email, String locality) {
        this.id = id;
        this.reg_no = reg_no;
        this.name = name;
        this.address = address;
        this.qualification = qualification;
        this.phone = phone;
        this.email = email;
        this.locality = locality;
    }

    public String getId() {
        return id;
    }

    public String getReg_no() {
        return reg_no;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getQualification() {
        return qualification;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLocality() {
        return locality;
    }
}
