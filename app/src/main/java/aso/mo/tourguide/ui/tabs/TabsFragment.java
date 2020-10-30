package aso.mo.tourguide.ui.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import aso.mo.tourguide.R;

/**
 * Fragment with view pager and tab layout to hold more fragments.
 **/

public class TabsFragment extends Fragment {

    private final ArrayList<Integer> mTitles = new ArrayList<>();
    private final ArrayList<Fragment> mFragments = new ArrayList<>();

    public TabsFragment() {
        // Required empty public constructor
    }

    /**
     * Creates the fragment with the list of fragments and thier titles provided.
     *
     * @param listOfFragments the fragments to create.
     * @param listOfTitlesIDs the titles to appear on the tabs.
     * @return a fragment with tab layout and view pager.
     */
    public static Fragment newInstance(ArrayList<Fragment> listOfFragments, ArrayList<Integer> listOfTitlesIDs) {
        TabsFragment f = new TabsFragment();
        f.addFragments(listOfFragments, listOfTitlesIDs);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ytabs, container, false);

        // initialize the view pager adapter.
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(requireContext(), getChildFragmentManager());
        // add the fragments to the adapter.
        mViewPagerAdapter.addFragments(mFragments, mTitles);
        // attach the adapter to the view pager.
        ViewPager viewPager = v.findViewById(R.id.view_pager);
        viewPager.setAdapter(mViewPagerAdapter);
        // setup the tab layout with the view pager.
        TabLayout tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        return v;
    }


    /**
     * * Adding all the fragments to the view pager adapter
     *
     * @param fragments the of fragments to add.
     * @param titlesIDs the titles of the fragments at the same order.
     */
    private void addFragments(ArrayList<Fragment> fragments, ArrayList<Integer> titlesIDs) {
        this.mFragments.addAll(fragments);
        this.mTitles.addAll(titlesIDs);

    }
}