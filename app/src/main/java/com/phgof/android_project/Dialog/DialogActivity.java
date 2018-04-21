package com.phgof.android_project.Dialog;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.phgof.android_project.R;

public class DialogActivity extends AppCompatActivity {

    private TextView tvdl;
    private Button btnadd;
    private Button btndeldl;

    NotificationCompat.Builder mBuilder;
    NotificationManager mNotifyMgr;
    NotificationManager nMgr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        getSupportActionBar().setTitle("DIALOGS NOTIFICATIONS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvdl =findViewById(R.id.tvdl);
        btnadd = findViewById(R.id.btnadd);
        btndeldl = findViewById(R.id.btndeldl);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert(view);
            }
        });

        btndeldl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ns = Context.NOTIFICATION_SERVICE;
                nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
                nMgr.cancel(1);
                Toast.makeText(DialogActivity.this,"Deleted Message",Toast.LENGTH_LONG).show();
            }
        });

        mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_stat_noti)
                        .setContentTitle("New Message")
                        .setContentText("Open Google website!");

        Intent resultIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.google.com/"));
        //  Define notification action
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,   // context
                        0,      // requestCode (defined PendingIntent id)
                        resultIntent,
                        // if a previous PendingIntent already exists,
                        // then the current one will update it with the latest intent
                        PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
    }

    //Alert Dialog
    public void alert(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Messages Notification");
        builder.setMessage("Create New Message");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
//                Toast.makeText(getApplicationContext(),
//                        "You have new message", Toast.LENGTH_SHORT).show();
                mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
                mNotifyMgr.notify(1, mBuilder.build());
                Toast.makeText(DialogActivity.this,"You have new Message",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
            }
        });
        builder.show();
    }
}
