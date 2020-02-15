package com.example.tourist;

import java.util.ArrayList;
import java.util.List;

public class ServProvider {
    private String name;
    private String email;
    private String aadharNo;
    private String phone;
    private String address;
    private String uniqueID;
    private String regProofLink;
    private String serviceType;
    private List<ProvidedServices> servicesList;

    public ServProvider(String name, String email, String aadharNo, String phone, String address,
                        String uniqueID, String regProofLink, String serviceType){
        this.name = name;
        this.email = email;
        this.aadharNo = aadharNo;
        this.phone = phone;
        this.address = address;
        this.uniqueID = uniqueID;

        this.regProofLink = regProofLink;
        this.serviceType = serviceType;
    }
    public ServProvider(String name, String email){
        this.name = name;
        this.email = email;
    }
    public ServProvider(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadharNo() {
        return aadharNo==null?"":aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getRegProofLink() {
        return regProofLink;
    }

    public void setRegProofLink(String regProofLink) {
        this.regProofLink = regProofLink;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public List<ProvidedServices> getServicesList() {
        return servicesList==null?new ArrayList<ProvidedServices>():servicesList;
    }

    public void setServicesList(List<ProvidedServices> servicesList) {
        this.servicesList = servicesList;
    }
}
