package exercise.ex09;

public class Point3D extends Point2D {

    private double z;

    public Point3D(double x, double y) {
        super(x, y);
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distance(Point3D point3D) {
        return Math.sqrt(Math.pow(getX() - point3D.getX(), 2) + Math.pow(getY() - point3D.getY(), 2) + Math.pow(getZ() - point3D.getZ(), 2));
    }
}
