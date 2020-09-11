package com.example.shayriapp.categories;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.shayriapp.R;

public class Funny extends AppCompatActivity implements View.OnClickListener{
    TextView count_txt,quotes_txt;
    CardView back_btn,copy_btn,share_btn,next_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout);

        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Funny");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        count_txt=findViewById(R.id.countTEXT);
        quotes_txt=findViewById(R.id.quotesTEXT);
        back_btn=findViewById(R.id.backbtn);
        copy_btn=findViewById(R.id.copybtn);
        share_btn=findViewById(R.id.sharebtn);
        next_btn=findViewById(R.id.nextbtn);
        back_btn.setOnClickListener(this);
        copy_btn.setOnClickListener(this);
        share_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.backbtn:
                break;

            case R.id.copybtn:
                break;


            case R.id.sharebtn:
                break;


            case R.id.nextbtn:
                break;


        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
