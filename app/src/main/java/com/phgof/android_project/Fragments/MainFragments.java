package com.phgof.android_project.Fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.phgof.android_project.R;

public class MainFragments extends AppCompatActivity {

    private Button btnDelete;
    private Button btnAdd;
    private Button btnAdd2;

    private String TAG = "MyFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragments);

        btnAdd = findViewById(R.id.btnadd_frag);
        btnAdd2 = findViewById(R.id.btnadd2_frag);
        btnDelete = findViewById(R.id.btndel_frag);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.sended_frag,
                                BlankFragment.newInstance("Sended MARVEL"),    //called newInstance() from BlankFragment
                                TAG)
                        .addToBackStack("MyStack")
                        .commit();
            }
        });
        btnAdd2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 getSupportFragmentManager()
                         .beginTransaction()
                         .replace(R.id.sended_frag,
                                 BlankFragment2.newInstance("Sended DC"),    //called newInstance() from BlankFragment2
                                 TAG)
                         .addToBackStack("NewStack")
                         .commit();
                    }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG);
                if (fragment != null) {
                    getSupportFragmentManager().popBackStack();
                    Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}