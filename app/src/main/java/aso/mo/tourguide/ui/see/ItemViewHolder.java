package aso.mo.tourguide.ui.see;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import aso.mo.tourguide.OnItemClickListener;
import aso.mo.tourguide.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView titleTV;
    private final TextView subtitleTV;
    private final ImageView imageIV;
    private final RelativeLayout container;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTV = itemView.findViewById(R.id.list_item_title);
        subtitleTV = itemView.findViewById(R.id.list_item_subtitle);
        imageIV = itemView.findViewById(R.id.list_item_image);
        container = itemView.findViewById(R.id.list_item_container);
    }

    public void setSong(String title, String subtitle, int imageResId, final OnItemClickListener listener) {
        titleTV.setText(title);
        subtitleTV.setText(subtitle);
        imageIV.setImageResource(imageResId);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(getAdapterPosition());
            }
        });
    }
}
