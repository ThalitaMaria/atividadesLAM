package com.example.alunos.androidtoolbar;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureNavigationDrawer();
        configureToolbar();
        Fragment f = new ViewItensFragment();
        FragmentTransaction transaction=
            getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, f);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void configureToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null){
            actionbar.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void configureNavigationDrawer(){
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem){
                    Fragment f = null;
                    int itemId = menuItem.getItemId();
                    if(itemId == R.id.action_new_item){
                        f = new AddItemsFragment();
                    } else if(itemId == R.id.action_view_items){
                        f = new ViewItensFragment();
                    } else if (itemId == R.id.settings){
                        f = new SettingsFragment();
                    }

                    if(f != null){
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame, f);
                        transaction.commit();
                        drawerLayout.closeDrawers();
                        return true;
                    }
                    return false;
            }
        });
    }
    @Override
        public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.empty_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){
            int itemId = item.getItemId();

            switch (itemId){
                case android.R.id.home:
                    drawerLayout.OpenDrawer(GravityCompat.START);
                    return true;
            }
            return true;
        }
}
