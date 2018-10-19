package com.seme.org;

import java.io.Serializable;

public class Duty implements Serializable {
    private String activity;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
