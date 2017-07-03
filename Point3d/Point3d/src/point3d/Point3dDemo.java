package point3d;

public class Point3dDemo {

    public static void main(String[] args) {
        Point3dClass p3 = new Point3dClass(.3, .7, .9);
        
        System.out.println(p3.getX() + "," + p3.getY() + "," + p3.getZ());
        p3.setY(.4);
        p3.setZ(.6);
        System.out.println(p3.getX() + "," + p3.getY() + "," + p3.getZ());
    }

}
