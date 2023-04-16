import java.util.LinkedList;

public class Account implements Comparable<Account> {
    private String name;
    private String description;
    private LinkedList<Post> posts;

    // list of posts
    /**
     * Account
     * 
     * @param n
     * @param d
     *
     */

    public Account(String n, String d) {
        name = n;
        description = d;
        posts = new LinkedList<Post>();

    }

    /**
     * getName
     * returns the name of the user's account
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * getDescription
     * returns the user's account description
     * 
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * getPosts
     * prints the title, video name and number of likes for all user's posts
     */

    public void getPosts() {

        for (int x = 0; x < posts.size(); x++) {

            System.out.println("Title " + posts.get(x).title);
            System.out.println("_______________________");
            System.out.println("Video: " + posts.get(x).video);
            System.out.println("_______________________");
            System.out.println("Number of likes: " + posts.get(x).likes);
        }

    }

    /**
     * compareTo
     * compares one account to another account
     * 
     * @param another
     * @return int
     */
    public int compareTo(Account another) {
        return name.toLowerCase().compareTo(another.name.toLowerCase());
    }

    /**
     * toString
     * 
     * @return String
     */

    public String toString() {
        return name + " " + description;

    }

    /**
     * addPost
     * adds a new post to the user's account
     * 
     * @param title
     * @param video
     * @param likes
     */
    public void addPost(String title, String video, int likes) {

        posts.add(new Post(title, video, likes));
    }

}
