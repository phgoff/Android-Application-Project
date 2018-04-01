package com.phgof.android_project.SuperHero;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phgof.android_project.R;

public class MainSuperHero extends AppCompatActivity {

    private TextView tvhero;
    private ImageView imghero;
    private ImageView imglogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superhero);
        getSupportActionBar().setTitle("SuperHero");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvhero = findViewById(R.id.tvhero);
        imghero = findViewById(R.id.imghero);
        imglogo = findViewById(R.id.imglogo);

        Bundle bd = getIntent().getBundleExtra("bundle");
        tvhero.setText(bd.getCharSequence("heroname"));
        imghero.setImageResource(bd.getInt("resId"));

        Bitmap bm = bd.getParcelable("bmlogo");
        imglogo.setImageBitmap(bm);
//        Toast.makeText(this,"GET: " + bd.getString("heroname"),Toast.LENGTH_SHORT).show();

    }
}
