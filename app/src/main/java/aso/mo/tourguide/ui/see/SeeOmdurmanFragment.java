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

public class SeeOmdurmanFragment extends Fragment implements OnItemClickListener {

    private ArrayList<Place> mPlaces;

    public SeeOmdurmanFragment() {
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
        mPlaces.add(new Place(getString(R.string.souq_omdurman),
                getString(R.string.souq_omdurman_desc),
                R.drawable.souq_omdurman));
        mPlaces.add(new Place(getString(R.string.khalifas_house),
                getString(R.string.khalifas_house_desc),
                R.drawable.khalifas_house));
        mPlaces.add(new Place(getString(R.string.sufi_dancing),
                getString(R.string.sufi_dancing_desc),
                R.drawable.sufi_dancing));
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