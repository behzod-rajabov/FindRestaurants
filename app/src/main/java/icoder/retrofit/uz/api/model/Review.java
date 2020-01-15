package icoder.retrofit.uz.api.model;

public class Review {
    private float rating;
    private String review_text;
    private int id;
    private String rating_color;
    private String review_time_friendly;
    private String rating_text;
    private int timestamp;
    private int likes;
    private User user;
    private int comments_count;

    public Review(float rating, String review_text, int id, String rating_color, String review_time_friendly, String rating_text, int timestamp, int likes, User user, int comments_count) {
        this.rating = rating;
        this.review_text = review_text;
        this.id = id;
        this.rating_color = rating_color;
        this.review_time_friendly = review_time_friendly;
        this.rating_text = rating_text;
        this.timestamp = timestamp;
        this.likes = likes;
        this.user = user;
        this.comments_count = comments_count;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRating_color() {
        return rating_color;
    }

    public void setRating_color(String rating_color) {
        this.rating_color = rating_color;
    }

    public String getReview_time_friendly() {
        return review_time_friendly;
    }

    public void setReview_time_friendly(String review_time_friendly) {
        this.review_time_friendly = review_time_friendly;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }
}
