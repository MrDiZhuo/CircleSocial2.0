package com.zwd.circlesocial20.Party;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.zwd.circlesocial20.Base.BaseActivity;
import com.zwd.circlesocial20.Base.BasePopupWindow;
import com.zwd.circlesocial20.R;
import com.zwd.circlesocial20.widget.BackActionBar;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Timer;

import butterknife.Bind;
import butterknife.OnClick;

import static android.support.design.R.id.image;
import static com.zwd.circlesocial20.util.dip2pxUtils.dip2px;

public class NewParty extends BaseActivity {
    @Bind(R.id.new_party_actionbar)
    BackActionBar actionBar;
    @Bind(R.id.new_party_name)
    EditText name;
    @Bind(R.id.new_party_theme)
    RelativeLayout theme;
    @Bind(R.id.new_party_varity)
    RelativeLayout varity;
    @Bind(R.id.new_party_time)
    RelativeLayout time;
    @Bind(R.id.new_party_num1)
    EditText num1;
    @Bind(R.id.new_party_num2)
    EditText num2;
    @Bind(R.id.new_party_money)
    EditText money;
    @Bind(R.id.new_party_photo)
    ImageView party_photo;
    @Bind(R.id.new_party_intro)
    EditText intro;
    @Bind(R.id.new_party_location)
    RelativeLayout location;
    @Bind(R.id.new_party_location_text)
    TextView location_text;
    @Bind(R.id.new_party_bid)
    Button bid;
    @Bind(R.id.new_party_choose)
    Button choose;
    @Bind(R.id.new_party_yes)
    Button yes;
    @Bind(R.id.new_party_theme_text)
    TextView theme_text;
    @Bind(R.id.new_party_varity_text)
    TextView varity_text;
    @Bind(R.id.new_party_time_text)
    TextView time_text;
    @Bind(R.id.new_party_picture)
    RelativeLayout picture;

    private ArrayList<String> options1Items_1;
    private ArrayList<String> options1Items_2;
    private OptionsPickerView pvOptions_1;
    private OptionsPickerView pvOptions_2;
    private TimePickerView pvTime;
    private View vMasker;

    private BasePopupWindow mPopupWindow;
    private View popupwindow;

    private static final int TAKE_PHOTO=1;
    //调用系统相册-选择图片
    private static final int IMAGE = 2;
    private Uri imageUri;


    protected int getContentView(){
        return R.layout.activity_new_party;
    }

    protected void initViews() {
        initActionBar(actionBar);
        popupwindow = getLayoutInflater().inflate(R.layout.item_party_newparty,null);
        TextView camera = (TextView)popupwindow.findViewById(R.id.item_party_newparty_camera) ;
        TextView photo = (TextView)popupwindow.findViewById(R.id.item_party_newparty_photo);
        TextView cancle = (TextView)popupwindow.findViewById(R.id.item_party_newparty_cancle);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), TAKE_PHOTO);
                mPopupWindow.dismiss();
            }
        });
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //调用相册
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE);

                mPopupWindow.dismiss();

            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();

            }
        });

        mPopupWindow = new BasePopupWindow(mContext);
        mPopupWindow.setAnimationStyle(R.style.newparty_anim_style);
        mPopupWindow.setContentView(popupwindow);
        mPopupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        /**
         * 滚轮
         */
        pvTime = new TimePickerView(this, TimePickerView.Type.ALL);
//控制时间范围
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
//时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                time_text.setText(getTime(date));
            }
        });

        //选项选择器
        pvOptions_1 = new OptionsPickerView(this);
        options1Items_1 = new ArrayList<String>();
        options1Items_1.add("游戏");
        options1Items_1.add("骑行");
        options1Items_1.add("登山");
        options1Items_1.add("聚餐");
        options1Items_1.add("秋游");
        pvOptions_1.setPicker(options1Items_1);
        pvOptions_1.setCyclic(false);
        pvOptions_1.setCancelable(true);
        pvOptions_1.setSelectOptions(1);
        pvOptions_1.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
