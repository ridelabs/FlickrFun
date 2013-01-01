package com.crawlicious.flickr;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
	public static final String EXTRA_MESSAGE = "com.crawlicious.flickr.MESSAGE.MEaningLessIdTag";
	private String imageUrl = "http://l.yimg.com/g/images/en-us/flickr-yahoo-logo.png.v4";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
		    ImageView i = (ImageView) findViewById(R.id.activity_main_image);
            i.setImageBitmap(new ImageUrlLoader().execute(imageUrl).get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }		    	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
		
	public void startSearch(View view) {
	    Intent intent = new Intent(this, SearchFlickrActivity.class);
	    EditText editText = (EditText) findViewById(R.id.edit_message);
	    String message = editText.getText().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);
	    
	}
	
//	public void sendMessage(View view) {
//		Intent intent = new Intent(this, DisplayMessageActivity.class);
//		EditText editText = (EditText) findViewById(R.id.edit_message);
//		String message = editText.getText().toString();
//		intent.putExtra(EXTRA_MESSAGE, message);
//		startActivity(intent);
//	}
	
	@Override
	public void onPause() {
		super.onPause();
		// pause everything here...  we may be stopped soon
	}
	
//	@Override
//	public void onSaveInstanceState() {
//		
//	}

}
