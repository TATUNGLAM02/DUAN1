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
import java.util.ArrayList;
import java.util.List;

public class LSDHAdapter extends RecyclerView.Adapter<LSDHAdapter.ViewHolder> {
    private Context context;
    private List<Order> orders;

    public LSDHAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = (orders != null) ? orders : new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_lsdh_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);

        holder.orderID.setText(String.valueOf(order.getOrderId()));
        holder.orderDate.setText(order.getDate());
        holder.orderTotal.setText(new DecimalFormat("###,###,###").format(order.getTotal()) + " Đ");
        holder.orderAddress.setText(order.getAddress());
        holder.orderStatus.setText(order.getStatus());
        holder.orderName.setText(order.getName());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void setOrders(List<Order> newOrders) {
        if (newOrders != null) {
            orders.clear();
            orders.addAll(newOrders);
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderID, orderDate, orderTotal, orderAddress, orderStatus, orderName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderID = itemView.findViewById(R.id.orderID);
            orderDate = itemView.findViewById(R.id.orderDATE);
            orderTotal = itemView.findViewById(R.id.orderTOTAL);
            orderAddress = itemView.findViewById(R.id.orderADDRESS);
            orderStatus = itemView.findViewById(R.id.orderSTATUS);
            orderName = itemView.findViewById(R.id.orderNAME);
        }
    }
}
