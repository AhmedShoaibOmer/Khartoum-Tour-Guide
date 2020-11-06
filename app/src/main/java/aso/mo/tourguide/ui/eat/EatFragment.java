package aso.mo.tourguide.ui.eat;

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

public class EatFragment extends Fragment implements OnItemClickListener {
    private ArrayList<Place> mPlaces;

    public EatFragment() {
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
        EatRecyclerViewAdapter mAdapter = new EatRecyclerViewAdapter(mPlaces, this);

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
        mPlaces.add(new Place(getString(R.string.universal),
                getString(R.string.universal_desc),
                R.drawable.universal_cafe));
        mPlaces.add(new Place(getString(R.string.solitaire),
                getString(R.string.solitaire_desc),
                R.drawable.solitaire_res));
        mPlaces.add(new Place(getString(R.string.mataam_alshaabi),
                getString(R.string.mataam_alshaabi_desc),
                R.drawable.mataam_alshaabi));
        mPlaces.add(new Place(getString(R.string.amwaj_resturant),
                getString(R.string.amwaj_resturant_desc),
                R.drawable.amwaj_res));
        mPlaces.add(new Place(getString(R.string.royal_broast),
                getString(R.string.royal_broast_desc),
                R.drawable.royal_broast));
        mPlaces.add(new Place(getString(R.string.laziz_res),
                getString(R.string.laziz_res_desc),
                R.drawable.laziz_res));
        mPlaces.add(new Place(getString(R.string.afraa_mall_res),
                getString(R.string.afraa_mall_res_desc),
                R.drawable.afraa_mall));
        mPlaces.add(new Place(getString(R.string.assaha_res),
                getString(R.string.assaha_res_desc),
                R.drawable.assaha_res));
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