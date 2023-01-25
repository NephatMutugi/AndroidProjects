package com.nephat.truhouse.models;

import com.google.gson.annotations.SerializedName;

/**
 * This class handles response from the server*/
public class ApiResponse {

    //Receives status of the request
    @SerializedName("status")
    private final String status;

    @SerializedName("result_code")
    private final int resultCode;

    @SerializedName("name")
    private final String name;

    @SerializedName("id")
    private final String id;

    @SerializedName("reg_no")
    private final String reg_no;

    @SerializedName("email")
    private final String email;

    @SerializedName("average")
    private final String average;

    public ApiResponse(String status, int resultCode, String name, String id, String reg_no, String email, String average) {
        this.status = status;
        this.resultCode = resultCode;
        this.name = name;
        this.id = id;
        this.reg_no = reg_no;
        this.email = email;
        this.average = average;
    }

    public String getAverage() {
        return average;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getName() {
        return name;
    }

    public String getId(){
        return id;
    }

    public String getReg_no(){
        return reg_no;
    }
}
