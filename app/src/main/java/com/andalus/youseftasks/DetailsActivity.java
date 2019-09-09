package com.andalus.youseftasks;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

public class DetailsActivity extends AppCompatActivity {

    private Item item;
    @BindView(R.id.item_image_details) ImageView imageView;
    @BindView(R.id.item_text_details) TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        item = new Item();
        fetchIntent();

        imageView = findViewById(R.id.item_image_details);
        textView = findViewById(R.id.item_text_details);

        imageView.setImageBitmap(intToBitmap(item.getImage()));
        textView.setText(item.getText());
    }

    void fetchIntent(){
        Intent intent = getIntent();
        if (intent != null){
            item.setText(checkStringExtras(intent));
            item.setImage(checkIntExtras(intent));
        }
    }

    String checkStringExtras(Intent intent){
        return intent.hasExtra("Item name")?intent.getStringExtra("Item name"):"Empty.";
    }
    int checkIntExtras(Intent intent){
        return intent.hasExtra("Image")?intent.getIntExtra("Image",3):5;
    }

    private Bitmap intToBitmap (int v){
        return BitmapFactory.decodeResource(getResources(),v);
    }
}
