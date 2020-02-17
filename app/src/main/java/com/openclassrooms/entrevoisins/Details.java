package com.openclassrooms.entrevoisins;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.w3c.dom.Text;

public class Details extends AppCompatActivity {
    private ImageView avatar;
    private TextView personName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = this.findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        Intent detailsActivity = getIntent();

        Neighbour neighbour1 = getIntent().getParcelableExtra("neighbour1");
        String neighbourStr = "";
        if (neighbour1 != null)
            neighbourStr += neighbour1.getName();

        avatar = (ImageView)findViewById(R.id.avatar);
        Glide.with(this)
                .load(neighbour1.getAvatarUrl())
                .into(avatar);

        personName = (TextView)findViewById(R.id.personName);
        personName.setText(neighbourStr);
        toolbar.setTitle(neighbourStr);


        }



    }


