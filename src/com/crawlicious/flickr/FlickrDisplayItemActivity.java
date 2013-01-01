package com.crawlicious.flickr;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FlickrDisplayItemActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.selected_list_item_view);
 
        TextView txtProduct = (TextView) findViewById(R.id.image_detail);
 
        Intent intent = getIntent();
        // getting attached intent data
        String imageDetail = intent.getStringExtra(SearchFlickrActivity.ITEM_DETAIL_KEY);
        // displaying selected product name
        txtProduct.setText(imageDetail + " is my image detail, ok?");
        
        String url = intent.getStringExtra(SearchFlickrActivity.ITEM_URL_KEY);
        
        try {           
            ImageView image = (ImageView) findViewById(R.id.selected_image);
            image.setImageBitmap(new ImageUrlLoader().execute(url).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
 
    }
}
