package com.seme.org;

import java.io.Serializable;

public class Skill implements Serializable {

    private String skill;
    private String rating;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
