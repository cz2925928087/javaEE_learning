package Design.Factory;

import java.util.concurrent.ThreadPoolExecutor;

//用工厂模式设计出:
//在一个平面上的一个点的位置
//1.用x,y坐标表示
//2.用r,α表示
class Point {

    public Point() {

    }

    public void set(){}
}
//Point的工厂类
class PointFactory {
    public static Point buildPointByXY(double x,double y) {
        Point p = new Point();
        //把x,y通过set一系列的方法设置进去
        p.set();
        return p;
    }

    public static Point buildPointByRA(double r,double a) {
        Point p = new Point();
        //把r,a通过set一系列方法设置进去
        p.set();
        return p;
    }
}

public class Demo1 {

}
