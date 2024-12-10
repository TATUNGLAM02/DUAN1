package com.example.duannhom10.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duannhom10.R;
import com.example.duannhom10.model.Product;
import com.example.duannhom10.ui.Ultils;

import java.text.DecimalFormat;
import java.util.ArrayList;



<<<<<<< HEAD
=======

>>>>>>> 5fc002c472a9b4cb5f126ad5dfa85d4ab4d14417
public class Yeuthichadapter extends BaseAdapter {
    Context context;
    ArrayList<Product> arrayListgiohang;
    ViewHolder viewHolder=null;
    public Yeuthichadapter(Context context, ArrayList<Product> arrayListgiohang) {
        this.context = context;
        this.arrayListgiohang = arrayListgiohang;
    }
    @Override
    public int getCount() {
        return arrayListgiohang.size();
    }
    @Override
    public Object getItem(int i) {
        return arrayListgiohang.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    public static class ViewHolder{
        public TextView txttengiohang,txtgiagiohang;
        public ImageView imggiohang;
        public Button btngiam,btngiatri,btntang;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.dong_sanpham_yeuthich,null);
            viewHolder.txttengiohang=(TextView) view.findViewById(R.id.textviewtengiohang1);
            viewHolder.txtgiagiohang=(TextView) view.findViewById(R.id.textviewgiagiohang1);
            viewHolder.imggiohang=(ImageView) view.findViewById(R.id.imgviewgiohang1);
            view.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) view.getTag();
        }
        Product gioHang=(Product) getItem(i);
        viewHolder.txttengiohang.setText(gioHang.getProName());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText("Giá "+decimalFormat.format(gioHang.getProPrice())+" Đ");
        viewHolder.imggiohang.setImageBitmap(Ultils.convertToBitmapFromAssets(context,gioHang.getProImage()));

        return view;
    }


}
