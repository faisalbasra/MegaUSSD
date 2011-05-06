package com.vasily.home.mts;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.vasily.home.R;

public class MtsReceiver extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.mtswidg);
            setCaller(context, remoteView, appWidgetId);
        }
	}
	
    public void setCaller(Context context, RemoteViews remoteView, int appWidgetId) {
        remoteView.setOnClickPendingIntent(R.id.showMts, makeControlPendingIntent(context, "showMts", appWidgetId));
        AppWidgetManager.getInstance(context).updateAppWidget(appWidgetId, remoteView);
    }	
    
    private PendingIntent makeControlPendingIntent(Context context, String command, int appWidgetId) {
        Intent active = new Intent(context, MtsDlg.class);
        active.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return PendingIntent.getActivity(context, 0, active, PendingIntent.FLAG_CANCEL_CURRENT);
    }	
}
