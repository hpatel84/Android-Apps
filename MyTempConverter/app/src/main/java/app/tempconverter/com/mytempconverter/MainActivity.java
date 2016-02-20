package app.tempconverter.com.mytempconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText myTemp;
    private Button celButton;
    private Button fButton;
    private TextView myTextView;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        myTemp = (EditText) findViewById(R.id.editTextId);
        celButton = (Button) findViewById(R.id.buttonCId);
        fButton =(Button) findViewById(R.id.buttonFId);
        myTextView = (TextView) findViewById(R.id.textViewId);

        celButton.setOnClickListener(new View.OnClickListener(){ //F to C
            @Override
            public void onClick(View v) {
                String holder= myTemp.getText().toString(); //get value from user

                if (holder.isEmpty()){ //checking if empty
                    Toast.makeText(getApplicationContext(),"Enter a Value", Toast.LENGTH_LONG).show();

                }else{
                    double tempVal = Double.parseDouble(holder); //making holder an int value
                    double CVal = ConvertToC(tempVal); //getting F value

                    String result = String.valueOf(round.format(CVal)) + " C";
                    myTextView.setText(result);

                }

            }
        });


        fButton.setOnClickListener(new View.OnClickListener() { //C to F
            @Override
            public void onClick(View v) {
                String holder= myTemp.getText().toString(); //get value

                if (holder.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter a Value", Toast.LENGTH_LONG).show();

                }else{
                    double tempVal = Double.parseDouble(holder); //convert to int
                    double FVal = ConvertToF(tempVal); //send to be converted

                    String result = String.valueOf(round.format(FVal)) + " F";
                    myTextView.setText(result);

                }

            }
        });

    }

    public double ConvertToC (double farVal){ //converting to Celsius

        double cResult;
        cResult = (farVal -32) * 5/9;
        return cResult;
    }

    public double ConvertToF (double cVal){ //converting to Fahrenheit

        double fResult;
        fResult = (cVal *9/5) +32;
        return fResult;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
