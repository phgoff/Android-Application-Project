package com.phgof.android_project.PacelableData;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phgof.android_project.CustomList.MainCustomList;
import com.phgof.android_project.R;
import com.phgof.android_project.RecyclerList.MainRecyclerList;

public class MainPercalable extends AppCompatActivity {

    private TextView tvpercal;
    private ImageView pmavel;
    private ImageView pdc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percalable);
        tvpercal = findViewById(R.id.tvpacel);
        pmavel = findViewById(R.id.pamarvel);
        pdc = findViewById(R.id.pdc);


       getSupportActionBar().setTitle("Pecelable");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       MyData md = getIntent().getParcelableExtra("uname");
//        String yanmes = md.getNames();
        tvpercal.setText("Hello " + md.names);
//        Toast.makeText(getApplicationContext(),"TEST: " + md, Toast.LENGTH_SHORT).show();

        pmavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPercalable.this, MainCustomList.class);
                startActivity(i);
            }
        });

        pdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPercalable.this, MainRecyclerList.class);
                startActivity(i);
            }
        });

    }

}
