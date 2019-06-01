public class User {
    private static User ourInstance = new User();
    private static int  points=0;
    public static User getInstance() {
        return ourInstance;
    }

    private User() {
    }

    public void increasePoints(){
        this.points+=1;
    }

    public void deccreasePoints(){
        this.points-=1;
    }

    public static int getPoints() {
        return points;
    }
}
