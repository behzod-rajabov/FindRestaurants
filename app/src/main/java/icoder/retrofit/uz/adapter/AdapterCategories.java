package icoder.retrofit.uz.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import icoder.retrofit.uz.R;
import icoder.retrofit.uz.api.model.Category;
import icoder.retrofit.uz.service.ItemClickListener;

public class AdapterCategories extends RecyclerView.Adapter<AdapterCategories.CategoriesViewHolder> {
    private Context context;
    private List<Category.Categories> categories;
    private ItemClickListener itemClickListener;

    public AdapterCategories(Context context, List<Category.Categories> categories, ItemClickListener itemClickListener) {
        this.context = context;
        this.categories = categories;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public AdapterCategories.CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CategoriesViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_category, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCategories.CategoriesViewHolder viewHolder, int i) {
        viewHolder.onBind(categories.get(i).getCategories());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(v, getAdapterPosition());
                }
            });
        }

        public void onBind(Category.Categories.CategoryData categories) {
            Picasso.get().load(
                    "https://b.zmtcdn.com/images/search_tokens/app_icons/category_" +
                            (categories.getId() == 4 ? 14 : categories.getId())
                            + ".png").placeholder(R.drawable.ic_photo_camera)
                    .into(image);
            name.setText(categories.getName());

        }
    }
}
