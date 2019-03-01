package com.example.mar.map;

public class Hospital {
    int id;
    String name;
    int locationX;
    int locationY;
    int phoneNum;
    String password;
    String category;


    public Hospital() {
    }

    public Hospital(int id) {
        this.id = id;
    }

    public Hospital(int id, String name, int locationX, int locationY, int phoneNum, String[] department, String password , String category) {
        this.id = id;
        this.name = name;
        this.locationX = locationX;
        this.locationY = locationY;
        this.phoneNum = phoneNum;
        this.password = password;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLocationX() {
        return locationX;
    }
    public int getLocationY() {
        return locationY;
    }


    public int getPhoneNum() {
        return phoneNum;
    }





    public String getPassword() {
        return password;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void logIn(int id, String password) {

    }

    public void logOut(int id) {

    }

    public void modifyHospitalEmail( String email) {

    }

    public void modifyHospitalPassword( String password) {

    }
}

