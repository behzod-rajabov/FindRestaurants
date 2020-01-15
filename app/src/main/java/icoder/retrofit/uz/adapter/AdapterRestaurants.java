package icoder.retrofit.uz.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import icoder.retrofit.uz.Parametrs;
import icoder.retrofit.uz.R;
import icoder.retrofit.uz.api.model.Restaurant;
import icoder.retrofit.uz.api.model.Restaurants;
import icoder.retrofit.uz.service.ItemClickListener;

public class AdapterRestaurants extends RecyclerView.Adapter<AdapterRestaurants.RestaurantsViewHolder> {

    private Context context;
    private List<Restaurants.Restaurantq> restaurants;
    private ItemClickListener itemClickListener;

    public AdapterRestaurants(Context context, List<Restaurants.Restaurantq> restaurants, ItemClickListener itemClickListener) {
        this.context = context;
        this.restaurants = restaurants;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public AdapterRestaurants.RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RestaurantsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((Parametrs.listType ? R.layout.layout_restaurant : R.layout.layout_restaurant_grid ), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRestaurants.RestaurantsViewHolder restaurantsViewHolder, int i) {
        restaurantsViewHolder.onBind(restaurants.get(i).getRestaurant(), restaurantsViewHolder, i);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class RestaurantsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, address, time, rating;
        CardView ratingLayout;

        public RestaurantsViewHolder(final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            time = itemView.findViewById(R.id.time);
            rating = itemView.findViewById(R.id.rating);
            ratingLayout = itemView.findViewById(R.id.rating_layout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(itemView, getAdapterPosition());
                }
            });
        }

        public void onBind(Restaurant restaurant, RestaurantsViewHolder restaurantsViewHolder, int i) {
            if (!restaurant.getThumb().equals("") && restaurant.getThumb() != null)
                Picasso.get().load(restaurant.getThumb()).placeholder(R.drawable.ic_photo_camera).into(image);
            name.setText(restaurant.getName());
            address.setText(restaurant.getLocation().getLocality_verbose());
            time.setText(restaurant.getTimings());
            rating.setText(restaurant.getUser_rating().getAggregate_rating());
            ratingLayout.setCardBackgroundColor(Color.parseColor("#" + restaurant.getUser_rating().getRating_color()));
        }
    }
}
