package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<FoodData> myFoodList;
    FoodData mFoodData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        myFoodList = new ArrayList<>();

        //pętla for each do wypisania wszystkich danych z bazy danych v v v v v
        mFoodData = new FoodData("tytul","dupa","50zł", R.drawable.image);
        myFoodList.add(mFoodData);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, myFoodList);
        mRecyclerView.setAdapter(myAdapter);

    }

    public void btn_uploadActivity(View view) {
        startActivity(new Intent(this, Upload_Recipe.class));
    }
}