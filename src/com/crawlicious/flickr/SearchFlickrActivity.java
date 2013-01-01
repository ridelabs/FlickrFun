package com.crawlicious.flickr;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SearchFlickrActivity extends ListActivity {
    public static final String ITEM_DETAIL_KEY = "SEARCH_FLICKR_ACTIVITY_ITEM_DETAIL_KEY";
    public static final String ITEM_URL_KEY = "SEARCH_FLICKR_ACTIVITY_ITEM_URL_KEY";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flickr);       
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

//        System.out.println("HI, i am SearchFlickr and i am onCreate!@!!!!, searching for: " + message);
//        String[] items = getResources().getStringArray(R.array.adobe_products);
        
        String[] items = new FlickrResource().searchItems(message);
        
        
        
        
        
        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item_view, R.id.list_item_view_label, items));

        ListView lv = getListView();
        
        // listen to a click
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              // selected item
              String itemDetail = ((TextView) view).getText().toString();
              // Launching new Activity on selecting single List Item
              Intent intent = new Intent(getApplicationContext(), FlickrDisplayItemActivity.class);
              // sending data to new activity
              intent.putExtra(ITEM_DETAIL_KEY, itemDetail);
              intent.putExtra(ITEM_URL_KEY, "http://farm4.staticflickr.com/3512/3257141808_19bfa7e941_m.jpg");
              startActivity(intent);
          }
        });
        
    }


}
