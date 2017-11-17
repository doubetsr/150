package Lab2;//package Lab2Start;
/**
 * TestCar
 *
 * Tests the Car object class by
 * simulating three cars driving home and back to school.
 *
 * @author Dr. Sherri Harms
 * @author Sam Doubet
 */
public class TestCar {
    public static void main(String[] args)
    {
        Car sherriCar = new Car("Dr. Harms",90);
        // Get on the interstate at 75 mph
        for (int i=0;i*5<75;i++)
            sherriCar.accelerate(); //we accelerate 5 mph at a time


        //Drive Dr. Harms to see her kids in Lincoln - 110 minutes at 75 mph
        for (int i=0;i<110;i++)
            sherriCar.move();


        //when she gets to the Lincoln city limits, slow her car to 65 mph and then drive for 10 minutes
        for (int i=0;i<2;i++)
            sherriCar.brake();
        for (int i=0;i<10;i++)
            sherriCar.move();
        //output car information - showing how far she drove
        System.out.println(sherriCar);

        //ask the user for input data and create a car for one CSIT 150 student
        //drive their car home
        //output car info
        Car samCar = new Car("Mr. Doubet",75);
        // Get on 29th street from the UNK stadium and drive at 25 mph.
        for (int i=0;i*5<25;i++)
            samCar.accelerate(); //we accelerate 5 mph at a time

        //Drive Mr. Doubet home for 2 minutes at 25 miles per hour.
        for (int i=0;i<2;i++)
            samCar.move();

        System.out.println(samCar);

        //ask the user for input data and create a car for a second CSIT 150 student
        //drive their car home
        //output car info

        Car ajCar = new Car("Mr. Hurtado",90);
        // Get on the interstate at 75 mph and head west.
        for (int i=0;i*5<75;i++)
            ajCar.accelerate(); //we accelerate 5 mph at a time

        //Drive Mr. Hurtado to North Platte at 75 mph for 90 minutes.
        for (int i=0;i<90;i++)
            ajCar.move();

        //when she gets to North Platte, exit the interstate heading south on HWY 83 at 65 MPH.
        //Head south for 4 hours.
        for (int i=0;i<2;i++)
            ajCar.brake();
        for (int i=0;i<240;i++)
            ajCar.move();
        //output car information - showing how far she drove
        System.out.println(ajCar);

        //check to see who drove the farthest (in code)
        //output the car that drove the farthest
        if (sherriCar.getdistanceTraveled() > samCar.getdistanceTraveled() && sherriCar.getdistanceTraveled() > ajCar.getdistanceTraveled()){
        System.out.println(sherriCar);
        }
        else if (samCar.getdistanceTraveled() > sherriCar.getdistanceTraveled() && samCar.getdistanceTraveled() > ajCar.getdistanceTraveled()){
            System.out.println(samCar);
        }
        else if (ajCar.getdistanceTraveled() > sherriCar.getdistanceTraveled() && ajCar.getdistanceTraveled() > samCar.getdistanceTraveled()){
            System.out.println(ajCar);
        }

        //now, reset each car's distance traveled and speed, and drive them back to Kearney

        //Reset Dr. Harms and drive her back to Kearney.
        sherriCar.resetCurrentSpeed();
        sherriCar.resetDistance();
        for (int i=0;i*5<65;i++)
            sherriCar.accelerate();
        for (int i=0;i<10;i++)
            sherriCar.move();
        for (int i=0;i*5<10;i++)
            sherriCar.accelerate();
        for (int i=0;i<110;i++)
            sherriCar.move();
        System.out.println(sherriCar);

        //Reset Sam's car and drive him back to Kearney.
        samCar.resetCurrentSpeed();
        samCar.resetDistance();
        for (int i=0;i*5<25;i++)
            samCar.accelerate();
        for (int i=0;i<2;i++)
            samCar.move();
        System.out.println(samCar);

        //Reset MR. Hurtado's car and drive him back to Kearney.
        ajCar.resetCurrentSpeed();
        ajCar.resetDistance();
        for (int i=0;i*5<65;i++)
            ajCar.accelerate();
        for (int i=0;i<240;i++)
            ajCar.move();
        for (int i=0;i*5<10;i++)
            ajCar.accelerate();
        for (int i=0;i<90;i++)
            ajCar.move();

        System.out.println(ajCar);

        //Bonus: test the car's copy constructor

    }
}