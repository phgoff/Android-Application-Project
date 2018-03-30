package com.phgof.android_project.RecyclerList;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.phgof.android_project.CustomList.MainCustomList;
import com.phgof.android_project.MainActivity;
import com.phgof.android_project.R;
import com.phgof.android_project.SuperHero.MainSuperHero;

/**
 * Created by 5835512090 on 3/30/2018.
 */
//Recycler View - DC
public class MainRecyclerList extends AppCompatActivity implements ItemClickListener {

    RecyclerViewAdapter adapter;
    int[] resId = {  R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,R.drawable.image9
    };
    String[] list = { "SuperMan", "Wonder Woman", "The Flash","BATMAN"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerlist);
        getSupportActionBar().setTitle("RecyclerList View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView listViewR = findViewById(R.id.reclycerlist);
        adapter = new RecyclerViewAdapter(getApplicationContext(), list,resId);
        listViewR.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);
        listViewR.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
//        if (position != 0) {
//            Toast.makeText(this, "Click: " + adapter.getItem(position) +
//                    " on row:" + (position + 1), Toast.LENGTH_SHORT).show();
//        }
        //Pass Image via BitMap - Parcelable
        ImageView logoDC = findViewById(R.id.logodc);
        logoDC.buildDrawingCache();
        Bitmap bmlogo = logoDC.getDrawingCache();

        Bundle bundle = new Bundle();
        Intent intent= new Intent(MainRecyclerList.this, MainSuperHero.class);

        bundle.putString("name",adapter.getItem(position).toString());
        bundle.putInt("resId",resId[position]);
        bundle.putParcelable("bmlogo",bmlogo);

        intent.putExtra("bundle",bundle);
        startActivity(intent);

    }

}
