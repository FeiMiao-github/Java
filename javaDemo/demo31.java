// 定义一个抽象类

abstract class Shape {
    {
        System.out.println("执行初始化代码块");
    }

    static {
        System.out.println("执行初始化代码块");
    }
    protected abstract double calPerimeter();

    protected abstract String getType();

    private String color;

    public Shape() {
        System.out.println("执行构造器");
    };

    public Shape(String color) {
        System.out.println("执行构造器");
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}

class Triangle extends Shape {
    private double a = 0;
    private double b = 0;
    private double c = 0;

    public Triangle(String color, double a, double b, double c) {
        super(color);
        setSides(a, b, c);
    }

    public void setSides(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= b + a) {
            System.out.println("三角形两边之和大于第三边");
            return;
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calPerimeter() {
        return a + b + c;
    }

    @Override
    public String getType() {
        return "三角形";
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        setRadius(radius);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String getType() {
        return "圆";
    }

    @Override
    public double calPerimeter() {
        return Math.PI * 2 * radius;
    }
}
public class demo31 {
    public static void main(String[] args) {
        Shape[] s = new Shape[2];
        s[0] = new Circle("绿色", 5);
        s[1] =  new Triangle("白色", 1, 2, 3);
        for (Shape eleShape : s) {
            System.out.println("---------------------------");
            System.out.println("形状: " + eleShape.getType()
                + "\n周长: " + eleShape.calPerimeter()
                + "\n颜色：" + eleShape.getColor());
        }
    }
}