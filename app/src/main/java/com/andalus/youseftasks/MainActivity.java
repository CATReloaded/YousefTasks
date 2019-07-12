package com.andalus.youseftasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int itemImage = R.drawable.image;

        String itemText = "Google";

        Item item = new Item(itemImage, itemText);

        Item[] data = {item, item, item, item, item, item, item, item, item};

        RecyclerView recyclerView = findViewById(R.id.cells_rv);
        int col = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, col));
        myAdapter = new MyAdapter(this, data);
        recyclerView.setAdapter(myAdapter);
    }

}
