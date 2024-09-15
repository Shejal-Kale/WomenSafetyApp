package com.example.application;

import android.content.Intent;

public class FriendsData
{
    String ContactName;
    String ContactNo;
    private Integer icon;
    private Integer del;
    private Integer send;
    public FriendsData()
    {
    }

    public FriendsData(String contactName, String contactNo, Integer icon,Integer del,Integer send) {
        this.ContactName = contactName;
        this.ContactNo = contactNo;
        this.icon=icon;
        this.del=del;
        this.send=send;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        this.ContactName = contactName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        this.ContactNo = contactNo;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer icon) {
        this.del = del;
    }

    public Integer getSend() {
        return send;
    }

    public void setSend(Integer icon) {
        this.send = send;
    }
}
