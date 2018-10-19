package com.seme.org;

import java.util.ArrayList;

public class Person  {
    private String name;
    private String email;
    private String phone;
    private ArrayList<Education> listEducation;
    private ArrayList<Experience> listExperience;
    private ArrayList<Skill> listSkills;


    public Person() {
        listEducation=new ArrayList<>();

        listExperience= new ArrayList<>();
        listSkills= new ArrayList<>();
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Education> getListEducation() {
        return listEducation;
    }

    public void setListEducation(ArrayList<Education> listEducation) {
        this.listEducation = listEducation;
    }

    public ArrayList<Experience> getListExperience() {
        return listExperience;
    }
/*
    public void setListExperience(ArrayList<Experience> listExperience) {
        this.listExperience = listExperience;
    }*/

    public ArrayList<Skill> getListSkills() {
        return listSkills;
    }

    public void setListSkills(ArrayList<Skill> listSkills) {
        this.listSkills = listSkills;
    }

    public void addEducations(Education firstEducation) {
        this.listEducation.add(firstEducation);
    }

    public void addExperience(Experience firstExperience) {
        this.listExperience.add(firstExperience);
    }
    public void addSkill(Skill firstSkill){
        this.listSkills.add(firstSkill);
    }




}
