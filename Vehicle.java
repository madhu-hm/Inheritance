package inheritance;

class Vehicles {
	String brand;
	String model;
	int speed;
	
	Vehicles(String brand,String model,int speed){
		this.brand=brand;
		this.model=model;
		this.speed=speed;
	}
	void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Speed: " + speed + " km/h");
    }
    void accelerate(int increase) {
        speed += increase;
        System.out.println(model + " accelerated to " + speed + " km/h");
    }
}
class FourWheelers extends Vehicles{
	FourWheelers(String brand,String model,int speed){
		super(brand,model,speed);
	}
}
class TwoWheelers extends Vehicles{
	TwoWheelers(String brand,String model,int speed){
		super(brand,model,speed);
	}
}
class Bike extends TwoWheelers{
	Bike(String brand,String model,int speed){
		super(brand,model,speed);
	}
}
class Car extends FourWheelers{
	Car(String brand,String model,int speed){
		super(brand,model,speed);
	}
}

public class Vehicle {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Corolla", 100);
        Bike myBike = new Bike("Yamaha", "R15", 80);

        System.out.println("Car Details:");
        myCar.displayInfo();
        myCar.accelerate(20);

        System.out.println("\nBike Details:");
        myBike.displayInfo();
        myBike.accelerate(15);
    }
}