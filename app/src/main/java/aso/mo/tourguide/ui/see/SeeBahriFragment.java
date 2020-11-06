package aso.mo.tourguide.ui.see;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aso.mo.tourguide.OnItemClickListener;
import aso.mo.tourguide.Place;
import aso.mo.tourguide.R;
import aso.mo.tourguide.ui.DetailsActivity;

public class SeeBahriFragment extends Fragment implements OnItemClickListener {

    private ArrayList<Place> mPlaces;

    public SeeBahriFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.recycler_view_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Setting up the list of places
        addPlaces();

        //Setting up the Ui.
        SeeRecyclerViewAdapter mAdapter = new SeeRecyclerViewAdapter(mPlaces, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView placesRv = requireView().findViewById(R.id.recyclerView);
        placesRv.setLayoutManager(layoutManager);
        placesRv.setAdapter(mAdapter);
    }


    /**
     * Adding the places to the list...
     */
    private void addPlaces() {
        mPlaces = new ArrayList<>();
        mPlaces.add(new Place(getString(R.string.alshifaa_factory),
                getString(R.string.alshifaa_factory_desc),
                R.drawable.alshifa_factory));
        mPlaces.add(new Place(getString(R.string.nuba_wrestling),
                getString(R.string.nuba_wrestling_desc),
                R.drawable.nuba_wristling));
    }

    /**
     * Invoced when an item pressed.
     *
     * @param position The position of the item in the list.
     */
    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(requireActivity(), DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", mPlaces.get(position).getTitle());
        bundle.putString("description", mPlaces.get(position).getDescription());
        bundle.putInt("imageResID", mPlaces.get(position).getImageResId());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
