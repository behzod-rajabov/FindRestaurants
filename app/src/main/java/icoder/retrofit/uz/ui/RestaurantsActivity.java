package icoder.retrofit.uz.ui;

import android.content.Intent;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import icoder.retrofit.uz.Parametrs;
import icoder.retrofit.uz.R;
import icoder.retrofit.uz.adapter.AdapterRestaurants;
import icoder.retrofit.uz.api.model.Restaurants;
import icoder.retrofit.uz.api.service.ApiClient;
import icoder.retrofit.uz.api.service.RestaurantClient;
import icoder.retrofit.uz.service.ItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RestaurantsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerRestaurants;
    private AdapterRestaurants adapterRestaurants;
    private List<Restaurants.Restaurantq> restaurants;
    private ImageView listType, filter;
    private ShimmerFrameLayout mShimmerViewContainer;
    private int start = 0;
    private int resultFound = 999;
    private Button showAgain;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        initComponents();
        initFunctions();
        onLoad();
    }

    private void onLoad() {
        Retrofit retrofit = ApiClient.getClient();
        RestaurantClient client = retrofit.create(RestaurantClient.class);
        Call<Restaurants> call = client.getRestaurants(
                getIntent().getIntExtra("collection_id", 0),
                getIntent().getIntExtra("category_id", 0),
                getIntent().getIntExtra("city_id", 0),
                "city",
                start);
        call.enqueue(new Callback<Restaurants>() {
            @Override
            public void onResponse(Call<Restaurants> call, final Response<Restaurants> response) {
                assert response.body() != null;
                restaurants.addAll(response.body().getRestaurants());
                if (response.body().getResults_found() != response.body().getResults_shown())
                    showAgain.setVisibility(View.VISIBLE);
                adapterRestaurants.notifyDataSetChanged();
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
            }

            @Override
            public void onFailure(Call<Restaurants> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Internet bilan xatolik yuz berdi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
            }
        });
    }

    private void initFunctions() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(getIntent().getStringExtra("title"));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Created By iC0der", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        mShimmerViewContainer.startShimmerAnimation();
        restaurants = new ArrayList<>();
        recyclerRestaurants.setHasFixedSize(true);
        if (Parametrs.listType) {
            recyclerRestaurants.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        } else {
            recyclerRestaurants.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        }
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
        listType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Parametrs.listType) {
                    recyclerRestaurants.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                    Parametrs.listType = false;
                    recyclerRestaurants.setAdapter(adapterRestaurants);
                    listType.setImageResource(R.drawable.ic_grid);
                } else {
                    recyclerRestaurants.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                    Parametrs.listType = true;
                    recyclerRestaurants.setAdapter(adapterRestaurants);
                    listType.setImageResource(R.drawable.ic_format_list);
                }
            }
        });
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Created By iC0der", Toast.LENGTH_SHORT).show();
            }
        });
        showAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAgainRestaurant();
            }
        });
    }

    private void initComponents() {
        toolbar = findViewById(R.id.toolbar);
        recyclerRestaurants = findViewById(R.id.recycler_restaurant);
        listType = findViewById(R.id.list_type);
        filter = findViewById(R.id.filter);
        showAgain = findViewById(R.id.show_again);
        progress = findViewById(R.id.progress);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
    }

    private void showAgainRestaurant() {
        showAgain.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        start += 20;
        Retrofit retrofit = ApiClient.getClient();
        RestaurantClient client = retrofit.create(RestaurantClient.class);
        Call<Restaurants> call = client.getRestaurants(
                getIntent().getIntExtra("collection_id", 0),
                getIntent().getIntExtra("category_id", 0),
                getIntent().getIntExtra("city_id", 0),
                "city",
                start);
        call.enqueue(new Callback<Restaurants>() {
            @Override
            public void onResponse(Call<Restaurants> call, final Response<Restaurants> response) {
                assert response.body() != null;
                restaurants.addAll(response.body().getRestaurants());
                if (response.body().getRestaurants().size() != 0)
                    showAgain.setVisibility(View.VISIBLE);
                progress.setVisibility(View.GONE);
                adapterRestaurants.notifyDataSetChanged();
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
            }

            @Override
            public void onFailure(Call<Restaurants> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Internet bilan xatolik yuz berdi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
                showAgain.setVisibility(View.VISIBLE);
                progress.setVisibility(View.GONE);
            }
        });
    }
}
