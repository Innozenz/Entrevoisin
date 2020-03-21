package com.openclassrooms.entrevoisins;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.w3c.dom.Text;

import java.util.List;

public class Details extends AppCompatActivity {
    private ImageView avatar;
    private TextView personName;
    private TextView reseau;
    private NeighbourApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Neighbour neighbour1 = getIntent().getParcelableExtra("neighbour1");
        FloatingActionButton fab = this.findViewById(R.id.fab);
        setSupportActionBar(toolbar);
        fab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_white_24dp));
        if (neighbour1 != null) {
            if (mApiService.getFavorites().contains(neighbour1)) {
                fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_white_24dp));
            } else {
                fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_border_white_24dp));
            }
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (neighbour1 != null) {
                    if (mApiService.getFavorites().contains(neighbour1)) {
                        mApiService.deleteFavorite(neighbour1);
                        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_border_white_24dp));
                    } else {
                        mApiService.addFavorite(neighbour1);
                        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_white_24dp));
                    }
                }
            }
        });


        Intent detailsActivity = getIntent();


        String neighbourStr = "";
        if (neighbour1 != null)
            neighbourStr += neighbour1.getName();

        String neighStr2 = "www.facebook.fr/";
        if (neighbour1 != null)
            neighStr2 += neighbour1.getName();

        avatar = (ImageView) findViewById(R.id.avatar);
        Glide.with(this)
                .load(neighbour1.getAvatarUrl())
                .into(avatar);

        personName = (TextView) findViewById(R.id.personName);
        personName.setText(neighbourStr);
        toolbar.setTitle(neighbourStr);

        reseau = (TextView) findViewById(R.id.reseau);
        reseau.setText(neighStr2);

    }


}