//返回的分别是三个级别的选中位置
                String tx = options1Items_1.get(options1);
                theme_text.setText(tx);
            }
        });

        pvOptions_2 = new OptionsPickerView(this);
        options1Items_2 = new ArrayList<String>();
        options1Items_2.add("游戏");
        options1Items_2.add("骑行");
        options1Items_2.add("登山");
        options1Items_2.add("聚餐");
        options1Items_2.add("秋游");
        pvOptions_2.setPicker(options1Items_1);
        pvOptions_2.setCyclic(false);
        pvOptions_2.setCancelable(true);
        pvOptions_2.setSelectOptions(1);
        pvOptions_2.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
//返回的分别是三个级别的选中位置
                String tx = options1Items_2.get(options1);
                varity_text.setText(tx);
            }
        });
    }


        //加载图片
        private void showImage(String imaePath){
            Bitmap bm = BitmapFactory.decodeFile(imaePath);
            party_photo.setImageBitmap(bm);
        }



    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        switch (requestCode){
            case 0:
                if(resultCode ==0) {
                    Bundle data = intent.getExtras();
                    String resultCity = data.getString("city");
                    location_text.setText(resultCity);
                }
                    break;
            case 1:
                if (resultCode == RESULT_OK) {
                    Bitmap bm = (Bitmap) intent.getExtras().get("data");
                    party_photo.setImageBitmap(bm);//想图像显示在ImageView视图上，private ImageView img;
                    File myCaptureFile = new File("sdcard/123456.jpg");
                    try {
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
                    /* 采用压缩转档方法 */
                        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
                    /* 调用flush()方法，更新BufferStream */
                        bos.flush();
                    /* 结束OutputStream */
                        bos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                if(resultCode == Activity.RESULT_OK && intent != null){
                    Uri selectedImage = intent.getData();
                    String[] filePathColumns = {MediaStore.Images.Media.DATA};
                    Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
                    c.moveToFirst();
                    int columnIndex = c.getColumnIndex(filePathColumns[0]);
                    String imagePath = c.getString(columnIndex);
                    showImage(imagePath);
                    c.close();
                }
                break;
            case 3:
                break;

        }
    }

    private String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //如果里面需要小时和分钟就带上HH：mm不需要就不用写
        return format.format(date);
    }


    @OnClick({R.id.new_party_theme,R.id.new_party_varity,R.id.new_party_time,R.id.new_party_location,R.id.new_party_picture
    ,R.id.new_party_choose})
    public void click(View v){
        switch (v.getId()){
            case R.id.new_party_theme:
                pvOptions_1.show();
                break;
            case R.id.new_party_varity:
                pvOptions_2.show();
                break;
            case R.id.new_party_time:
                pvTime.show();
                break;
            case R.id.new_party_location:
                goActivityForResult(MyParty_area.class,0);
                break;
            case R.id.new_party_picture:
                mPopupWindow.showAtLocation(yes,Gravity.BOTTOM,0,0);
                break;
            case R.id.new_party_choose:
                goActivity(Choose.class);
                break;

        }
    }




    private void initActionBar(BackActionBar actionBar) {
        actionBar.hidesubTitle();
        actionBar.hideCustomButton();
        actionBar.setTitle("创建聚会");
        actionBar.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }





    /**
     *键盘返回
     */
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return true;
    }



    /**
     * 点击键盘以外的区域隐藏键盘
     * @param ev
     * @return
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){
        if(ev.getAction() ==MotionEvent.ACTION_DOWN){
            View v =getCurrentFocus();
            if(isShoudHideKeyBoard(v,ev)){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm!=null){
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        if(getWindow().superDispatchTouchEvent(ev)){
            return true;
        }
        return onTouchEvent(ev);
    }
    private boolean isShoudHideKeyBoard(View v, MotionEvent event) {
        if(v!=null&&(v instanceof EditText)){
            int[] l = {0,0};
            v.getLocationInWindow(l);
            int left = l[0], top =l[1],bottom = top+v.getHeight(),right=left+v.getWidth();
            if(event.getX()>left && event.getX()<right &&event.getY()<bottom && event.getY()>top){
                return false;
            }else {
                return true;
            }
        }
        return false;

    }

}
