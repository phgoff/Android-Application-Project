package com.phgof.android_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.phgof.android_project.CustomList.MainCustomList;
import com.phgof.android_project.PacelableData.MainPacelable;
import com.phgof.android_project.PacelableData.MyData;
import com.phgof.android_project.RecyclerList.MainRecyclerList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private String[] mDrawerTitle = {"Home","Marvel's Hero","DC's Hero","Choose Heroes"};
    private ListView mListView;
    private TextView tv1;
    private Button btnenter;
    private EditText editname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editname = findViewById(R.id.edit1);
        btnenter = findViewById(R.id.btnenter);

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
                        break;
                    case 1:
                        Intent intent1= new Intent(MainActivity.this, MainCustomList.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2= new Intent(MainActivity.this, MainRecyclerList.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3= new Intent(MainActivity.this, MainPacelable.class);
                        startActivity(intent3);
                        break;
                    default:
                        break;
                }
                //   tv1.setText("Position :"+ position+"  ListItem : " +itemValue);
                Toast.makeText(getApplicationContext(),
                        "You Selected: "+itemValue , Toast.LENGTH_SHORT).show();
            }
        });
        // End of Section

        btnenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intententer = new Intent(MainActivity.this, MainPacelable.class);
            String name = editname.getText().toString();
            if(TextUtils.isEmpty(name)) {
                    editname.setError("Plese Enter Your Name");
                    return;
            }
            MyData md = new MyData(name);
            intententer.putExtra("uname", md );
            startActivity(intententer);
            }
        });
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
