package com.bshtef.hookah.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bshtef.hookah.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private Fragment currentFragment;

    //region ******************** OVERRIDE *********************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initMenu();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawer.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //endregion OVERRIDE

    //region ******************** INIT *************************************************************

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initMenu() {
        NavigationView navigationView = findViewById(R.id.nvView);
        drawer = findViewById(R.id.drawer);

        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) { }
            @Override
            public void onDrawerOpened(@NonNull View drawerView) { }
            @Override
            public void onDrawerClosed(@NonNull View drawerView) { updateFragment(); }
            @Override
            public void onDrawerStateChanged(int newState) { }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        drawer.addDrawerListener(drawerToggle);

        navigationView.setItemIconTintList(null);

        initDrawerContent(navigationView);
        initStartFragment(navigationView);
    }

    private void initDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
            menuItem -> {
                selectDrawerItem(menuItem);
                return true;
            });
    }

    private void initStartFragment(NavigationView navigationView){
        selectDrawerItem(navigationView.getMenu().getItem(0));
        currentFragment = new FragmentHookahList();
        updateFragment();
    }

    //endregion INIT

    //region ******************** HELPERS **********************************************************

    public void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.menuAuthor: currentFragment = new FragmentAuthor(); break;
            case R.id.menuFeedback: currentFragment = new FragmentFeedback(); break;
            case R.id.menuOrders: currentFragment = new FragmentMyOrders(); break;
            default: currentFragment = new FragmentHookahList(); break;
        }
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        drawer.closeDrawers();
    }

    private void updateFragment(){
        if (currentFragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content, currentFragment).commit();
        }
        currentFragment = null;
    }

    //endregion HELPERS

}
