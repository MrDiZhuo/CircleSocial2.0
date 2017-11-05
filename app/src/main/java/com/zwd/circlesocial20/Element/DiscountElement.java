package com.zwd.circlesocial20.Element;

/**
 * Created by asus-pc on 2016/12/17.
 */

public class DiscountElement {
    private int money;
    private String date;
    private String time;

    public DiscountElement(int money, String date, String time) {
        this.money = money;
        this.date = date;
        this.time = time;
    }

    public int getMoney() {
        return money;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
