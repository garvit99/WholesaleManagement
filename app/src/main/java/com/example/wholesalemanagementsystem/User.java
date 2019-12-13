package com.example.wholesalemanagementsystem;

public class User {


    public String retailer;
    public String shop;
    public String certification;
    public String city;
    public String phone;
    public String alternate;
    public String email;
    public String address;
    public String aadhar;
    public String pan;
    public String password;

    public User(String retailer, String shop, String certification, String city, String phone, String alternate, String email, String address, String aadhar, String pan, String password) {
        this.retailer = retailer;
        this.shop = shop;
        this.certification = certification;
        this.city = city;
        this.phone = phone;
        this.alternate = alternate;
        this.email = email;
        this.address = address;
        this.aadhar = aadhar;
        this.pan = pan;
        this.password = password;
    }

    public User() {
    }

    public String getRetailer()
    {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlternate() {
        return alternate;
    }

    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}