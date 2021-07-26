package com.example.latam.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latam.activities.clients.ClientsActivity;
import com.example.latam.models.Client;
import com.example.pets.R;

import java.util.List;

public class ClientListAdapter extends RecyclerView.Adapter<ClientListAdapter.ViewHolder> {
    private Context context;
    private List<Client> clients;

    public ClientListAdapter(Context context, List<Client> clients) {
        this.context = context;
        this.clients = clients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clients_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ClientListAdapter.ViewHolder holder, int position) {
        holder.textName.setText(clients.get(position).getFullName());
        holder.textID.setText(clients.get(position).getId().toString());
        holder.textEmail.setText(clients.get(position).getEmail());
        holder.clientID = clients.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int clientID;
        private TextView textName;
        private TextView textID;
        private TextView textEmail;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textID = itemView.findViewById(R.id.textID);
            textEmail = itemView.findViewById(R.id.textEmail);

            ImageButton imagePets = itemView.findViewById(R.id.imagePets);
            TextView textPets = itemView.findViewById(R.id.textHeader);
            ImageButton imageCalendar = itemView.findViewById(R.id.imageCalendar);
            TextView textCalendar = itemView.findViewById(R.id.textCalendar);

            imagePets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Label for Client id:" + clientID, Toast.LENGTH_LONG).show();
                    ((ClientsActivity) context).pets(view, clientID);
                }
            });

            textPets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Label for Client id:" + clientID, Toast.LENGTH_LONG).show();
                    ((ClientsActivity) context).pets(view, clientID);
                }
            });

            textCalendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Label for Client id:" + clientID, Toast.LENGTH_LONG).show();
                }
            });


            imageCalendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clicked on Icon for Client id:" + clientID, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
