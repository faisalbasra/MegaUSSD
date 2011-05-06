package com.vasily.home;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

public class PriorClick extends AppWidgetProvider {


	private static final String ACTION_WIDGET_CONTROL = "com.vasily.home.CONTROL";
    public static final String URI_SCHEME = "ussd_widget";
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		Log.i("UUUPDATE", "goes");
        for (int appWidgetId : appWidgetIds) {

           
            RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.priorwidg);
            
            // modify remoteView based on current state
            setCaller(context, remoteView, appWidgetId);

        }
	}
	
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i("MYACTION", intent.getAction());
		super.onReceive(context, intent);

	}
	
    public void setCaller(Context context, RemoteViews remoteView, int appWidgetId) {
        remoteView.setOnClickPendingIntent(R.id.showCard, makeControlPendingIntent(context, "showCard", appWidgetId));
        AppWidgetManager.getInstance(context).updateAppWidget(appWidgetId, remoteView);
    }	
    
    private PendingIntent makeControlPendingIntent(Context context, String command, int appWidgetId) {
        Intent active = new Intent(context, SelectCard.class);
        active.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return PendingIntent.getActivity(context, 0, active, PendingIntent.FLAG_CANCEL_CURRENT);
    }	
}
