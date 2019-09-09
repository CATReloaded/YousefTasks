package com.andalus.youseftasks;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    MyAdapter myAdapter;
    @BindView(R.id.cells_rv) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        int itemImage = R.drawable.image;

        String itemText = "Google";

        Item item = new Item(itemImage, itemText);

        Item[] data = {item, item, item, item, item, item, item, item, item};

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
