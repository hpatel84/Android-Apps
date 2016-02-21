package app.activities.com.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private TextView messageback;

    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.button);
        messageback = (TextView) findViewById(R.id.textView2);

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class); //passing value to second activity
                intent.putExtra("activityone", "I am from activity one");
               // startActivity(intent); //send to 2nd activity

                startActivityForResult(intent,REQUEST_CODE);

               // startActivity(new Intent(MainActivity.this,SecondActivity.class)); //go from first to second activity
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE){
            String result = data.getStringExtra("returnData");

            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }
    }
}

