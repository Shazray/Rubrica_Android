package accademia.lynxspa.com.accademiaapp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import accademia.lynxspa.com.accademiaapp.R;
import accademia.lynxspa.com.accademiaapp.data.MainSingleton;
import accademia.lynxspa.com.accademiaapp.logic.DataAccessUtils;

public class DetailActivity extends Activity {

    private int currentItemValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int selectedItem = intent.getIntExtra(MainActivity.EXTRA_SELECTED_ITEM, 0);

        currentItemValue = selectedItem;

        // Set TextView
        TextView resultTextView = (TextView) findViewById(R.id.detailTextView);
        resultTextView.setText(DataAccessUtils.getItemAtIndex(this, selectedItem).getNome());


        // Set ImageView
        final ImageView imageView = (ImageView) findViewById(R.id.detailImageView);
        imageView.setBackgroundColor(DataAccessUtils.getColorForPosition(this, selectedItem));

        // Set onclick listener
        Button detailButton = (Button) findViewById(R.id.detailButton);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   finish();
            }
        });
        Button starButton = (Button) findViewById(R.id.favoriteButton);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFavoriteValue();
            }
        });
    }

    public void setFavoriteValue() {

        DataAccessUtils.getFavoriteValueInPreferences(DetailActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}