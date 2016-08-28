package com.example.megam.radiobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioChoiceBtn;

    private TextView showChoiceTextView;
    private Button showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up TextView
        showChoiceTextView = (TextView) findViewById(R.id.textView);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupid);

        showBtn = (Button) findViewById(R.id.button);

        showBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                int selectOption = radioGroup.getCheckedRadioButtonId();

                radioChoiceBtn = (RadioButton) findViewById(selectOption);

                showChoiceTextView.setText(radioChoiceBtn.getText());

            }
        });

    }
}
