package com.crawlicious.flickr;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class ImageUrlLoader extends AsyncTask<String, Void, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... arg0) {

        try {

//          HttpGet httpRequest = null;
//
//          httpRequest = new HttpGet(url.toURI());
//
//          HttpClient httpclient = new DefaultHttpClient();
//          HttpResponse response = (HttpResponse) httpclient.execute(httpRequest);
//
//          HttpEntity entity = response.getEntity();
//          BufferedHttpEntity b_entity = new BufferedHttpEntity(entity);
//          InputStream input = b_entity.getContent();
//
//          Bitmap bitmap = BitmapFactory.decodeStream(input);
//          return bitmap;

            URL url = new URL(arg0[0]);
            InputStream is = url.openStream();                      
            try {
                return BitmapFactory.decodeStream(is);
            } finally {
                is.close();
            }
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }

}
