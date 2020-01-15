package icoder.retrofit.uz.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import icoder.retrofit.uz.R;
import icoder.retrofit.uz.api.model.Photo;
import icoder.retrofit.uz.api.model.Restaurant;
import icoder.retrofit.uz.service.ItemClickListener;

public class AdapterPhotos extends RecyclerView.Adapter<AdapterPhotos.PhotosViewHolder> {

    private Context context;
    private List<Restaurant.Photo> photos;
    private ItemClickListener itemClickListener;

    public AdapterPhotos(Context context, List<Restaurant.Photo> photos, ItemClickListener itemClickListener) {
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.photos = photos;
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotosViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_photo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosViewHolder holder, int position) {
        holder.onBind(photos.get(position).getPhoto(), holder);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class PhotosViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public PhotosViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imaage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onClick(view, getAdapterPosition());
                }
            });
        }

        public void onBind(Photo photo, PhotosViewHolder holder) {
            Picasso.get().load(photo.getThumb_url()).placeholder(R.drawable.ic_photo_camera).into(imageView);
        }
    }
}
