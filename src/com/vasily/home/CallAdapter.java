package com.vasily.home;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CallAdapter extends ArrayAdapter<CallItem> {
	private ArrayList<CallItem> items;
    private Context context;
    
    public CallAdapter(Context context, int textViewResourceId, ArrayList<CallItem> items) {
            super(context, textViewResourceId, items);
            this.items = items;
            this.context = context;
    }
    
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View row;

		if (null == convertView) 
		{
			LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inf.inflate(R.layout.list_item, null);
		} 
		else 
		{
			row = convertView;
		}

		TextView tv = (TextView) row.findViewById(R.id.mytext);
		if(tv != null)
		{
			tv.setText(items.get(position).title);
			tv.setTag(items.get(position));
		}
		return row;
	}    


	
}
