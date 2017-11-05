package com.zwd.circlesocial20.Element;

/**
 * Created by asus-pc on 2017/2/10.
 */

public class ChooseElement {
    private int resourceId;
    private String title;
    private String text;
    private float mark;

    public ChooseElement(int resourceId, String title, String text, float mark) {
        this.resourceId = resourceId;
        this.title = title;
        this.text = text;
        this.mark = mark;
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

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
