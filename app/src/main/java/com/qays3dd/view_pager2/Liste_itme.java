package com.qays3dd.view_pager2;

/**
 * Created by Salim3DD on 7/24/2016.
 */
public class Liste_itme {

    private String name;
    private int bird_id;

    public Liste_itme(String name, int bird_id) {
        this.name = name;
        this.bird_id = bird_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBird_id() {
        return bird_id;
    }

    public void setBird_id(int bird_id) {
        this.bird_id = bird_id;
    }
}
