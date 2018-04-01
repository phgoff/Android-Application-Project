package com.phgof.android_project.CustomList;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.phgof.android_project.R;
import com.phgof.android_project.RecyclerList.MainRecyclerList;
import com.phgof.android_project.SuperHero.MainSuperHero;

/**
 * Created by Ph.GOF on 3/30/2018.
 */

// Custom List View - Marvel
public class MainCustomList extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlist);
        getSupportActionBar().setTitle("CustomList View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String[] list = { "Iron Man","SpiderMan","DeadPool","The Punisher"};
        final int[] resId = {  R.drawable.image4,
                            R.drawable.image6,
                            R.drawable.image7,
                            R.drawable.main2

        };

        final CustomAdapter adapter = new CustomAdapter(getApplicationContext(), list, resId);
        final ListView listView = (ListView)findViewById(R.id.Clist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long row_id) {
                // Toast.makeText(getApplicationContext(), "You Selected: " +  itemValue , Toast.LENGTH_SHORT).show();
                String itemValue = (String) listView.getItemAtPosition(position);
                //Pass image via Bitmap
                ImageView logomar = findViewById(R.id.logomar);
                logomar.buildDrawingCache();
                Bitmap bmlogo = logomar.getDrawingCache();

                Bundle bundle = new Bundle();
                Intent intent= new Intent(MainCustomList.this, MainSuperHero.class);

                bundle.putString("heroname",itemValue.toString());
                bundle.putInt("resId",resId[position]);
                bundle.putParcelable("bmlogo",bmlogo);

                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
        Toast.makeText(this, "Welcom To MARVEL", Toast.LENGTH_SHORT).show();
    }
}