package learn.tasha.widgetexample;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

import static learn.tasha.widgetexample.TashaApplication.PREF_KEY_JSON;

/**
 * Created by tashariko on 26/08/17.
 */

public class WidgetDataModel {

    public String title = "";
    public String subTitle = "";


    public static void createSampleDataForWidget(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE);
        String json = sharedPref.getString(PREF_KEY_JSON, "[]");

        JSONArray jsonArray;
        try {
            jsonArray=new JSONArray(json);

            if(jsonArray.length()==0) {
                for (int i = 0; i < 10; i++) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("title", "Title: " + (i + 1));
                    jsonObject.put("subTitle", "This is subtitle: " + (i + 1));

                    jsonArray.put(jsonObject);
                }
                sharedPref.edit().putString(PREF_KEY_JSON,jsonArray.toString()).apply();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<WidgetDataModel> getDataFromSharedPrefs(Context context) {
        ArrayList<WidgetDataModel> list=new ArrayList<>();
        if(list.isEmpty()) {
            SharedPreferences sharedPref = context.getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE);
            String json = sharedPref.getString(PREF_KEY_JSON, "[]");

            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);

                    WidgetDataModel model = new WidgetDataModel();
                    model.title = object.getString("title");
                    model.subTitle = object.getString("subTitle");

                    list.add(model);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return list;

    }

}
