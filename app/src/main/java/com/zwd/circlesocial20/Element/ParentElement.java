package com.zwd.circlesocial20.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus-pc on 2016/12/10.
 */

public class ParentElement {
    private String title;
    private int online;
    private int all;
    private List<ChildElement> childList = new ArrayList<ChildElement>();

    public ChildElement getChildElement(int childPosition){
        return childList.get(childPosition);
    }

    public void putChildElement(ChildElement childElement){
        childList.add(childElement);
    }

    public int getChildSize(){
        return childList.size();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public List<ChildElement> getChildList() {
        return childList;
    }

    public void setChildList(List<ChildElement> childList) {
        this.childList = childList;
    }
}
