package icoder.retrofit.uz.api.model;

public class Photo {
    private String id;
    private String url;
    private String thumb_url;
    private User user;
    private int res_id;
    private String caption;
    private int timestamp;
    private String friendly_time;
    private int width;
    private int height;

    public Photo(String id, String url, String thumb_url, User user, int res_id, String caption, int timestamp, String friendly_time, int width, int height) {
        this.id = id;
        this.url = url;
        this.thumb_url = thumb_url;
        this.user = user;
        this.res_id = res_id;
        this.caption = caption;
        this.timestamp = timestamp;
        this.friendly_time = friendly_time;
        this.width = width;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getFriendly_time() {
        return friendly_time;
    }

    public void setFriendly_time(String friendly_time) {
        this.friendly_time = friendly_time;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
