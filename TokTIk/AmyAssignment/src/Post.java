
public class Post {
    String title;
    String video;
    int likes;

    /**
     * Post
     * 
     * 
     */

    public Post(String title, String video, int likes) {
        this.title = title;
        this.video = video;
        this.likes = likes;
    }

    /**
     * toString
     * returns the title, video name and number of likes of a post
     * 
     * @return String
     */
    public String toString() {
        return title + video + likes;
    }
}
