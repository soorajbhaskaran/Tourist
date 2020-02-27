package com.example.tourist;

public class CustomerReview {
    private String customerName, customerEmail, customerReviewTxt, reviewDate;

    public CustomerReview(String customerName, String customerEmail, String customerReviewTxt, String reviewDate){
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerReviewTxt = customerReviewTxt;
        this.reviewDate = reviewDate;
    }
    public CustomerReview(){}

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerReviewTxt() {
        return customerReviewTxt;
    }

    public void setCustomerReviewTxt(String customerReviewTxt) {
        this.customerReviewTxt = customerReviewTxt;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }
}
