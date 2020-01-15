package icoder.retrofit.uz.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import icoder.retrofit.uz.Parametrs;
import icoder.retrofit.uz.R;
import icoder.retrofit.uz.adapter.AdapterCategories;
import icoder.retrofit.uz.adapter.AdapterCitySearch;
import icoder.retrofit.uz.adapter.AdapterCollections;
import icoder.retrofit.uz.adapter.AdapterRestaurants;
import icoder.retrofit.uz.api.model.Category;
import icoder.retrofit.uz.api.model.CityBody;
import icoder.retrofit.uz.api.model.Collection;
import icoder.retrofit.uz.api.model.Restaurants;
import icoder.retrofit.uz.api.service.ApiClient;
import icoder.retrofit.uz.api.service.RestaurantClient;
import icoder.retrofit.uz.service.ItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerCollections;
    private AdapterCollections adapterCollections;
    private List<Collection.CollectionClass> collections;
    private List<Category.Categories> categories;
    private List<Restaurants.Restaurantq> restaurants;
    private List<CityBody.City> cities;
    private RecyclerView recyclerCategories;
    private AdapterCategories adapterCategories;
    private BottomSheetDialog bottomSheetDialog;
    private View sheetView;
    private ImageView location;
    private EditText editTextCity;
    private RecyclerView recyclerCities;
    private AdapterCitySearch adapterCitySearch;
    private LinearLayout layoutCollections;
    private RecyclerView recyclerRestaurants;
    private AdapterRestaurants adapterRestaurants;
    private int cityId = 2;
    private Retrofit retrofit;
    private RestaurantClient client;
    private ShimmerFrameLayout mShimmerViewContainer;
    private NestedScrollView body;
    private LinearLayout layoutNoConnection;
    private Button tryAgain;
    private Toolbar toolbar;
    private TextView telegram;
    private DrawerLayout drawerLayout;
    private int start = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        initFunctions();
        onLoad();
    }

    private void onLoad() {
        collections.clear();
        categories.clear();
        restaurants.clear();
        body.setVisibility(View.INVISIBLE);
        layoutNoConnection.setVisibility(View.INVISIBLE);
        mShimmerViewContainer.startShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.VISIBLE);
        Call<Collection> call = client.getCollections(cityId);
        call.enqueue(new Callback<Collection>() {
            @Override
            public void onResponse(Call<Collection> call, final Response<Collection> response) {
                if (response.body().getCollections() != null) {
                    collections.addAll(response.body().getCollections());
                    adapterCollections.notifyDataSetChanged();
                    Log.d("TAGGG", "Collection");
                } else {
                    layoutCollections.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<Collection> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Internet bilan bog`liq muammo yuz berdi!", Toast.LENGTH_SHORT).show();
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
                layoutNoConnection.setVisibility(View.VISIBLE);
                Log.d("ErrorCollections", t.getMessage());
            }
        });

        Call<Category> call2 = client.getCategories(cityId);
        call2.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call2, final Response<Category> response2) {
                categories.addAll(response2.body().getCategories());
                adapterCategories.notifyDataSetChanged();
                Log.d("TAGGG", "Categories");
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Internet bilan bog`liq muammo yuz berdi!", Toast.LENGTH_SHORT).show();
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
                layoutNoConnection.setVisibility(View.VISIBLE);
                Log.d("ErrorCategory", t.getMessage());
            }
        });

        Call<Restaurants> call3 = client.getRestaurants(0, 0, cityId, "city", start);
        call3.enqueue(new Callback<Restaurants>() {
            @Override
            public void onResponse(Call<Restaurants> call, final Response<Restaurants> response) {
                restaurants.addAll(response.body().getRestaurants());
                adapterRestaurants.notifyDataSetChanged();
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
                body.setVisibility(View.VISIBLE);
                Log.d("TAGGG", "Restaurants");
            }

            @Override
            public void onFailure(Call<Restaurants> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Internet bilan bog`liq muammo yuz berdi!", Toast.LENGTH_SHORT).show();
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
                layoutNoConnection.setVisibility(View.VISIBLE);
                Log.d("ErrorRestaurant", t.getMessage());
            }
        });
    }


    private void initFunctions() {
        body.setVisibility(View.INVISIBLE);
        layoutNoConnection.setVisibility(View.GONE);
        mShimmerViewContainer.startShimmerAnimation();
        setSupportActionBar(toolbar);
        toolbar.setTitle("Kolkata, Belghoria");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
                editTextCity.requestFocus();
                editTextCity.setText("");
                cities.clear();
                adapterCitySearch.notifyDataSetChanged();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editTextCity, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        retrofit = ApiClient.getClient();
        client = retrofit.create(RestaurantClient.class);

        collections = new ArrayList<>();
        recyclerCollections.setHasFixedSize(true);
        recyclerCollections.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL));
        adapterCollections = new AdapterCollections(getApplicationContext(), collections, new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class);
                intent.putExtra("title", collections.get(position).getCollection().getTitle());
                intent.putExtra("category_id", 0);
                intent.putExtra("collection_id", collections.get(position).getCollection().getCollection_id());
                intent.putExtra("city_id", cityId);
                startActivity(intent);
            }
        });
        recyclerCollections.setAdapter(adapterCollections);

        categories = new ArrayList<>();
        recyclerCategories.setHasFixedSize(true);
        recyclerCategories.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        adapterCategories = new AdapterCategories(getApplicationContext(), categories, new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class);
                intent.putExtra("title", categories.get(position).getCategories().getName());
                intent.putExtra("category_id", categories.get(position).getCategories().getId());
                intent.putExtra("collection_id", 0);
                intent.putExtra("city_id", cityId);
                startActivity(intent);
            }
        });
        recyclerCategories.setAdapter(adapterCategories);

        restaurants = new ArrayList<>();
        recyclerRestaurants.setHasFixedSize(true);
        if (Parametrs.listType)
            recyclerRestaurants.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        else
            recyclerRestaurants.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        adapterRestaurants = new AdapterRestaurants(getApplicationContext(), restaurants, new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                intent.putExtra("id", restaurants.get(position).getRestaurant().getId());
                intent.putExtra("name", restaurants.get(position).getRestaurant().getName());
                startActivity(intent);
            }
        });
        recyclerRestaurants.setAdapter(adapterRestaurants);

        cities = new ArrayList<>();
        recyclerCities.setHasFixedSize(true);
        recyclerCities.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        adapterCitySearch = new AdapterCitySearch(getApplicationContext(), cities, new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "Selected " + cities.get(position).getName(), Toast.LENGTH_SHORT).show();
                cityId = cities.get(position).getId();
                onLoad();
                toolbar.setTitle(cities.get(position).getName() + ", " + cities.get(position).getCountry_name());
                bottomSheetDialog.dismiss();
            }
        });
        recyclerCities.setAdapter(adapterCitySearch);

        bottomSheetDialog = new BottomSheetDialog(this, R.style.RounderBottomSheetDialogTheme);
        bottomSheetDialog.setContentView(sheetView);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
                editTextCity.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editTextCity, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoad();
            }
        });
        editTextCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //editTextCity.setText(editTextCity.getText().toString().trim());
                if (editTextCity.getText().length() > 0) {
                    onLoadCities(editTextCity.getText().toString());
                }
            }
        });

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/iC0der"));
                startActivity(browserIntent);
            }
        });
    }

    private void onLoadCities(final String city) {
        Call<CityBody> call = client.getCities(city);
        call.enqueue(new Callback<CityBody>() {
            @Override
            public void onResponse(Call<CityBody> call, final Response<CityBody> response) {
                assert response.body() != null;
                cities.addAll(response.body().getLocation_suggestions());
                adapterCitySearch.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CityBody> call, Throwable t) {

            }
        });
    }

    private void initComponents() {
        toolbar = findViewById(R.id.toolbar);
        recyclerCollections = findViewById(R.id.recycler_collection);
        recyclerCategories = findViewById(R.id.recycler_category);
        recyclerRestaurants = findViewById(R.id.recycler_restaurants);
        location = findViewById(R.id.location);
        layoutCollections = findViewById(R.id.layout_collection);
        sheetView = this.getLayoutInflater().inflate(R.layout.layout_bottomsheet_mainactivity, null);
        recyclerCities = sheetView.findViewById(R.id.recycler_city);
        editTextCity = sheetView.findViewById(R.id.edit_text_city);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        body = findViewById(R.id.body);
        layoutNoConnection = findViewById(R.id.layout_no_connection);
        tryAgain = findViewById(R.id.try_again);
        telegram = findViewById(R.id.ic0der);
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
