package com.zwd.circlesocial20.Element;

/**
 * Created by asus-pc on 2016/12/11.
 */

public class PartyElement {
    private int resourceId;
    private String title;
    private String text;
    private float money;
    private String avery;

    public PartyElement(int resourceId, String title, String text, float money, String avery) {
        this.resourceId = resourceId;
        this.title = title;
        this.text = text;
        this.money = money;
        this.avery = avery;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getAvery() {
        return avery;
    }

    public void setAvery(String avery) {
        this.avery = avery;
    }
}
