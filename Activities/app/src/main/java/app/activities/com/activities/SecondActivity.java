package app.activities.com.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView myText;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myText = (TextView) findViewById(R.id.textView);
        backButton = (Button) findViewById(R.id.back_button);

        Bundle extras = getIntent().getExtras(); //extras found in both activity sending and receiving

        if (extras !=null){
            String myString = extras.getString("activityone"); //use key to get message
            myText.setText(myString);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent(); //passing value to second activity
                returnIntent.putExtra("returnData","And we are back");
                returnIntent.putExtra("somethingElse","Something Else");
                setResult(RESULT_OK,returnIntent);
                finish();

            }
        });
    }

}
