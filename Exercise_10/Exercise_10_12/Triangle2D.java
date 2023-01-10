import org.jetbrains.annotations.NotNull;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**********************************************************************
 *                           Triangle2D                                *
 *---------------------------------------------------------------------*
 * -p1, p2, p3: MyPoint                                                *
 * ____________________________________________________________________*
 * +Triangle()<<no-arg Constuctor>>                                    *
 * +Triangle(p1: MyPoint, p2: MyPoint, p3: MyPoint)  <<Constructor>>   *
 * +getP1() : MyPoint                                                  *
 * +getP2() : MyPoint                                                  *
 * +getP3() : MyPoint                                                  *
 * +setP1(p1 : MyPoint) : void                                         *
 * +setP2(p2 : MyPoint) : void                                         *
 * +setP3(p3 : MyPoint) : void                                         *
 * +contains(MyPoint p) : boolean                                      *
 * contains(Triangle2D t): boolean                                     *
 * +overlaps(Triangle2D t) : boolean                                   *
 * +getArea() : double                                                 *
 * +getPerimeter() : double                                            *
 **********************************************************************/
public class Triangle2D {
    // Data fields
    private  MyPoint p1, p2, p3;
    // no-arg constructor that creates default triangle with points :
    //p1 : (0, 0) , p2 : (1,1), p3 : (2, 5)
    public Triangle2D() {
        this.p1 = new MyPoint(0, 0);
        this.p2 = new MyPoint(1, 1);
        this.p3 = new MyPoint(2, 5);
    }

   // A constructor that creates a triangle with the specified points.
    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
   // getter and setter method for P1
    public MyPoint getP1() {
        return p1;
    }

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }
    // getter and setter method for P2

    public MyPoint getP2() {
        return p2;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }
    // getter and setter method for P3
    public MyPoint getP3() {
        return p3;
    }

    public void setP3(MyPoint p3) {
        this.p3 = p3;
    }
    //getPerimeter method calculate the Perimeter of the triangle
    public double getPerimeter(){
        return p1.distance(p2) + p1.distance(p3) + p2.distance(p3);
    }
    //getArea method calculate the Area of the Triangle
    // we can calculate the Area using this Formula
    //Area = sqrt(s*(s-p1p2)*(s-p1p3)*(s-p2p3))
    // where s is 1/2 of the perimeter

    public double getArea(){
        double s = this.getPerimeter();
        return Math.sqrt(s*(s-p1.distance(p2))*(s-p1.distance(p3))*(s-p2.distance(p3)));

    }
    // contains(MyPoint p) that returns true if the specified point
    //p is inside this triangle
    // 1.  calculate the Area of the Exercise_10_12 triangle 📐 that you want to check if point x in that triangle or not in the 📐
    // 2.  now from the point x we make 3 Triangles 📐 x=>p1p2, x=>p2p3, x=> p3p1
    // xp1p2, xp2p3, xp3p1
    //  if the Area of p1p2p3 == Area of xp1p2, xp2p3, xp3p1 combined the point in the triangle else it's not in the triangle
    // we got 3 triangle formed from this point to the triangle heads
    //                 P1
    //                / \
    //               /   \
    //              /     \
    //             /   x   \      x'
    //            /         \
    //          P2 ---------- p3
    public boolean contains(MyPoint x){
        // the questioned Triangle or the main Area
        double A = this.getArea();
        // let's make 3 triangles of point x and calculate the Area of each
        // xp1p2
        Triangle2D xt1 = new Triangle2D(x , p1,  p2);
        double xt1Area = xt1.getArea();
        //xp2p3
        Triangle2D xt2 = new Triangle2D(x , p2,  p3);
        double xt2Area = xt1.getArea();
        //xp3p1
        Triangle2D xt3 = new Triangle2D(x , p3,  p1);
        double xt3Area = xt1.getArea();


        return A == xt1Area + xt2Area + xt3Area;




    }
    //contains(Triangle2D t): boolean same but for a triangle
    // if the 3 heads of the triangle are contained by another triangle
    // we can say that the last one contains the fist triangle
    public boolean contains(@NotNull Triangle2D t){
       return contains(t.getP1()) && contains(t.getP2()) && contains(t.getP3());
    }
    public  boolean overlaps(Triangle2D t){
        Line2D line1 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY() ); // p1p2 of t📐
        Line2D line2 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p3.getX(), t.p3.getY() ); // p1p3 of t📐
        Line2D line3 = new Line2D.Double(t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY() ); // p2p3 of 📐
        Line2D line11 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY() ); // p1p2
        Line2D line22 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY()); // p1p3
        Line2D line33 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY()); // p2p3
        ArrayList<Line2D> orginalTriangle = new ArrayList<>();
        orginalTriangle.add(line11);
        orginalTriangle.add(line22);
        orginalTriangle.add(line33);
        ArrayList<Line2D> tri = new ArrayList<>();
        tri.add(line1);
        tri.add(line2);
        tri.add(line3);
        int countOfIntersections = 0;
       for(int i = 0; i < orginalTriangle.size(); i++){
           if (countOfIntersections >= 2)
             return true;
           for(int j = 0; j < tri.size(); j++){
               if (orginalTriangle.get(i).intersectsLine( tri.get(j) ) )
                   countOfIntersections++;

           }
       }
       return false;

    }
}

