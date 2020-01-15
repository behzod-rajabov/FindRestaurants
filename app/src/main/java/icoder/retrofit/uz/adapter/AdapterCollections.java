package icoder.retrofit.uz.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import icoder.retrofit.uz.R;
import icoder.retrofit.uz.api.model.Collection;
import icoder.retrofit.uz.service.ItemClickListener;

public class AdapterCollections extends RecyclerView.Adapter<AdapterCollections.CollectionsViewHolder> {
    private Context context;
    private List<Collection.CollectionClass> collections;
    private ItemClickListener itemClickListener;

    public AdapterCollections(Context context, List<Collection.CollectionClass> collections, ItemClickListener itemClickListener) {
        this.context = context;
        this.collections = collections;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CollectionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CollectionsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_collection, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsViewHolder collectionsViewHolder, int i) {
        collectionsViewHolder.onBind(collections.get(i).getCollection());
    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    class CollectionsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, description;
        CollectionsViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.desc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(v, getAdapterPosition());
                }
            });
        }

        @SuppressLint("SetTextI18n")
        void onBind(Collection.CollectionClass.CollectionData collection) {
            name.setText(collection.getTitle());
            description.setText(collection.getDescription() + ". " + collection.getRes_count() + " restaurants.");
            Picasso.get().load(collection.getImage_url()).placeholder(R.drawable.ic_photo_camera).into(image);
        }
    }
}
