package uebung04.aufgabe14;

public class Car {

	private final int topSpeed;
	private final int power;
	private final FuelType fuelType;

	private final boolean cdPlayer;
	private final boolean sunroof;
	private final boolean aircon;

	public Car(CarBuilder builder) {
		this.topSpeed = builder.getTopSpeed();
		this.power = builder.getPower();
		this.fuelType = builder.getFuelType();
		this.cdPlayer = builder.hasCDPlayer();
		this.sunroof = builder.hasSunroof();
		this.aircon = builder.hasAirCondition();
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public int getPower() {
		return power;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public boolean hasCdPlayer() {
		return cdPlayer;
	}

	public boolean hasSunroof() {
		return sunroof;
	}

	public boolean hasAircon() {
		return aircon;
	}

	@Override
	public String toString() {
		String s = "topSpeed: " + getTopSpeed() + "\n";
		s += "power: " + getPower() + "\n";
		s += "fuelType: " + getFuelType().name() + "\n";
		s += "cdPlayer: " + hasCdPlayer() + "\n";
		s += "sunroof: " + hasSunroof() + "\n";
		s += "aircon: " + hasAircon();
		return s;
	}

}
