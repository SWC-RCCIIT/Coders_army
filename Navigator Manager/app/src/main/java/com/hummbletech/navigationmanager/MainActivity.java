package com.hummbletech.navigationmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    list_of_rooms_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Navigation Manager");

        TextView textView = findViewById(R.id.textView1);

        textView.setText("Welcome Manager! Set up your indoor Navigation!");

        final RecyclerView recyclerView = findViewById(R.id.recyclerView_main);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("/buildings/WCurlwiknwS7X8lCVv48/rooms")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    List<DocumentSnapshot> snapshot= Objects.requireNonNull(task.getResult()).getDocuments();
                    adapter = new list_of_rooms_adapter(MainActivity.this, snapshot);
                    recyclerView.setAdapter(adapter);
                    }
                else{
                    Toast.makeText(getBaseContext(), "Error in obtaining the data :"+task.getException(), Toast.LENGTH_LONG).show();
                }

            }


        });












    }
}
