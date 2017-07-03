package point3d;

public class Point3dClass extends Point2dClass {
    
    private double z;
    
    public Point3dClass() {
        super();
        z = 0;
    }
    
    public Point3dClass(double x, double y, double z) {
        super(x, y);
        this.z = this.checkValue(z);
    }
    
    public double getZ() {
        return z;
    }
    
    public void setZ(double initZ) {
        z = checkValue(initZ);
    }
    
}
