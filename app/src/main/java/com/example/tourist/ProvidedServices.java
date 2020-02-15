package com.example.tourist;

public class ProvidedServices {
    private String serviceName, serviceDesc, servicenextUpTime, serviceNextDownTime;
    private String servicePayment;
    private boolean isAvailable;

    public ProvidedServices(String serviceName, String serviceDesc, boolean isAvailable,
                            String servicenextUpTime, String serviceNextDownTime, String servicePayment){
        this.serviceName = serviceName;
        this.serviceDesc = serviceDesc;
        this.isAvailable = isAvailable;
        this.servicenextUpTime = servicenextUpTime;
        this.serviceNextDownTime = serviceNextDownTime;
        this.servicePayment = servicePayment;
    }

    public ProvidedServices(){

    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getServicenextUpTime() {
        return servicenextUpTime;
    }

    public void setServicenextUpTime(String servicenextUpTime) {
        this.servicenextUpTime = servicenextUpTime;
    }

    public String getServiceNextDownTime() {
        return serviceNextDownTime;
    }

    public void setServiceNextDownTime(String serviceNextDownTime) {
        this.serviceNextDownTime = serviceNextDownTime;
    }

    public String getServicePayment() {
        return servicePayment;
    }

    public void setServicePayment(String servicePayment) {
        this.servicePayment = servicePayment;
    }
}
