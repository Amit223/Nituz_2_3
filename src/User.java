public class User {
    private static User ourInstance = new User();
    private static int  points=0;
    private static double speed=1;
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

    public int getPoints() {
        return points;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        User.speed = speed;
    }
}
