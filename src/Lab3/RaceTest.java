package Lab3;

/**
 * RaceTest the Race class
 *
 * As you build the race class, uncomment more and more of the test code.
 */
public class RaceTest {

    public static void main(String[] args) {

        Car sherriCar = new Car("Sherri", 85);
        Car andrewCar = new Car("Andrew", 100);
        Car samCar = new Car("Sam", 100);


            Race race = new Race();
			race.setDistance(500);
			race.setRaceType("Stock Car");
			race.addCar(sherriCar);
			race.addCar(andrewCar);
			race.addCar(samCar);
			race.runRace();

			System.out.println("The results of the race is: ");
			System.out.println(race.toString());
			System.out.println("_______________________");

			// Second Race test statements:

			Race secondRace = new Race(); // a copy of the race - lets race with copies of the cars!

			Car[] carsCopy = race.getCars();
			for (int i = 0; i < carsCopy.length; i++) {
				Car copy = carsCopy[i];
				copy.setMaxSpeed(copy.getMaxSpeed() * 2);  //first we will modify the cars, making them faster
				copy.setOwner(copy.getOwner()+" COPY");
				copy.resetCurrentSpeed();    //reset copy car engine
				copy.resetDistance();        //reset copy car distance to 0
				secondRace.addCar(copy);    //add the copy car to the race
				System.out.println("Copied car: " + copy);
			}

			Car anotherCar = new Car("Santa", 100);
			secondRace.addCar(anotherCar);
			System.out.println("Additional car: " + anotherCar);
			System.out.println("_______________________");

			// check winner at beginning of race
			System.out.println("Second race winner: " + secondRace.getWinner());
			System.out.println("_______________________");

			secondRace.runRace();

			System.out.println("The results of the second race is: ");
			System.out.println(secondRace.toString());
			System.out.println("_______________________");

			System.out.println("To verify that the second race did not change the cars in the first race.");
			Car[] carsInFirstRace = race.getCars();
			for (int i = 0; i < carsInFirstRace.length; i++) {
				System.out.println(carsInFirstRace[i].getOwner() + "\t" + carsInFirstRace[i].getdistanceTraveled());
			}
			System.out.println("_______________________");
			Car[] carsInSecondRace = secondRace.getCars();
			for (int i = 0; i < secondRace.getCarCount(); i++)
				System.out.println(carsInSecondRace[i].getOwner() + "\t" + carsInSecondRace[i].getdistanceTraveled());

			// Third Bad Race test statements:

//			System.out.println("_______________________");
//			Race thirdRace = new Race(-3); // test out our exception
//			thirdRace.addCar(sherriCar);
//			System.out.println("The status of the third race is: ");
//			System.out.println(thirdRace.toString());
    }

}
