// public class OPPS {
//     public static void main(String[] args) {
//         Pen p1=new Pen();
//         p1.setColor ("Blue");
//         System.out.println(p1.color);
//         p1.setTip(5);
//         System.out.println(p1.tip);
//         p1.color="Green";
//         System.out.println(p1.color);
        
//     }
    
// }
// class Pen{
//     // proprties

//     String color;
//     int tip;

//     // function

//     void setColor(String newColor){
//         color=newColor;
//     }
//     void setTip(int newTip){
//         tip=newTip;
//     }

// }

class Automobile {
    protected String drive() {
        return "Driving vehicle";
    }
}

class Car extends Automobile {
    @Override
    protected String drive() {
        return "Driving car";
    }
}

class ElectricCar extends Car {
    @Override
    public final String drive() {
        return "Driving electric car";
    }
    public static void main(String[] wheels) {
        final Car car = new ElectricCar();
        System.out.print(car.drive());
    }
} 





