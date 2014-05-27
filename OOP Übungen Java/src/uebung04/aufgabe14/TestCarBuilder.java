package uebung04.aufgabe14;

public class TestCarBuilder {

	public static void main(String[] args) {
		Car car = new CarBuilder(250, 225, FuelType.GASOLINE).cdPlayer(true).sunroof(true).airCondition(true).build();
		System.out.println(car.toString());
	}

}
