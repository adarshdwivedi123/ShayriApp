package com.example.shayriapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Adapter;

import com.example.shayriapp.NavigationDrawerItems.Facebook;
import com.example.shayriapp.NavigationDrawerItems.Instagram;
import com.example.shayriapp.NavigationDrawerItems.PrivacyPolicy;
import com.example.shayriapp.NavigationDrawerItems.TermsConditions;
import com.example.shayriapp.NavigationDrawerItems.YouTube;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private MyAdapter mAdapter;
    NavigationView navigationView;

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        navigationView = findViewById(R.id.navigation_menu);
        navigationView.setItemIconTintList(null);
        drawerLayout = findViewById(R.id.drawer);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();





        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.youtube:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent youtube = new Intent(Home.this, YouTube.class);
                        startActivity(youtube);
                        break;

                    case R.id.facebookPage:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent facebook = new Intent(Home.this, Facebook.class);
                        startActivity(facebook);
                        break;

                    case R.id.instagramPage:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent instagram = new Intent(Home.this, Instagram.class);
                        startActivity(instagram);
                        break;

                    case R.id.nav_rate:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("market://details?id=" + getPackageName())));

                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                        }
                        break;

                    case R.id.nav_share:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent myIntent = new Intent(Intent.ACTION_SEND);
                        myIntent.setType("text/plain");
                        String shareBody = "Hindi Shayari = get all type of quotes \n" + "https://play.google.com/store/apps/details?id=com.click2code.rationcarddetailsjharkhand&hl=en";
                        String shareSub = "Your Subject Here";
                        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                        myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(myIntent, "Share using"));
                        break;

                    case R.id.nav_privacy_policy:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent privacy = new Intent(Home.this, PrivacyPolicy.class);
                        startActivity(privacy);
                        break;

                    case R.id.nav_terms_conditions:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent terms = new Intent(Home.this, TermsConditions.class);
                        startActivity(terms);
                        break;
                }
                return true;
            }
        });

        // RecyclerView
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
// Set its Properties
//grid view with 2 columns in each row
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
// Adapter
        mAdapter = new MyAdapter(this, getModels());
        mRecyclerView.setAdapter(mAdapter);


    }



    private ArrayList<Model> getModels() {
        ArrayList<Model> models = new ArrayList<>();
        Model p;

        // Create an items for recycler view below
        p = new Model();
        p.setTitle("Good Morning");
        p.setImage(R.drawable.goodmorning);
        models.add(p);

        p = new Model();
        p.setTitle("Good Night");
        p.setImage(R.drawable.goodnight);
        models.add(p);

        p = new Model();
        p.setTitle("Love");
        p.setImage(R.drawable.love);
        models.add(p);

        p = new Model();
        p.setTitle("Romantics");
        p.setImage(R.drawable.romantic);
        models.add(p);

        p = new Model();
        p.setTitle("Couple");
        p.setImage(R.drawable.couple);
        models.add(p);

        p = new Model();
        p.setTitle("Valentine Day");
        p.setImage(R.drawable.velentineday);
        models.add(p);

        p = new Model();
        p.setTitle("Friendship");
        p.setImage(R.drawable.friends);
        models.add(p);

        p = new Model();
        p.setTitle("Birthday");
        p.setImage(R.drawable.birthday);
        models.add(p);

        p = new Model();
        p.setTitle("Funny");
        p.setImage(R.drawable.funny);
        models.add(p);

        p = new Model();
        p.setTitle("Best Wishes");
        p.setImage(R.drawable.best);
        models.add(p);

        p = new Model();
        p.setTitle("GOD");
        p.setImage(R.drawable.bhagwan);
        models.add(p);

        p = new Model();
        p.setTitle("Attitude");
        p.setImage(R.drawable.attitude);
        models.add(p);

        return models;
    }

    private void layoutAnimation(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_right);

        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }


}