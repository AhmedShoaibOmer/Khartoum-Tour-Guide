package aso.mo.tourguide.ui.eat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aso.mo.tourguide.OnItemClickListener;
import aso.mo.tourguide.Place;
import aso.mo.tourguide.R;

public class EatRecyclerViewAdapter extends RecyclerView.Adapter<EatRecyclerViewAdapter.CardItemViewHolder> {
    private final ArrayList<Place> mPlaces;
    private final OnItemClickListener onItemClickListener;

    public EatRecyclerViewAdapter(ArrayList<Place> places, OnItemClickListener onItemClickListener) {
        this.mPlaces = places;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public CardItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card, parent, false);
        return new CardItemViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull CardItemViewHolder holder, int position) {
        final Place currentPlace = mPlaces.get(position);
        holder.setSong(currentPlace.getTitle(),
                currentPlace.getImageResId(),
                onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }

    public static class CardItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTV;
        private final ImageView imageIV;
        private final RelativeLayout container;

        public CardItemViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.list_item_title);
            imageIV = itemView.findViewById(R.id.list_item_image);
            container = itemView.findViewById(R.id.list_item_container);
        }

        public void setSong(String title, int imageResId, final OnItemClickListener listener) {
            titleTV.setText(title);
            imageIV.setImageResource(imageResId);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(getAdapterPosition());
                }
            });
        }
    }

}