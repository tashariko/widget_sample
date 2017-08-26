package learn.tasha.widgetexample;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tashariko on 26/08/17.
 */

public class TashaApplication extends Application {

    public static final String PREF_KEY_JSON = "jsonData";

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
