package com.example.shayriapp.categories;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.shayriapp.Model;
import com.example.shayriapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GoodNight extends AppCompatActivity implements View.OnClickListener {

    TextView count_txt,quotes_txt;
    CardView back_btn,copy_btn,share_btn,next_btn;

    List<String> quotes_list;
    DatabaseReference databaseReference;
    Model myShayari;
    int position=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout);
        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GoodNight");
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

        databaseReference= FirebaseDatabase.getInstance().getReference("goodnight");
        myShayari=new Model();
        quotes_list=new ArrayList<>();

        //Event Value Methods

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot1:snapshot.getChildren()){
                    myShayari=dataSnapshot1.getValue(Model.class);
                    if(myShayari!=null){
                        quotes_list.add(myShayari.getTitle());
                        count_txt.setText(position+ "/" + quotes_list.size());
                    }
                }
                quotes_txt.setText(quotes_list.get(position));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GoodNight.this, "Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.backbtn:
                back();
                break;

            case R.id.copybtn:
                copy();
                break;


            case R.id.sharebtn:
                share();
                break;



            case R.id.nextbtn:
                next();
                break;


        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void back(){
        if(position>0){
            position=(position-1)%quotes_list.size();
            quotes_txt.setText(quotes_list.get(position));
            count_txt.setText(position + "/" + quotes_list.size());  //for count position

        }
    }

    private void next() {
        if (position< 5) {

            position = (position + 1) % quotes_list.size();
            quotes_txt.setText(quotes_list.get(position));
            count_txt.setText(position + "/" + quotes_list.size());
        }
    }



    private void copy(){


        ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("text",quotes_txt.getText());
        if(clipboardManager!=null)
        {
            clipboardManager.setPrimaryClip(clipData);

        }
        Toast.makeText(this, "copied", Toast.LENGTH_SHORT).show();
    }
    private void share()
    {

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent .putExtra(Intent.EXTRA_TEXT,quotes_txt.getText());
        startActivity(Intent.createChooser(intent,"share Via"));

    }




}



