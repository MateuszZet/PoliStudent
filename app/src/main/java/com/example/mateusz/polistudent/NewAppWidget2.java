package com.example.mateusz.polistudent;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget2 extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget2);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {


            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, appWidgetId, intent, 0);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.new_app_widget2);
            remoteViews.setOnClickPendingIntent(R.id.wb, pendingIntent);
            remoteViews.setOnClickPendingIntent(R.id.wb2, pendingIntent);
            remoteViews.setOnClickPendingIntent(R.id.wb3, pendingIntent);
            if (intent.getAction().equals(R.id.wb)) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://edukacja.pwr.wroc.pl/EdukacjaWeb/studia.do"));
                context.startActivity(intent2);

            }
            if (intent.getAction().equals(R.id.wb2)) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jsos.pwr.edu.pl"));
                context.startActivity(intent2);

            }
            if (intent.getAction().equals(R.id.wb3)) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://smail.pwr.edu.pl/auth"));
                context.startActivity(intent2);

            }
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.activity_main);





    }



    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

