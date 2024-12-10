package com.example.duannhom10.LSDH;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duannhom10.R;
import com.example.duannhom10.model.Order;

import java.text.DecimalFormat;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 5fc002c472a9b4cb5f126ad5dfa85d4ab4d14417
import java.util.List;

public class LSDHAdapter extends RecyclerView.Adapter<LSDHAdapter.ViewHolder> {
    private Context context;
    private List<Order> orders;

    public LSDHAdapter(Context context, List<Order> orders) {
        this.context = context;
<<<<<<< HEAD
        this.orders = orders;
    }
=======
        this.orders = (orders != null) ? orders : new ArrayList<>();
    }

>>>>>>> 5fc002c472a9b4cb5f126ad5dfa85d4ab4d14417
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_lsdh_item, parent, false);
        return new ViewHolder(view);
    }
<<<<<<< HEAD
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.orderID.setText(String.valueOf(order.getOrderId()));
        holder.orderDate.setText(order.getDate());
        // Định dạng số thành dạng tiền tệ
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        String formattedTotal = decimalFormat.format(order.getTotal()) + " Đ"; // Giả sử đơn vị tiền là Đồng
        holder.orderTotal.setText(formattedTotal);
        holder.orderAddress.setText(String.valueOf(order.getAddress()));
=======

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);

        holder.orderID.setText(String.valueOf(order.getOrderId()));
        holder.orderDate.setText(order.getDate());
        holder.orderTotal.setText(new DecimalFormat("###,###,###").format(order.getTotal()) + " Đ");
        holder.orderAddress.setText(order.getAddress());
        holder.orderStatus.setText(order.getStatus());
        holder.orderName.setText(order.getName());
>>>>>>> 5fc002c472a9b4cb5f126ad5dfa85d4ab4d14417
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

<<<<<<< HEAD
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderID, orderDate, orderTotal,orderAddress;
=======
    public void setOrders(List<Order> newOrders) {
        if (newOrders != null) {
            orders.clear();
            orders.addAll(newOrders);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderID, orderDate, orderTotal, orderAddress, orderStatus, orderName;
>>>>>>> 5fc002c472a9b4cb5f126ad5dfa85d4ab4d14417

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderID = itemView.findViewById(R.id.orderID);
            orderDate = itemView.findViewById(R.id.orderDATE);
            orderTotal = itemView.findViewById(R.id.orderTOTAL);
<<<<<<< HEAD
            orderAddress=itemView.findViewById(R.id.orderADDRESS);
        }
    }

=======
            orderAddress = itemView.findViewById(R.id.orderADDRESS);
            orderStatus = itemView.findViewById(R.id.orderSTATUS);
            orderName = itemView.findViewById(R.id.orderNAME);
        }
    }
>>>>>>> 5fc002c472a9b4cb5f126ad5dfa85d4ab4d14417
}
