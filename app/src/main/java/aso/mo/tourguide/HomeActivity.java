package aso.mo.tourguide;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

import aso.mo.tourguide.ui.cope.CopeFragment;
import aso.mo.tourguide.ui.drink.DrinkFragment;
import aso.mo.tourguide.ui.eat.EatFragment;
import aso.mo.tourguide.ui.getaround.GetAroundFragment;
import aso.mo.tourguide.ui.getin.GetInFragment;
import aso.mo.tourguide.ui.overview.OverviewFragment;
import aso.mo.tourguide.ui.see.SeeBahriFragment;
import aso.mo.tourguide.ui.see.SeeKhartoumFragment;
import aso.mo.tourguide.ui.see.SeeOmdurmanFragment;
import aso.mo.tourguide.ui.tabs.TabsFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private MaterialToolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Navigating to default fragment. overview fragment.
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        navigationView.setCheckedItem(R.id.nav_overview);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.action_night_mode) {
            // switching to/from night mode...
            //This is how to change the theme, we check if its night to switch to day or if
            //its day to switch to night.
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        //Setting the parent layout background to solid color..
//        mParentCoordinatorLayout.setBackgroundColor(getColor(R.color.backgroundColor));

        switch (item.getItemId()) {
            case R.id.nav_overview: {
                navigateToFragment(new OverviewFragment());
                //setting a specific background for the fragment.
//                mParentCoordinatorLayout.setBackground(getDrawable(R.drawable.overview_background));
                mToolbar.setTitle(R.string.overview);
                break;
            }
            case R.id.nav_get_in: {
                navigateToFragment(new GetInFragment());
                mToolbar.setTitle(R.string.get_in);
                break;
            }
            case R.id.nav_get_around: {
                navigateToFragment(new GetAroundFragment());
                mToolbar.setTitle(R.string.get_around);
                break;
            }
            case R.id.nav_see: {
                ArrayList<Fragment> fragments = new ArrayList<>();
                fragments.add(new SeeKhartoumFragment());
                fragments.add(new SeeOmdurmanFragment());
                fragments.add(new SeeBahriFragment());
                ArrayList<Integer> titlesIDs = new ArrayList<>();
                titlesIDs.add(R.string.khartoum);
                titlesIDs.add(R.string.omdurman);
                titlesIDs.add(R.string.bahri);
                navigateToFragment(TabsFragment.newInstance(fragments, titlesIDs));
                mToolbar.setTitle(R.string.see);
                break;
            }
            case R.id.nav_eat: {
                navigateToFragment(new EatFragment());
                mToolbar.setTitle(R.string.eat);
                break;
            }
            case R.id.nav_drink: {
                navigateToFragment(new DrinkFragment());
                mToolbar.setTitle(R.string.drink);
                break;
            }
            case R.id.nav_cope: {
                navigateToFragment(new CopeFragment());
                mToolbar.setTitle(R.string.cope);
                break;
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void navigateToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragments_container, fragment);
        ft.commit();
    }
}