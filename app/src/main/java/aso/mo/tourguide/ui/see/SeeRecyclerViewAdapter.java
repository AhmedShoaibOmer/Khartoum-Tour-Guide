package aso.mo.tourguide.ui.see;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aso.mo.tourguide.OnItemClickListener;
import aso.mo.tourguide.Place;
import aso.mo.tourguide.R;

public class SeeRecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private final ArrayList<Place> mPlaces;
    private final OnItemClickListener onItemClickListener;

    public SeeRecyclerViewAdapter(ArrayList<Place> places, OnItemClickListener onItemClickListener) {
        this.mPlaces = places;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Place currentPlace = mPlaces.get(position);
        holder.setSong(currentPlace.getTitle(),
                currentPlace.getDescription(),
                currentPlace.getImageResId(),
                onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }
}