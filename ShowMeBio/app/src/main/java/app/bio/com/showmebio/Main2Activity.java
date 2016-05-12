package app.bio.com.showmebio;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {

    private ImageView profileImage;
    private TextView bioText;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        profileImage = (ImageView) findViewById(R.id.detailsImage);
        bioText = (TextView) findViewById(R.id.detailsText);

        extras = getIntent().getExtras();

        if (extras != null){

            String name = extras.getString("name");

            ShowDetails(name);

        }

    }

    public void ShowDetails (String mName){

        if (mName.equals("bach")){
            profileImage.setImageDrawable(getResources().getDrawable(R.drawable.bach));
            bioText.setText(extras.getString(mName));
        } else if (mName.equals("mozart")){
            profileImage.setImageDrawable(getResources().getDrawable(R.drawable.mozart));
            bioText.setText(extras.getString(mName));
        }

    }


}
