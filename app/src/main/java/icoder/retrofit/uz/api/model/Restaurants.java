package icoder.retrofit.uz.api.model;

import java.util.List;

public class Restaurants {

    private int results_found;
    private int results_shown;
    private List<Restaurantq> restaurants;

    public Restaurants(int results_found, int results_shown, List<Restaurantq> restaurants) {
        this.results_found = results_found;
        this.results_shown = results_shown;
        this.restaurants = restaurants;
    }

    public int getResults_found() {
        return results_found;
    }

    public void setResults_found(int results_found) {
        this.results_found = results_found;
    }

    public int getResults_shown() {
        return results_shown;
    }

    public void setResults_shown(int results_shown) {
        this.results_shown = results_shown;
    }

    public List<Restaurantq> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurantq> restaurants) {
        this.restaurants = restaurants;
    }

    public class Restaurantq {
        private icoder.retrofit.uz.api.model.Restaurant restaurant;

        public Restaurantq(icoder.retrofit.uz.api.model.Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        public icoder.retrofit.uz.api.model.Restaurant getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(icoder.retrofit.uz.api.model.Restaurant restaurant) {
            this.restaurant = restaurant;
        }
    }
}
