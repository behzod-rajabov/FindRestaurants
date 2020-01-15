package icoder.retrofit.uz.api.service;

import java.util.List;

import icoder.retrofit.uz.api.model.Category;
import icoder.retrofit.uz.api.model.CityBody;
import icoder.retrofit.uz.api.model.Collection;
import icoder.retrofit.uz.api.model.Restaurant;
import icoder.retrofit.uz.api.model.Restaurants;
import kotlin.ParameterName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestaurantClient {

    @GET("restaurant")
    Call<Restaurant> getRestaurant(@Query("res_id") String id);

    @GET("search")
    Call<Restaurants> getRestaurants(
            @Query("collection_id") int collectionsId,
            @Query("category") int categoryId,
            @Query("entity_id")  int cityId,
            @Query("entity_type") String entityType,
            @Query("start") int start);

    @GET("collections")
    Call<Collection> getCollections(@Query("city_id") int cityId);

    @GET("categories")
    Call<Category> getCategories(@Query("city_id") int cityId);

    @GET("cities")
    Call<CityBody> getCities(@Query("q") String city);

}
