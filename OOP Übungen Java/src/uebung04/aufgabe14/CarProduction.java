package uebung04.aufgabe14;

public class CarProduction {

	private CarBuilder carBuilder;

	public CarProduction(CarBuilder pCarBuilder) {
		this.carBuilder = pCarBuilder;
	}

	public Car buildCar() {
		carBuilder.buildCar();
		carBuilder.setTopSpeed();
		carBuilder.setPower();
		carBuilder.setFuelType();
		carBuilder.setCDPlayer();
		carBuilder.setSunroof();
		carBuilder.setAircon();
		return carBuilder.deliver();
	}

	public static void main(String[] args) {
		CarBuilder carBuilder = new RoadsterBuilder();
		CarProduction production = new CarProduction(carBuilder);
		Car car = production.buildCar();
		System.out.println(car.toString());
	}

}
