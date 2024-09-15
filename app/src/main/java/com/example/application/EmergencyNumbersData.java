package com.example.application;

import android.content.Intent;

public class EmergencyNumbersData
{
    private String text;
    private String no;
    private Integer icon;

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public EmergencyNumbersData(String text, String no,Integer i) {
        this.text = text;
        this.no = no;
        this.icon=i;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
