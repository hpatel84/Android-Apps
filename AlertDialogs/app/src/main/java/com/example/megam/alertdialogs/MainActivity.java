package com.example.megam.alertdialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button showDialog;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showBtnId);

        showDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //show Alert Dialog

                dialog = new AlertDialog.Builder(MainActivity.this);

                //set Title
                dialog.setTitle(getResources().getString(R.string.dialog_title));

                //set Message
                dialog.setMessage(getResources().getString(R.string.dialog_message));

                //set Cancelable
                dialog.setCancelable(false);

                //set Icon
                dialog.setIcon(android.R.drawable.btn_star);

                //Positive
                dialog.setPositiveButton(getResources().getString(R.string.positive_button),

                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which){

                                //Exit activity
                                MainActivity.this.finish();
                            }
                        });

                // set Negative Button
                dialog.setNegativeButton(getResources().getString(R.string.negative_button),

                        new DialogInterface.OnClickListener() {
                            @Override
                            public  void onClick(DialogInterface dialog, int which){

                                dialog.cancel();

                            }
                        });

                //create dialog
                AlertDialog alertD = dialog.create();

                //show dialog
                alertD.show();
            }

        });
    }


}
