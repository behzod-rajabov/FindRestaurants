package icoder.retrofit.uz.api.model;

public class User {
    private String name;
    private String zomato_handle;
    private String foodie_level;
    private int foodie_level_num;
    private String foodie_color;
    private String profile_url;
    private String profile_image;
    private String profile_deeplink;

    public User(String name, String zomato_handle, String foodie_level, int foodie_level_num, String foodie_color, String profile_url, String profile_image, String profile_deeplink) {
        this.name = name;
        this.zomato_handle = zomato_handle;
        this.foodie_level = foodie_level;
        this.foodie_level_num = foodie_level_num;
        this.foodie_color = foodie_color;
        this.profile_url = profile_url;
        this.profile_image = profile_image;
        this.profile_deeplink = profile_deeplink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZomato_handle() {
        return zomato_handle;
    }

    public void setZomato_handle(String zomato_handle) {
        this.zomato_handle = zomato_handle;
    }

    public String getFoodie_level() {
        return foodie_level;
    }

    public void setFoodie_level(String foodie_level) {
        this.foodie_level = foodie_level;
    }

    public int getFoodie_level_num() {
        return foodie_level_num;
    }

    public void setFoodie_level_num(int foodie_level_num) {
        this.foodie_level_num = foodie_level_num;
    }

    public String getFoodie_color() {
        return foodie_color;
    }

    public void setFoodie_color(String foodie_color) {
        this.foodie_color = foodie_color;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getProfile_deeplink() {
        return profile_deeplink;
    }

    public void setProfile_deeplink(String profile_deeplink) {
        this.profile_deeplink = profile_deeplink;
    }
}
