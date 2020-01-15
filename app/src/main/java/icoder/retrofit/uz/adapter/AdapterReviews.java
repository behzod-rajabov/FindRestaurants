package icoder.retrofit.uz.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import icoder.retrofit.uz.R;
import icoder.retrofit.uz.api.model.Restaurant;
import icoder.retrofit.uz.api.model.Review;
import icoder.retrofit.uz.service.ItemClickListener;

public class AdapterReviews extends RecyclerView.Adapter<AdapterReviews.ReviewsViewHolder> {

    private Context context;
    private List<Restaurant.AllReviews.Review> reviews;
    private ItemClickListener itemClickListener;

    public AdapterReviews(Context context, List<Restaurant.AllReviews.Review> reviews, ItemClickListener itemClickListener) {
        this.context = context;
        this.reviews = reviews;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ReviewsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_review, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsViewHolder reviewsViewHolder, int i) {
        reviewsViewHolder.onBind(reviews.get(i).getReview(), reviewsViewHolder, i);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    class ReviewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView userProfileImage;
        private TextView userName, time, rating_text, review_text;
        private RatingBar rating;

        ReviewsViewHolder(@NonNull final View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            userProfileImage = itemView.findViewById(R.id.user_profile_image);
            time = itemView.findViewById(R.id.review_time_friendly);
            rating_text = itemView.findViewById(R.id.rating_text);
            review_text = itemView.findViewById(R.id.review_text);
            rating = itemView.findViewById(R.id.rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(itemView, getAdapterPosition());
                }
            });
        }

        public void onBind(Review review, ReviewsViewHolder reviewsViewHolder, int i) {
            Picasso.get().load(review.getUser().getProfile_image()).placeholder(R.drawable.ic_person).into(userProfileImage);
            userName.setText(review.getUser().getName());
            time.setText(review.getReview_time_friendly());
            rating_text.setText(review.getRating_text());
            rating_text.setTextColor(Color.parseColor("#" + review.getRating_color()));
            rating.setRating(review.getRating());
            review_text.setText(review.getReview_text());

            LayerDrawable stars = (LayerDrawable) rating.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(Color.parseColor("#" + review.getRating_color()), PorterDuff.Mode.SRC_ATOP);
        }
    }
}
