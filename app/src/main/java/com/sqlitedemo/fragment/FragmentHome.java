package com.sqlitedemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sqlitedemo.R;
import com.sqlitedemo.UpdateDeleteActivity;
import com.sqlitedemo.adapter.RecycleViewAdapter;
import com.sqlitedemo.dal.SQLiteHelper;
import com.sqlitedemo.model.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FragmentHome extends Fragment implements RecycleViewAdapter.ItemListener {

    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;
    private SQLiteHelper db;
    private TextView tvTong;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        recyclerView = view.findViewById(R.id.recycleView);
//        tvTong = view.findViewById(R.id.tvTong);
//        adapter = new RecycleViewAdapter();
//        db = new SQLiteHelper(getContext());
//        Date d = new Date();
//        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//        List<Item> list  = db.getAll();
//        adapter.setList(list);
//        tvTong.setText("Tong tien: " + tong(list));
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
//        adapter.setItemListener(this);

//        recyclerView = view.findViewById(R.id.recycleView);
//        tvTong = view.findViewById(R.id.tvTong);
//        adapter = new RecycleViewAdapter();
//        db = new SQLiteHelper(getContext());
//        Date d = new Date();
//        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//        List<Item> list  = db.getAll();
//        adapter.setList(list);
//        tvTong.setText("Tong tien: " + tong(list));
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
//        adapter.setItemListener(this);

//        recyclerView = view.findViewById(R.id.recycleView);
//        adapter = new RecycleViewAdapter();
//        db = new SQLiteHelper(getContext());
//        Item item = new Item(1, "Quan bo", "mua sam", "500", "28/03/2022");
//        db.addItem(item);
//        db.addItem(item);
//
//        List<Item> list1 = db.getAll();
//        List<Item> list = new ArrayList<>();
//        list.add(item);
//        adapter.setList(list1);
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
//        adapter.setItemListener(this);


        recyclerView = view.findViewById(R.id.recycleView);
        tvTong = view.findViewById(R.id.tvTong);
        adapter = new RecycleViewAdapter();
        db = new SQLiteHelper(getContext());

        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

        List<Item> list = db.getByDate(f.format(d));
        tvTong.setText("Tong tien: " + tong(list));

        adapter.setList(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);


    }

    private int tong(List<Item> list){
        int t = 0;
        for(Item i : list){
            t += Integer.parseInt(i.getPrice());

        }
        return   t;
    }

    @Override
    public void onItemClick(View view, int position) {
        Item item = adapter.getItem(position);
        Intent intent = new Intent(getActivity(), UpdateDeleteActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        List<Item> list  = db.getByDate(f.format(d));
        adapter.setList(list);
        tvTong.setText("Tong tien: " + tong(list));
    }
}
