package com.example.latam.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latam.activities.airports.AirportsActivity;
import com.example.latam.models.Airport;
import com.example.pets.R;

import java.util.List;

public class AirportListAdapter extends RecyclerView.Adapter<AirportListAdapter.ViewHolder> {
    private Context context;
    private List<Airport> airports;

    public AirportListAdapter(Context context, List<Airport> airports) {
        this.context = context;
        this.airports = airports;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.airports_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AirportListAdapter.ViewHolder holder, int position) {
        holder.textInitials.setText(airports.get(position).getInitials());
        holder.textUf.setText(airports.get(position).getUf());
        holder.airportID = airports.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return airports.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int airportID;
        private TextView textInitials, textUf;
        private TextView textRole;
        private TextView textPhone;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textInitials = itemView.findViewById(R.id.textName);
            textUf = itemView.findViewById(R.id.textUf);

            TextView textDetails = itemView.findViewById(R.id.textDetails);
            TextView textEdit = itemView.findViewById(R.id.textEdit);
            TextView textRemove = itemView.findViewById(R.id.textRemove);

            textDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((AirportsActivity) context).show(view, airportID);
                }
            });

            textEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((AirportsActivity) context).edit(view, airportID);
                }
            });

            textRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((AirportsActivity) context).remove(view, airportID);
                }
            });
        }
    }
}
