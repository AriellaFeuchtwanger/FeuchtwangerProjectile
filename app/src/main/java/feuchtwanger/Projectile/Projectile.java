package feuchtwanger.Projectile;

public class Projectile {

    private double time;
    private final double velocity;
    private final double radians;

    public Projectile(double angle, double velocity, double seconds) {
        radians = Math.toRadians(angle);
        this.time = seconds;
        this.velocity = velocity;
    }

    public double getX() {
        return ((Math.sin(radians)) * velocity * time);
    }

    public double getY() {
        return (((Math.cos(radians)) * velocity * time) - (0.5 * 9.8 * time * time));
    }

    public void setTime() {
        time += 0.1;
    }
}
