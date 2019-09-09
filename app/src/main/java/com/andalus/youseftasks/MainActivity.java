package com.andalus.youseftasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

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
        myAdapter = new MyAdapter(this, data, this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClick(Item item) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("Item name",item.getText());
        intent.putExtra("Image",item.getImage());
        MainActivity.this.startActivity(intent);
    }
}
