package point3d;

public class Point2dClass {

    private double x, y;

    public Point2dClass() {
        x = 0;
        y = 0;
    }

    public Point2dClass(double initx, double inity) {
        x = checkValue(initx);
        y = checkValue(inity);
    }

    protected double checkValue(double a) {
        if (a >= 0 && a <= 1.0) {
            return a;
        }
        return 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public void setX(double initX) {
        if (checkValue(initX) > 0)
            x = initX;
    }
    
    public void setY(double initY) {
        if (checkValue(initY) > 0)
            y = initY;
    }


}
