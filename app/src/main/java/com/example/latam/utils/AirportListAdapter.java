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
import com.example.latam.enums.Roles;
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
        holder.textName.setText(airports.get(position).getName());
        holder.textCategory.setText(Roles.stringfy(airports.get(position).getCategory()));
        holder.textPrice.setText(airports.get(position).toCurrency(airports.get(position).getPrice()));
        holder.AirportID = airports.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return airports.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int AirportID;
        private TextView textName;
        private TextView textCategory;
        private TextView textPrice;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textCategory = itemView.findViewById(R.id.textCategory);
            textPrice = itemView.findViewById(R.id.textPrice);

            TextView textDetails = itemView.findViewById(R.id.textDetails);
            TextView textEdit = itemView.findViewById(R.id.textEdit);
            TextView textRemove = itemView.findViewById(R.id.textRemove);

            textDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((AirportsActivity) context).show(view, AirportID);
                }
            });

            textEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((AirportsActivity) context).edit(view, AirportID);
                }
            });

            textRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((AirportsActivity) context).remove(view, AirportID);
                }
            });
        }
    }
}
