package icoder.retrofit.uz.api.model;

import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private String url;
    private Location location;
    private int switch_to_order_menu;
    private String cuisines;
    private String timings;
    private int average_cost_for_two;
    private int price_range;
    private String currency;
    private List<String> highlights;
    private List<Object> offers;
    private int opentable_support;
    private int is_zomato_book_res;
    private String mezzo_provider;
    private int is_book_form_web_view;
    private String book_form_web_view_url;
    private String book_again_url;
    private String thumb;

    private UserRating user_rating;
    private int all_reviews_count;
    private String photos_url;
    private int photo_count;
    private List<Photo> photos;
    private String menu_url;
    private String featured_image;
    private int has_online_delivery;
    private int is_delivering_now;
    private boolean include_bogo_offers;
    private String deeplink;
    private int is_table_reservation_supported;
    private int has_table_booking;
    private String events_url;
    private String phone_numbers;
    //private AllReviews all_reviews;
    private List<String> establishment;

    public Restaurant(String id, String name, String url, Location location, int switch_to_order_menu, String cuisines, String timings, int average_cost_for_two, int price_range, String currency, List<String> highlights, List<Object> offers, int opentable_support, int is_zomato_book_res, String mezzo_provider, int is_book_form_web_view, String book_form_web_view_url, String book_again_url, String thumb, UserRating user_rating, int all_reviews_count, String photos_url, int photo_count, List<Photo> photos, String menu_url, String featured_image, int has_online_delivery, int is_delivering_now, boolean include_bogo_offers, String deeplink, int is_table_reservation_supported, int has_table_booking, String events_url, String phone_numbers, /*AllReviews all_reviews,*/ List<String> establishment) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.location = location;
        this.switch_to_order_menu = switch_to_order_menu;
        this.cuisines = cuisines;
        this.timings = timings;
        this.average_cost_for_two = average_cost_for_two;
        this.price_range = price_range;
        this.currency = currency;
        this.highlights = highlights;
        this.offers = offers;
        this.opentable_support = opentable_support;
        this.is_zomato_book_res = is_zomato_book_res;
        this.mezzo_provider = mezzo_provider;
        this.is_book_form_web_view = is_book_form_web_view;
        this.book_form_web_view_url = book_form_web_view_url;
        this.book_again_url = book_again_url;
        this.thumb = thumb;
        this.user_rating = user_rating;
        this.all_reviews_count = all_reviews_count;
        this.photos_url = photos_url;
        this.photo_count = photo_count;
        this.photos = photos;
        this.menu_url = menu_url;
        this.featured_image = featured_image;
        this.has_online_delivery = has_online_delivery;
        this.is_delivering_now = is_delivering_now;
        this.include_bogo_offers = include_bogo_offers;
        this.deeplink = deeplink;
        this.is_table_reservation_supported = is_table_reservation_supported;
        this.has_table_booking = has_table_booking;
        this.events_url = events_url;
        this.phone_numbers = phone_numbers;
