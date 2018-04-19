package com.phgof.android_project.PacelableData;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.phgof.android_project.CustomList.MainCustomList;
import com.phgof.android_project.R;
import com.phgof.android_project.RecyclerList.MainRecyclerList;

public class MainPacelable extends AppCompatActivity {

    private TextView tvpercal;
    private ImageView pmavel;
    private ImageView pdc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacelable);
        tvpercal = findViewById(R.id.tvpacel);
        pmavel = findViewById(R.id.pamarvel);
        pdc = findViewById(R.id.pdc);

        //Change actionbar's name and back button to ..
       getSupportActionBar().setTitle("Pacelable");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       String guest = "Guest";
       tvpercal.setText(guest);
       MyData md = getIntent().getParcelableExtra("uname");
       if(md != null)
            tvpercal.setText(md.names);

        pmavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPacelable.this, MainCustomList.class);
                startActivity(i);
            }
        });

        pdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPacelable.this, MainRecyclerList.class);
                startActivity(i);
            }
        });

    }

}
