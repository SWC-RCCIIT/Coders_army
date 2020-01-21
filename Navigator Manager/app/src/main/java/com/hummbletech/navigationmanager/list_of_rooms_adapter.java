package com.hummbletech.navigationmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Objects;

public class list_of_rooms_adapter extends RecyclerView.Adapter<list_of_rooms_adapter.listViewHolder> {

    private FirebaseFirestore firestore;
    private List<DocumentSnapshot> snapshot;
    private Context parent;

    list_of_rooms_adapter(Context context, List<DocumentSnapshot> data){
        parent = context;
        snapshot = data;
    }

    class listViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView base_title;

        public listViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_item_main);
            base_title = itemView.findViewById(R.id.text_base_main);

        }
    }
    @NonNull
    @Override
    public listViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_main_elements, parent, false);
        listViewHolder holder = new listViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull listViewHolder holder, int position) {
           DocumentSnapshot documentSnapshot = snapshot.get(position);
           holder.title.setText(documentSnapshot.get("na").toString());
           holder.base_title.setText(documentSnapshot.get("floor").toString());
    }

    @Override
    public int getItemCount() {
        return snapshot.size();
    }
}
