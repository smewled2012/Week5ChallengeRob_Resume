package com.seme.org;

import java.io.Serializable;
import java.util.ArrayList;

public class Experience implements Serializable {
    private  String company;
    private String title;
    private String startDate;
    private String endDate;
    private ArrayList<Duty> listDuty;

    public  Experience(){
        listDuty=new ArrayList<>();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Duty> getListDuty() {
        return listDuty;

    }

    public void setListDuty(ArrayList<Duty> listDuty) {
        this.listDuty = listDuty;
    }

    public void addDuties(Duty firstDuty){
        this.listDuty.add(firstDuty);
    }
}
