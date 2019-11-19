package com.juaracoding.nginep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.juaracoding.nginep.model.Player;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    TextView txtNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("data").child("player");

       // myRef.setValue("Hello, Juara!");

        myRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                List<Player> players = new ArrayList<Player>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                  Player  player = postSnapshot.getValue(Player.class);
                   players.add(player);
                }
               PlayerAdapter  itemList = new PlayerAdapter(players);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv.setAdapter(itemList);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });
    }
}
