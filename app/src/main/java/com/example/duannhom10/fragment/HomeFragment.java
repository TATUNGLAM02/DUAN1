package com.example.duannhom10.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.duannhom10.BannerAdapter;
import com.example.duannhom10.Product.ChiTietSanPhamActivity;
import com.example.duannhom10.Product.ProDataQuery;
import com.example.duannhom10.R;
import com.example.duannhom10.model.GioHang;
import com.example.duannhom10.model.Product;
import com.example.duannhom10.ui.DBHelper;
import com.example.duannhom10.ui.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    private RecyclerView rvListCode, rcvHotProducts;
    private ArrayList<Product> lstPro, hotProductList;
    private MainAdapter mainAdapter, hotProductAdapter;
    private EditText searchEditText;
    private Handler handler = new Handler();

    private ViewPager bannerViewPager;
    private BannerAdapter bannerAdapter;
    private CircleIndicator circleIndicator;
    private int currentPage = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvListCode = view.findViewById(R.id.rcv_Phone);
        rcvHotProducts = view.findViewById(R.id.rcv_hot_products);
        searchEditText = view.findViewById(R.id.search_text);
        bannerViewPager = view.findViewById(R.id.banner_viewpager);
        circleIndicator = view.findViewById(R.id.circleIndicator);

        // Load all products
        lstPro = ProDataQuery.getALL(getActivity());
        mainAdapter = new MainAdapter(getContext(), lstPro, this::openProductDetails);
        rvListCode.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvListCode.setAdapter(mainAdapter);

        // Load hot products
        hotProductList = new ArrayList<>();
        hotProductAdapter = new MainAdapter(getContext(), hotProductList, this::openProductDetails);
        rcvHotProducts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rcvHotProducts.setAdapter(hotProductAdapter);
        loadHotProducts();

        // Search functionality
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mainAdapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        // Banner setup
        setupBanner();

        return view;
    }

    private void openProductDetails(Product product) {
        Intent intent = new Intent(getContext(), ChiTietSanPhamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("thongtinsanpham", product);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void loadHotProducts() {
        DBHelper dbHelper = new DBHelper(getContext());
        hotProductList.clear();
        hotProductList.addAll(dbHelper.getHotProducts());
        hotProductAdapter.notifyDataSetChanged();
    }

    private void setupBanner() {
        List<Integer> listPhoto = new ArrayList<>();
        listPhoto.add(R.drawable.banner01);
        listPhoto.add(R.drawable.banner02);
        listPhoto.add(R.drawable.banner03);
        listPhoto.add(R.drawable.banner04);

        bannerAdapter = new BannerAdapter(getContext(), listPhoto);
        bannerViewPager.setAdapter(bannerAdapter);
        circleIndicator.setViewPager(bannerViewPager);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (bannerAdapter.getCount() != 0) {
                    currentPage = (currentPage + 1) % bannerAdapter.getCount();
                    bannerViewPager.setCurrentItem(currentPage, true);
                }
                handler.postDelayed(this, 3000);
            }
        }, 3000);
    }
}
