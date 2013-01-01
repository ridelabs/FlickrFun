package com.crawlicious.flickr.trash;

import java.util.ArrayList;
import java.util.LinkedList;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

public class FlickrListAdapter2 implements ListAdapter {

    private LinkedList<String> strings = new LinkedList<String>();
    
    public FlickrListAdapter2() {
        strings.add("foo");
        strings.add("2foo");
        strings.add("f3oo");
        strings.add("fo4o");
        strings.add("foo5");
        
    }
    
    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return strings.get(position).hashCode();
    }

    @Override
    public int getItemViewType(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1; // we can reuse views... (what about images???  i'll have to figure that out)
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return strings.isEmpty();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean areAllItemsEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        // TODO Auto-generated method stub
        return true;
    }

}
