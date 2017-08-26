package learn.tasha.widgetexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String textForTextView="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);

        if(getIntent()!=null && getIntent().getExtras()!=null){
            if(getIntent().getExtras().containsKey("text") ){
                textForTextView = getIntent().getExtras().getString("text","");
            }
        }

        if(!textForTextView.equals("")){
            textView.setText(textForTextView);
        }

    }
}
