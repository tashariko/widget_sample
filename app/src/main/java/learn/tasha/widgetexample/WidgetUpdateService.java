package learn.tasha.widgetexample;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by tashariko on 26/08/17.
 */

public class WidgetUpdateService extends IntentService {


    public static final String ACTION_UPDATE_APP_WIDGETS = "learn.tasha.widgetexample.widgetupdateservice.update_app_widget";
    public static final String ACTION_UPDATE_LIST_VIEW = "learn.tasha.widgetexample.widgetupdateservice.update_app_widget_list";

    public WidgetUpdateService() {
        super("WidgetUpdateService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_UPDATE_APP_WIDGETS.equals(action)) {
                handleActionUpdateAppWidgets();
            }else if(ACTION_UPDATE_LIST_VIEW.equals(action)){
                handleActionUpdateListView();
            }
        }
    }

    private void handleActionUpdateListView() {
        WidgetDataModel.createSampleDataForWidget(getApplicationContext());

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, SampleAppWidgetProvider.class));

        SampleAppWidgetProvider.updateAllAppWidget(this, appWidgetManager,appWidgetIds);

        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.listView);

    }

    private void handleActionUpdateAppWidgets() {

        //You can do any task regarding this process you want to do here, then update the widget.

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, SampleAppWidgetProvider.class));

        SampleAppWidgetProvider.updateAllAppWidget(this, appWidgetManager,appWidgetIds);
    }

    public static void startActionUpdateAppWidgets(Context context, boolean forListView) {
        Intent intent = new Intent(context, WidgetUpdateService.class);
        if(forListView){
            intent.setAction(ACTION_UPDATE_LIST_VIEW);
        }else {
            intent.setAction(ACTION_UPDATE_APP_WIDGETS);
        }
        context.startService(intent);
    }

}
