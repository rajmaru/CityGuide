package com.one.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.one.cityguide.Categories.CategoriesAdapter;
import com.one.cityguide.Categories.CategoriesData;
import com.one.cityguide.FeaturedLocation.FeaturedAdapter;
import com.one.cityguide.FeaturedLocation.FeaturedData;
import com.one.cityguide.MostViewed.MostViewedAdapter;
import com.one.cityguide.MostViewed.MostViewedData;
import com.one.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {

    RecyclerView featured_recycler;
    RecyclerView mostViewed_recycler;
    RecyclerView categories_recycler;

    FeaturedAdapter featured_adapter;
    MostViewedAdapter mostViewed_adapter;
    CategoriesAdapter categories_adapter;

    ArrayList<FeaturedData> featuredDataList;
    ArrayList<MostViewedData> mostViewedDataList;
    ArrayList<CategoriesData> categoriesDataList;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        hooks();

        navigationDrawer();

        setFeaturedData();
        setMostViewedData();
        setCategoriesData();

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                }
                return true;
            }
        });
        navigationView.setCheckedItem(R.id.nav_home);
    }

    private void hooks() {
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
    }

    private void setFeaturedData() {
        featuredDataList = new ArrayList<>();
        featuredDataList.add(new FeaturedData(R.drawable.mc_donalds, "Mc Donald's", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        featuredDataList.add(new FeaturedData(R.drawable.kfc, "KFC", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        featuredDataList.add(new FeaturedData(R.drawable.dominos, "Dominos", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        featuredDataList.add(new FeaturedData(R.drawable.pizza_hut, "Pizza Hut", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        featuredDataList.add(new FeaturedData(R.drawable.mc_donalds, "Mc Donald's", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        featuredDataList.add(new FeaturedData(R.drawable.kfc, "KFC", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        featuredDataList.add(new FeaturedData(R.drawable.dominos, "Dominos", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        featuredDataList.add(new FeaturedData(R.drawable.pizza_hut, "Pizza Hut", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
    }

    private void setMostViewedData() {
        mostViewedDataList = new ArrayList<>();
        mostViewedDataList.add(new MostViewedData(R.drawable.mc_donalds, "Mc Donald's", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        mostViewedDataList.add(new MostViewedData(R.drawable.kfc, "KFC", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        mostViewedDataList.add(new MostViewedData(R.drawable.dominos, "Dominos", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        mostViewedDataList.add(new MostViewedData(R.drawable.pizza_hut, "Pizza Hut", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        mostViewedDataList.add(new MostViewedData(R.drawable.mc_donalds, "Mc Donald's", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        mostViewedDataList.add(new MostViewedData(R.drawable.kfc, "KFC", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        mostViewedDataList.add(new MostViewedData(R.drawable.dominos, "Dominos", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
        mostViewedDataList.add(new MostViewedData(R.drawable.pizza_hut, "Pizza Hut", "near Bhyanadar (East), Thane - 401105, Mumbai, sdgfs asrgrgedg, erab"));
    }

    private void setCategoriesData() {
        categoriesDataList = new ArrayList<>();
        categoriesDataList.add(new CategoriesData("Education", R.drawable.categories_education));
        categoriesDataList.add(new CategoriesData("Restaurant", R.drawable.categories_restaurant));
        categoriesDataList.add(new CategoriesData("Hotels", R.drawable.categories_hotel));
        categoriesDataList.add(new CategoriesData("Shops", R.drawable.categories_shop));
    }

    private void featuredRecycler() {
        featured_recycler = findViewById(R.id.featured_recycler);
        featured_adapter = new FeaturedAdapter(this, featuredDataList);
        featured_recycler.setAdapter(featured_adapter);
        featured_recycler.setHasFixedSize(true);
        featured_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void mostViewedRecycler() {
        mostViewed_recycler = findViewById(R.id.mostViewed_recycler);
        mostViewed_adapter = new MostViewedAdapter(this, mostViewedDataList);
        mostViewed_recycler.setAdapter(mostViewed_adapter);
        mostViewed_recycler.setHasFixedSize(true);
        mostViewed_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void categoriesRecycler() {
        categories_recycler = findViewById(R.id.categories_recycler);
        categories_adapter = new CategoriesAdapter(this, categoriesDataList);
        categories_recycler.setAdapter(categories_adapter);
        categories_recycler.setHasFixedSize(true);
        categories_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}