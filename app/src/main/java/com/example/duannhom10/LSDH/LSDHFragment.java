package com.example.duannhom10.LSDH;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duannhom10.R;
import com.example.duannhom10.model.Order;
import com.example.duannhom10.ui.DBHelper;

import java.util.Collections;
import java.util.List;

public class LSDHFragment extends Fragment {
    private RecyclerView recyclerView;
    private LSDHAdapter adapter;
    private List<Order> orderList;
    private DBHelper dbHelper;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_l_s_d_h, container, false);


        recyclerView = view.findViewById(R.id.fragmentLSDH);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Đảm bảo DBHelper chỉ được khởi tạo nếu getActivity() != null
        if (getActivity() != null) {
            dbHelper = new DBHelper(getActivity());
        } else {
            Log.e("LSDHFragment", "getActivity() is null. Cannot initialize DBHelper.");
            return view;  // Trả về view nếu không thể khởi tạo DBHelper
        }



        // Tải danh sách đơn hàng
        loadAllOrders();

        // Thiết lập adapter nếu có dữ liệu
        if (orderList != null && !orderList.isEmpty()) {
            adapter = new LSDHAdapter(getActivity(), orderList);
            recyclerView.setAdapter(adapter);
        } else {
            // Hiển thị thông báo khi không có dữ liệu
            Log.d("LSDHFragment", "Không có đơn hàng nào.");
            Toast.makeText(getActivity(), "Không có đơn hàng nào", Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private void loadAllOrders() {
        if (dbHelper != null) {
            // Lấy danh sách đơn hàng từ DB
            orderList = dbHelper.getAllOrders();
            Log.d("LSDHFragment", "Số lượng đơn hàng: " + (orderList != null ? orderList.size() : 0));

            if (orderList != null && !orderList.isEmpty()) {
                // Sắp xếp đơn hàng theo ngày (nếu cần)
                // Collections.sort(orderList, (o1, o2) -> o2.getDate().compareTo(o1.getDate()));
                Log.d("LSDHFragment", "Đã tải danh sách đơn hàng.");
            } else {
                Log.d("LSDHFragment", "Không có đơn hàng.");
            }
        } else {
            Log.e("LSDHFragment", "DBHelper chưa được khởi tạo.");
        }
    }
}
