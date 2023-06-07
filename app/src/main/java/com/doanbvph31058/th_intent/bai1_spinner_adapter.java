package com.doanbvph31058.th_intent;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class bai1_spinner_adapter extends BaseAdapter {

    private Context context;
    private ArrayList<bai1_School_model> listSchool;

    public bai1_spinner_adapter(Context context, ArrayList<bai1_School_model> listSchool) {
        this.context = context;
        this.listSchool = listSchool;
    }


    @Override
    public int getCount() {
        return listSchool.size();
    }

    @Override
    public Object getItem(int position) {
        return listSchool.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    //1.Khởi tạo và liên kết layout


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1.Khởi tạo và liên kết layout
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();// khởi tạo

        convertView = inflater.inflate(R.layout.bai1_spiner_item,parent,false); // liên kết layout

        //2.Ánh xạ từng thành phần trên layout
        ImageView imgLogo = convertView.findViewById(R.id.img_Item);
        TextView tvName  = convertView.findViewById(R.id.tv_name_Item);

        ////3.Điền dữ liệu
        imgLogo.setImageResource(listSchool.get(position).getImg());
        tvName.setText("FpoLy"+listSchool.get(position).getName());

        return convertView;
    }
}
