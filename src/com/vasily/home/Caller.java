package com.vasily.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Caller {

	public static void call(CallItem sp, Context context) 
	{
        try 
        {
        	String encodedHash = Uri.encode("#");
        	context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+sp.phone+encodedHash)));
        } catch (Exception e) 
        {
        	e.printStackTrace();
        }		
	}

}
