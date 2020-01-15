package icoder.retrofit.uz.adapter;

import android.annotation.SuppressLint;
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
import icoder.retrofit.uz.api.model.CityBody;
import icoder.retrofit.uz.service.ItemClickListener;

public class AdapterCitySearch extends RecyclerView.Adapter<AdapterCitySearch.CityViewHolder> {
    private Context context;
    private List<CityBody.City> cities;
    private ItemClickListener itemClickListener;

    public AdapterCitySearch(Context context, List<CityBody.City> cities, ItemClickListener itemClickListener) {
        this.context = context;
        this.cities = cities;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public AdapterCitySearch.CityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CityViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_city_search, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCitySearch.CityViewHolder cityViewHolder, int i) {
        cityViewHolder.onBind(cities.get(i));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {

        ImageView flag;
        TextView city;

        public CityViewHolder(@NonNull final View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.flag);
            city = itemView.findViewById(R.id.city);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(v, getAdapterPosition());
                }
            });
        }

        @SuppressLint("SetTextI18n")
        public void onBind(CityBody.City city) {
            Picasso.get().load(city.getCountry_flag_url()).placeholder(R.drawable.ic_photo_camera).into(flag);
            this.city.setText(city.getName() + ", " + city.getCountry_name());
        }
    }
}
