package com.doanbvph31058.th_intent;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;

public class bai2_adapter extends BaseAdapter implements Filterable {

    private Context context;

    private ArrayList<bai2_student> list, listOld;


    public bai2_adapter(Context context, ArrayList<bai2_student> list) {
        this.context = context;
        this.listOld = list;
        this.list = list;
    }

    public bai2_adapter() {
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1 Tạo Layout và liên kết
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();// Tạo layOut
        convertView=inflater.inflate(R.layout.bai2_listview_item,parent,false);//Liên kết LayOut

        //2 Ánh xạ từng thành phần
        TextView tvbranch = convertView.findViewById(R.id.txt_name_school_item);

        TextView name = convertView.findViewById(R.id.txt_name_item);

        TextView addRess =convertView.findViewById(R.id.txt_addRess_item);

        Button btnDelete = convertView.findViewById(R.id.btn_delete_item);

        Button btnUpdate = convertView.findViewById(R.id.btn_update_item);

        //3 Điền dữ liệu


        tvbranch.setText(list.get(position).getBranch());
        name.setText("Họ và tên: "+list.get(position).getName());
        addRess.setText("Địa chỉ:"+list.get(position).getAddRess());

        if (list.size()>0){
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });
        }else{
            Toast.makeText(context, "Đã hết phần tử để  xóa", Toast.LENGTH_SHORT).show();
        }

        this.notifyDataSetChanged();

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String s = constraint.toString();
                if(s.isEmpty()){
                    list = listOld;
                }else{
                    ArrayList<bai2_student> listS = new ArrayList<>();
                    for(bai2_student st : listOld){
                            if(st.getName().toLowerCase().contains(s.toLowerCase())){
                                listS.add(st);
;                            }
                    }
                    list = listS;

                }
                 FilterResults filterResults = new FilterResults();
                filterResults.values= list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                   list = (ArrayList<bai2_student>) results.values;
                   notifyDataSetChanged();
            }
        };
    }
}
