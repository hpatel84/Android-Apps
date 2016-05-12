package app.bio.com.showmebio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView bachImage;
    private ImageView mozartImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bachImage = (ImageView) findViewById(R.id.Bachimage);
        mozartImage = (ImageView) findViewById(R.id.Mozartimage);

        bachImage.setOnClickListener(this);
        mozartImage.setOnClickListener(this);
        };

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.Bachimage:
                Intent bachIntent = new Intent(MainActivity.this, Main2Activity.class);
                bachIntent.putExtra("bach", "Hello I am Bach!");
                bachIntent.putExtra("name", "bach");
                startActivity(bachIntent);
                break;
            case R.id.Mozartimage:
                Intent mozartIntent = new Intent(MainActivity.this, Main2Activity.class);
                mozartIntent.putExtra("mozart", "Hello I am Mozart!");
                mozartIntent.putExtra("name", "mozart");
                startActivity(mozartIntent);
                break;
        }

    }
}


