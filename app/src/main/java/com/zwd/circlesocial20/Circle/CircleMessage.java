package com.zwd.circlesocial20.Circle;

import com.loveplusplus.demo.image.MyBean;
import com.zwd.circlesocial20.Element.Circle_1Element;

import java.util.ArrayList;

/**
 * Created by asus-pc on 2017/1/21.
 */

public class CircleMessage {
    public int code;
    public String msg;

    public ArrayList<Circle_1Element> list;

    @Override
    public String toString() {
        return "MyMessage [code=" + code + ", msg=" + msg + ", list=" + list + "]";
    }


}
