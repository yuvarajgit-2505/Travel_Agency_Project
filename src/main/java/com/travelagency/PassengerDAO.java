package com.travelagency;

public class PassengerDAO {
private String name;
private String mobNo;
private String emailid;
private String gender;
private String boarding_point;
private String destination_point;
private String bustype;
private int amount;
public  PassengerDAO(){}
   public PassengerDAO(String name,String mobNo,String gender,String emailid,
                       String boarding_point,String destination_point,String bustype,int amount){
    this.name=name;
    this.mobNo=mobNo;
    this.emailid=emailid;
    this.gender=gender;
       this.boarding_point=boarding_point;
       this.destination_point=destination_point;
       this.bustype=bustype;
       this.amount=amount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    public String getBoarding_point() {
        return boarding_point;
    }

    public void setBoarding_point(String boarding_point) {
        this.boarding_point = boarding_point;
    }

    public String getDestination_point() {
        return destination_point;
    }

    public void setDestination_point(String destination_point) {
        this.destination_point = destination_point;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(String bustype) {
        this.bustype = bustype;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}


