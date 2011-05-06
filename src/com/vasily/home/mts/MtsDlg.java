package com.vasily.home.mts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.vasily.home.CallAdapter;
import com.vasily.home.CallItem;
import com.vasily.home.Caller;
import com.vasily.home.R;


import android.app.ListActivity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MtsDlg extends ListActivity {
	
	public String getFileName()
	{
		return "mts.txt";
	}
	
	ArrayList<CallItem> items = new ArrayList<CallItem>();
	CallAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dlg_select_card);
		

	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		AssetManager mngr=getAssets();
		items.clear();
		try {
			InputStream file = mngr.open(getFileName());
			BufferedReader reader = new BufferedReader(new InputStreamReader(file));
			while(reader.ready())
			{
				CallItem item = new CallItem();
				item.phone = reader.readLine();
				item.title = reader.readLine();
				items.add(item);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		adapter = new CallAdapter(this, R.layout.list_item, items);
		setListAdapter(adapter);		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		CallItem sp = (CallItem) v.findViewById(R.id.mytext).getTag();
		if(sp != null)
		{
			Caller.call(sp, this);		
		}
	}		
	
}
