package inheritance;

public class Shape {
	double Area() {
		return 0;
	}
	double Perimeter() {
		return 0;
	}

	public static void main(String[] args) {
		Shape obj1=new Circle(5);
		Shape obj2=new Rectangle(10,5);
		Shape obj3=new Triangle(10,4,2,3,4);
		
		System.out.println("Area of Circle: "+obj1.Area());
		System.out.println("Perimeter of Circle: "+obj1.Perimeter());
		
		System.out.println("Area of Rectangle: "+obj2.Area());
		System.out.println("Perimeter of Rectangle: "+obj2.Perimeter());
		
		System.out.println("Area of Triangle: "+obj3.Area());
		System.out.println("Perimeter of Triangle: "+obj3.Perimeter());

	}

}
class Rectangle extends Shape{
	private double length;
	private double breadth;
	
	
	Rectangle(double l,double b){
		this.length=l;
		this.breadth=b;
	}
	double Area() {
		return length*breadth;
	}
	double Perimeter() {
		return 2*(length+breadth);
	}
}
class Triangle extends Shape{
	private double height;
	private double base;
	int a,b,c;
		
		Triangle(double h,double bs,int a,int b,int c){
			this.height=h;
			this.base=bs;
			this.a=a;
			this.b=b;
			this.c=c;
		}
		double Area() {
			return 0.5*(height*base);
		}
		double Perimeter() {
			return a+b+c;
		}
}
class Circle extends Shape{
	private float radius;
	
	Circle(float r){
		this.radius=r;
	}
	double Area() {
		return Math.PI*radius*radius;
	}
	double Perimeter() {
		return 2*Math.PI*radius;
	}
}
