package com.juaracoding.nginep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.juaracoding.nginep.model.ModelNginep;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    TextView txtNama;
    FirebaseDatabase database;
    DatabaseReference myRef;

    EditText txtMessage;
    Button btnSend;
    String username;
    String email;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        btnSend = findViewById(R.id.btnKirim);
        txtMessage = findViewById(R.id.txtMessage);



        username = getIntent().getStringExtra("user");
        email = getIntent().getStringExtra("email");


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtMessage.getText().toString().equalsIgnoreCase("")) {
                    writeMessage(username, email, txtMessage.getText().toString());
                    txtMessage.setText("");
                }
            }
        });


      writeMessage(username,email,"sign in");

        myRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                List<ModelNginep> players = new ArrayList<ModelNginep>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    ModelNginep  player = postSnapshot.getValue(ModelNginep.class);
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

    private void writeMessage(String username, String email, String message) {
        ModelNginep user = new ModelNginep(username, email,message);
        DatabaseReference newRef = myRef.push();
        newRef.setValue(user);


    }
}
