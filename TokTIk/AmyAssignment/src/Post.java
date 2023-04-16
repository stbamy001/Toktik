public class Post {
    String title;
    String video;
    int likes;

    public Post(String title, String video, int likes) {
        this.title = title;
        this.video = video;
        this.likes = likes;
    }

    public String toString() {
        return title + video + likes;
    }
}