//        this.all_reviews = all_reviews;
        this.establishment = establishment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getSwitch_to_order_menu() {
        return switch_to_order_menu;
    }

    public void setSwitch_to_order_menu(int switch_to_order_menu) {
        this.switch_to_order_menu = switch_to_order_menu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public int getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public void setAverage_cost_for_two(int average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public int getPrice_range() {
        return price_range;
    }

    public void setPrice_range(int price_range) {
        this.price_range = price_range;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    public int getOpentable_support() {
        return opentable_support;
    }

    public void setOpentable_support(int opentable_support) {
        this.opentable_support = opentable_support;
    }

    public int getIs_zomato_book_res() {
        return is_zomato_book_res;
    }

    public void setIs_zomato_book_res(int is_zomato_book_res) {
        this.is_zomato_book_res = is_zomato_book_res;
    }

    public String getMezzo_provider() {
        return mezzo_provider;
    }

    public void setMezzo_provider(String mezzo_provider) {
        this.mezzo_provider = mezzo_provider;
    }

    public int getIs_book_form_web_view() {
        return is_book_form_web_view;
    }

    public void setIs_book_form_web_view(int is_book_form_web_view) {
        this.is_book_form_web_view = is_book_form_web_view;
    }

    public String getBook_form_web_view_url() {
        return book_form_web_view_url;
    }

    public void setBook_form_web_view_url(String book_form_web_view_url) {
        this.book_form_web_view_url = book_form_web_view_url;
    }

    public String getBook_again_url() {
        return book_again_url;
    }

    public void setBook_again_url(String book_again_url) {
        this.book_again_url = book_again_url;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public UserRating getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(UserRating user_rating) {
        this.user_rating = user_rating;
    }

    public int getAll_reviews_count() {
        return all_reviews_count;
    }

    public void setAll_reviews_count(int all_reviews_count) {
        this.all_reviews_count = all_reviews_count;
    }

    public String getPhotos_url() {
        return photos_url;
    }

    public void setPhotos_url(String photos_url) {
        this.photos_url = photos_url;
    }

    public int getPhoto_count() {
        return photo_count;
    }

    public void setPhoto_count(int photo_count) {
        this.photo_count = photo_count;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public int getHas_online_delivery() {
        return has_online_delivery;
    }

    public void setHas_online_delivery(int has_online_delivery) {
        this.has_online_delivery = has_online_delivery;
    }

    public int getIs_delivering_now() {
        return is_delivering_now;
    }

    public void setIs_delivering_now(int is_delivering_now) {
        this.is_delivering_now = is_delivering_now;
    }

    public boolean isInclude_bogo_offers() {
        return include_bogo_offers;
    }

    public void setInclude_bogo_offers(boolean include_bogo_offers) {
        this.include_bogo_offers = include_bogo_offers;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public int getIs_table_reservation_supported() {
        return is_table_reservation_supported;
    }

    public void setIs_table_reservation_supported(int is_table_reservation_supported) {
        this.is_table_reservation_supported = is_table_reservation_supported;
    }

    public int getHas_table_booking() {
        return has_table_booking;
    }

    public void setHas_table_booking(int has_table_booking) {
        this.has_table_booking = has_table_booking;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(String phone_numbers) {
        this.phone_numbers = phone_numbers;
    }

//    public AllReviews getAll_reviews() {
//        return all_reviews;
//    }

//    public void setAll_reviews(AllReviews all_reviews) {
//        this.all_reviews = all_reviews;
//    }

    public List<String> getEstablishment() {
        return establishment;
    }

    public void setEstablishment(List<String> establishment) {
        this.establishment = establishment;
    }

    public class UserRating {
        private String aggregate_rating;
        private String rating_text;
        private String rating_color;
        private RatingObj rating_obj;
        private String votes;

        public UserRating(String aggregate_rating, String rating_text, String rating_color, RatingObj rating_obj, String votes) {
            this.aggregate_rating = aggregate_rating;
            this.rating_text = rating_text;
            this.rating_color = rating_color;
            this.rating_obj = rating_obj;
            this.votes = votes;
        }

        public String getAggregate_rating() {
            return aggregate_rating;
        }

        public void setAggregate_rating(String aggregate_rating) {
            this.aggregate_rating = aggregate_rating;
        }

        public String getRating_text() {
            return rating_text;
        }

        public void setRating_text(String rating_text) {
            this.rating_text = rating_text;
        }

        public String getRating_color() {
            return rating_color;
        }

        public void setRating_color(String rating_color) {
            this.rating_color = rating_color;
        }

        public RatingObj getRating_obj() {
            return rating_obj;
        }

        public void setRating_obj(RatingObj rating_obj) {
            this.rating_obj = rating_obj;
        }

        public String getVotes() {
            return votes;
        }

        public void setVotes(String votes) {
            this.votes = votes;
        }

        public class RatingObj {
            private Title title;
            private BgColor bg_color;

            public RatingObj(Title title, BgColor bg_color) {
                this.title = title;
                this.bg_color = bg_color;
            }

            public Title getTitle() {
                return title;
            }

            public void setTitle(Title title) {
                this.title = title;
            }

            public BgColor getBg_color() {
                return bg_color;
            }

            public void setBg_color(BgColor bg_color) {
                this.bg_color = bg_color;
            }

            public class Title {
                private String text;

                public Title(String text) {
                    this.text = text;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public class BgColor{
                private String type;
                private String tint;

                public BgColor(String type, String tint) {
                    this.type = type;
                    this.tint = tint;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getTint() {
                    return tint;
                }

                public void setTint(String tint) {
                    this.tint = tint;
                }
            }
        }
    }

    public class Photo{
        private icoder.retrofit.uz.api.model.Photo photo;

        public Photo(icoder.retrofit.uz.api.model.Photo photo) {
            this.photo = photo;
        }

        public icoder.retrofit.uz.api.model.Photo getPhoto() {
            return photo;
        }

        public void setPhoto(icoder.retrofit.uz.api.model.Photo photo) {
            this.photo = photo;
        }
    }

    public class AllReviews{

        private List<Review> reviews;

        public AllReviews(List<Review> reviews) {
            this.reviews = reviews;
        }

        public List<Review> getReviews() {
            return reviews;
        }

        public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
        }

        public class Review{
            private icoder.retrofit.uz.api.model.Review review;

            public Review(icoder.retrofit.uz.api.model.Review review) {
                this.review = review;
            }

            public icoder.retrofit.uz.api.model.Review getReview() {
                return review;
            }

            public void setReview(icoder.retrofit.uz.api.model.Review review) {
                this.review = review;
            }
        }
    }

}
