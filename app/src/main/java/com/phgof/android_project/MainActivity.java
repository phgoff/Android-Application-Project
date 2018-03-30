package com.phgof.android_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.phgof.android_project.CustomList.MainCustomList;
import com.phgof.android_project.RecyclerList.MainRecyclerList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private String[] mDrawerTitle = {"Main","Marvel's Hero","DC's Hero","Help"};
    private ListView mListView;
    private TextView tv1;
    private Button btnenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Drawable Menu
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout,
                R.string.open_drawer,
                R.string.close_drawer);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mListView = (ListView) findViewById(R.id.drawer);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mDrawerTitle);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  itemValue    = (String) mListView.getItemAtPosition(position);
                mDrawerLayout.closeDrawers();
                switch (position) {
                    case 0:
//                        Intent intent= new Intent(MainActivity.this, Activity2.class);
//                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2= new Intent(MainActivity.this, MainCustomList.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3= new Intent(MainActivity.this, MainRecyclerList.class);
                        startActivity(intent3);
                        break;
                    default:
                        break;
                }
                //   tv1.setText("Position :"+ position+"  ListItem : " +itemValue);
                Toast.makeText(getApplicationContext(),
                        "Position :"+ position+"  ListItem : " +itemValue , Toast.LENGTH_SHORT)
                        .show();
            }
        });
        // End of Section

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //when click Hamburger will show the menu
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    //Hamburger
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

}
