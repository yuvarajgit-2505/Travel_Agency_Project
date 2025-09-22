package com.travelagency;

public class AdminDAO {
    private int AdminID;
    private String AdminName;

    public AdminDAO(int AdminID,String AdminName) {
        this.AdminID=AdminID;
        this.AdminName=AdminName;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        this.AdminID = adminID;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        this.AdminName=AdminName;
    }
}
