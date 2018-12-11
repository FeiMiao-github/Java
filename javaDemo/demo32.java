public class demo32 {
    public static void main(String[] args) {
        SpeedMeter s = new Moto();

        s.setTurnRate(100);
        System.out.println("speed: " + s.getSpeed());
    }
}

abstract class SpeedMeter {
    private double turnRate;

    public SpeedMeter() {
    };

    public void setTurnRate(double turnRate) {
        this.turnRate = turnRate;
    }

    public abstract double getRadius();

    public double getSpeed() {
        return this.turnRate * getRadius() * Math.PI * 2;
    }
}

class Moto extends SpeedMeter{
    private static final double radius = 0.28;

    @Override
    public double getRadius() {
        return Moto.radius;
    }
}