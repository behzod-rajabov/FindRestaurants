package icoder.retrofit.uz.api.model;

import java.util.List;

public class CityBody {

    private List<City> location_suggestions;

    public CityBody(List<City> location_suggestions) {
        this.location_suggestions = location_suggestions;
    }

    public List<City> getLocation_suggestions() {
        return location_suggestions;
    }

    public void setLocation_suggestions(List<City> location_suggestions) {
        this.location_suggestions = location_suggestions;
    }

    public class City
    {
        private int id;
        private String name;
        private String country_name;
        private String country_flag_url;


        public City(int id, String name, String country_name, String country_flag_url) {
            this.id = id;
            this.name = name;
            this.country_name = country_name;
            this.country_flag_url = country_flag_url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public String getCountry_flag_url() {
            return country_flag_url;
        }

        public void setCountry_flag_url(String country_flag_url) {
            this.country_flag_url = country_flag_url;
        }
    }
}
