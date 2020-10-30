package aso.mo.tourguide.ui.tabs;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> mFragments = new ArrayList<>();

    private final ArrayList<Integer> mTabTitles = new ArrayList<>();

    private final Context mContext;

    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        return mFragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(mTabTitles.get(position));
    }

    @Override
    public int getCount() {
        // Show total pages.
        return mFragments.size();
    }

    /**
     * Adds a fragment and its title to the voew pager adapter.
     *
     * @param fragment a fragment to be added.
     * @param tabTitle the string resource id for the title that appears in the  tab layout.
     */
    public void addFragments(ArrayList<Fragment> fragment, ArrayList<Integer> tabTitle) {
        mFragments.addAll(fragment);
        mTabTitles.addAll(tabTitle);
    }
}