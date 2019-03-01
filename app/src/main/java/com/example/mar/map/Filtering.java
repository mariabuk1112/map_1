package com.example.mar.map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class Filtering extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    String rbValue;
    //fierbase***
    DatabaseReference database;
    static List<Hospital> hospitalList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtering);

        //getMultyData();
        Button but = (Button) findViewById(R.id.next);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //array for hospital to categories it
                hospitalList= new ArrayList<Hospital>();
                //  get id of redio group
                rg = (RadioGroup) findViewById(R.id.r_g);
                //take vale from redio group and put it in radio button
                rb = (RadioButton) findViewById (rg.getCheckedRadioButtonId());
                //take value of readio button
                rbValue=rb.getText().toString();
                //call query to categories
                getCategotyByQuery();
                //address for the next page will move to
                //Intent i = new Intent(Filtering.this, Display.class);
                //
                //   i.putExtra("lyst of hospitals" , hospitalList);
                //applay move
               // startActivity(i);

            }
        });

    }



//*******
    public  void getMultyData(){
        FirebaseDatabase.getInstance().getReference().child("Hospital").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Hospital module = snapshot.getValue(Hospital.class);
                    Log.v("mmm",module.getCategory());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

//******
    public  void getCategotyByQuery(){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Hospital");
        Query query = reference.orderByChild("category").equalTo(rbValue);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //  if(dataSnapshot.exists()){
                //forloop for add
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                    Hospital module = snapshot.getValue(Hospital.class);
                    hospitalList.add(module) ;
                    Log.v("lll",module.getCategory());
                }
                //forloop for get data
                for(int i=0;i<hospitalList.size();i++){
                    String name=hospitalList.get(i).name;
                    Log.v("mariaxxx", name);
                }
                //   }
            }
            @Override
            public  void onCancelled(DatabaseError databaseError) {
            }
        });
    }


}
