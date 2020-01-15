package icoder.retrofit.uz.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.AsyncTask;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import icoder.retrofit.uz.R;
import icoder.retrofit.uz.adapter.AdapterPhotos;
import icoder.retrofit.uz.adapter.AdapterReviews;
import icoder.retrofit.uz.api.model.Photo;
import icoder.retrofit.uz.api.model.Restaurant;
import icoder.retrofit.uz.api.service.ApiClient;
import icoder.retrofit.uz.api.service.RestaurantClient;
import icoder.retrofit.uz.service.ItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RestaurantActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView name, address, phone, highlights, ratingText, votes, time;
    private ImageView image, fav;
    private RatingBar rating;
    private AdapterPhotos adapterPhotos;
    private RecyclerView recyclerPhotos;
    private AdapterReviews adapterReviews;
    private RecyclerView recyclerReviews;
    private ShimmerFrameLayout mShimmerViewContainer;
    private NestedScrollView body;
    private TextView noPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        initComponents();
        initFunction();
        onLoad();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initFunction() {
        toolbar.setTitle(getIntent().getStringExtra("name"));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mShimmerViewContainer.startShimmerAnimation();
        body.setVisibility(View.GONE);
        mShimmerViewContainer.setVisibility(View.VISIBLE);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(fav.getTag()).equals("off")) {
                    fav.setImageResource(R.drawable.ic_favorite);
                    fav.setTag("on");
                    Toast.makeText(getApplicationContext(), "Created By iC0der", Toast.LENGTH_SHORT).show();
                } else {
                    fav.setImageResource(R.drawable.ic_favorite_border);
                    fav.setTag("off");
                }
            }
        });

        recyclerPhotos.setHasFixedSize(true);
        recyclerPhotos.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerReviews.setHasFixedSize(true);
        recyclerReviews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    private void initComponents() {
        toolbar = findViewById(R.id.toolbar);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        highlights = findViewById(R.id.highlights);
        ratingText = findViewById(R.id.rating_text);
        votes = findViewById(R.id.votes);
        image = findViewById(R.id.image);
        rating = findViewById(R.id.rating);
        recyclerPhotos = findViewById(R.id.recycler_photo);
        recyclerReviews = findViewById(R.id.recycler_review);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        noPhoto = findViewById(R.id.no_photo);

        body = findViewById(R.id.body);
        time = findViewById(R.id.time);
        fav = findViewById(R.id.fav);
    }

    private void onLoad() {
        Retrofit retrofit = ApiClient.getClient();
        RestaurantClient client = retrofit.create(RestaurantClient.class);
        Call<Restaurant> call = client.getRestaurant(getIntent().getStringExtra("id"));

        call.enqueue(new Callback<Restaurant>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                if (response.isSuccessful()) {
                    final Restaurant r = response.body();
                    mShimmerViewContainer.setVisibility(View.GONE);
                    mShimmerViewContainer.stopShimmerAnimation();
                    body.setVisibility(View.VISIBLE);
                    name.setText(r.getName());
                    address.setText(r.getLocation().getAddress());
                    phone.setText(r.getPhone_numbers());
                    time.setText(r.getTimings());
                    if (!r.getThumb().equals("") && r.getThumb() != null)
                        Picasso.get().load(r.getThumb()).into(image);
                    rating.setRating((float) Double.parseDouble(r.getUser_rating().getAggregate_rating()));
                    LayerDrawable stars = (LayerDrawable) rating.getProgressDrawable();
                    stars.getDrawable(2).setColorFilter(Color.parseColor("#" + r.getUser_rating().getRating_color()), PorterDuff.Mode.SRC_ATOP);
                    ratingText.setText(r.getUser_rating().getRating_text());
                    ratingText.setTextColor(Color.parseColor("#" + r.getUser_rating().getRating_color()));
                    votes.setText(r.getAll_reviews_count() + "");
                    highlights.setText("");
                    for (int i = 0; i < r.getHighlights().size(); i++)
                        highlights.setText(highlights.getText() + r.getHighlights().get(i) + (i + 1 == r.getHighlights().size() ? " " : ", "));

                    if (r.getPhotos() != null) {
                        adapterPhotos = new AdapterPhotos(getApplicationContext(), r.getPhotos(), new ItemClickListener() {
                            @Override
                            public void onClick(View view, int position) {
                                PhotoActivity.photos = new ArrayList<>();
                                PhotoActivity.photos.addAll(r.getPhotos());
                                Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
                                intent.putExtra("position", position);
                                startActivity(intent);
                            }
                        });
                        recyclerPhotos.setAdapter(adapterPhotos);
                    } else {
                        noPhoto.setVisibility(View.VISIBLE);
                    }
//                    if (r.getAll_reviews() != null) {
////                        adapterReviews = new AdapterReviews(getApplicationContext(), r.getAll_reviews().getReviews(), new ItemClickListener() {
////                            @Override
////                            public void onClick(View view, int position) {
////                                Toast.makeText(getApplicationContext(), "Created By iC0der", Toast.LENGTH_SHORT).show();
////                            }
////                        });
//                        recyclerReviews.setAdapter(adapterReviews);

                        Toast.makeText(getApplicationContext(), "Ushbu restaranga hali fikr bildirilmagan!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Internet bilan bog`liq muammo yuz berdi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
            }
        });
    }
}
