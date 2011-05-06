package com.vasily.home;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class UssdShow extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	
        /*try {
        	String encodedHash = Uri.encode("#");
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:*212*6498"+encodedHash)));
          } catch (Exception e) {
            e.printStackTrace();
          }
    	finish();*/
    }
}