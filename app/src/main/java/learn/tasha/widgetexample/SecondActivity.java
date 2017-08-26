package learn.tasha.widgetexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by tashariko on 26/08/17.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView titleTextView, subTitleTextView;
    private String titleString, subTitleString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        subTitleTextView = (TextView) findViewById(R.id.subTitleTextView);

        if(getIntent()!=null && getIntent().getExtras()!=null){
            if(getIntent().getExtras().containsKey("ItemTitle")){
                titleString = getIntent().getExtras().getString("ItemTitle");
                subTitleString = getIntent().getExtras().getString("ItemSubTitle");

                titleTextView.setText(titleString);
                subTitleTextView.setText(subTitleString);
            }
        }
    }
}
