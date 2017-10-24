package com.jonmid.segundoparcial.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.Array.Images;
import com.jonmid.segundoparcial.R;
import com.jonmid.segundoparcial.TeamActivity;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private TextView txt1, txt2;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txt1 = (TextView) findViewById(R.id.id_tv_codedetail);
        txt2 = (TextView) findViewById(R.id.id_tv_namedetail);


        Bundle bundle = getIntent().getExtras();
        txt1.setText(bundle.getString("code"));
        txt2.setText(bundle.getString("name"));

        img = (ImageView) findViewById(R.id.id_img_item_detail);
        Picasso.with(this).load(Images.imageRandom()).into((img));
    }


    public void toReturn(View v) {
        Intent intent = new Intent(this, TeamActivity.class);
        startActivity(intent);

    }


}
