package Inheritance;
// Key Points
// Inheritance
// Base and derived classes
// Use of default constructor
//Base class

import java.util.Scanner;

class Vehicle {
    // Private Attributes
    /* Attributes → usually private
Methods → often public
For inheritance → use getters instead of protected variables */
    private int NumofDoors; // Instance Variable
    private double price;

    // default constructor
/* Default Constructor	Parameterized Constructor
No parameters	Has parameters
Fixed values	Custom values
Less flexible	More flexible
Good for basic objects	Good for real systems */
    public Vehicle() {
        System.out.print("creating a vehicle object using  default constructor");
        NumofDoors = 4;
        price = 1000;
    }
//parameterized constructor

    /* this.numOfDoors = numOfDoors;
    1️What is this?
    this is a special reference in Java.
    It refers to the current object — the object that is being created or used.
    It distinguishes instance variables from local variables/parameters that have the same name.
    this is required when parameter names are the same as attribute names.
    this can also be used to call other constructors:*/
//
    // Parameterized Constructor
    /* 'this' is used to distinguish instance variables from parameters */
//    public Vehicle(int NumofDoors, double price) {
//        System.out.println("Creating a vehicle object using parameterized constructor");
//        this.NumofDoors = NumofDoors;
//        this.price = price;
//    }
    public Vehicle(int nd, double pr) {
        System.out.println("creating a vehicle object using parameterized constructor");
        NumofDoors = nd;
        price = pr;
    }

    //Copy Constructor
    public Vehicle(Vehicle vec) {
        System.out.println("creating a vehicle object using copy constructor\n");
        NumofDoors = vec.NumofDoors;
        price = vec.price;
    }

    // Getters and setters
    // Constructor → sets initial attribute values when object is created.
    //Getter → reads the value of an attribute without changing it.
    //Setter → changes the value of an attribute safely.
    //This allows encapsulation: attributes stay private, external code interacts via getters/setters.
    public int getNumofDoors() {
        return NumofDoors;
    }

    public void setNumofDoors(int nd) {
        NumofDoors = nd;
        // Another way to write  this.NumofDoors = NumofDoors;
        //  this.NumofDoors = NumofDoors; --- if youre using just para constructor
    }

    public double getPrice() {
        return price;
    }

    final public void setPrice(double pr) {
        price = pr;
    }
    // Every class in Java inherits toString() from Object class.
    //By default, it prints something like ClassName@hashcode, which is not very readable.
    //Overriding toString() lets you customize how an object is displayed.
    public String toString() {
        return "This Vehicle has " + NumofDoors + " doors and " + price + "$";
    }
} // End of vehicle class

// Bus class - this is an derived class which inherits vehicle class
class bus extends Vehicle {
    private int passengercapacity;

    // Default constructor
    public bus() {
        System.out.print("creating a bus object using default constructor");
        passengercapacity = 4;
    }

    // parameterized constructor
    public bus(int pc) {
        System.out.print("creating a bus object using parameterized constructor");
        passengercapacity = pc;
    }

    // copy constructor
    public bus(bus b) {
        System.out.print("creating a bus object using copy constructor");
        passengercapacity = b.passengercapacity;
    }
    // A Constructor that would allow the setting of the price and number of the doors
    // and the passenger capacity
    public Bus(int nd,double pr,int pc)
    {
        this(pc); // calling the constructor that sets the value of the passenger capacity
        System.out.print("creating a bus object using parameterized constructor for full settings");
        // we cannot call supertto set the other two attributes
        // we cannot call super() and this() in the same thing, either of them should be in the first
        // statement and it is not possible to have both of them as such
        setPrice(pr);
        setNumofDoors(nd);
    }

    // Getters and Setters
    public int getPassengercapacity() {
        return passengercapacity;
    }

    public void setPassengercapacity(int pc) {
        passengercapacity = pc;
    }
    public String toString() {
        return "This Vehicle has " + passengercapacity + "$";
    }
    // Overriding the SetPrice() method /* Will become invalid becoz of final
//    public void setPrice(double pr) {
//        if(pr< getPrice())
//            System.out.println("The price of this bus will be reduced from"+ getPrice() + "$ to "+pr+ "$.");
//        else if (pr > getPrice())
//            System.out.println(" The price of this bus will be increased from"+ getPrice() + "$ to "+pr+ "$.");
//        else
//            System.out.println(" No change will be applied to this price of the bus");
//        super.setPrice(pr);
//
//    }
    public void setPrice() {
        Scanner  sc = new Scanner(System.in);
        double pr;
        System.out.println(" Please enter the price of the bus");
        pr=sc.nextDouble();
       if(pr< getPrice())
           System.out.println("The price of this bus will be reduced from"+ getPrice() + "$ to "+pr+ "$.");
        else if (pr > getPrice())
            System.out.println(" The price of this bus will be increased from"+ getPrice() + "$ to "+pr+ "$.");
        else
           System.out.println(" No change will be applied to this price of the bus");
        super.setPrice(pr);
    }

}
// Driver code

public class Inherit1 {
    public static void main(String[] args) {
        System.out.println(" Will create two vehicle object");
        Vehicle v1=new Vehicle(); // Calls the default constructor Prints whats inside the default constructor
        Vehicle v2= new Vehicle(4,5000); // calls the parameterized constructor and prints that
        System.out.println();
        System.out.println("Will create three bus object");
        bus b1=new bus(1);
        bus b2=new bus(2);
        bus b3=new bus(3);
        System.out.println();
        // Change the information of some of those bus objects
        b1.setNumofDoors(2);
        b1.setPrice(5500);
        b2.setNumofDoors(4);
        b2.setPrice(4500);
        b3.setNumofDoors(5);
        b3.setPrice(3500);
        b3.setPassengercapacity(6);
        System.out.println(" Here is the information of the first bus:\n" +b1 + "\n");
        System.out.println(" Here is the information of the second bus:\n" +b2 + "\n");
        System.out.println("Here is the information of the third bus: \n" +b3 + "\n");
    }
}


