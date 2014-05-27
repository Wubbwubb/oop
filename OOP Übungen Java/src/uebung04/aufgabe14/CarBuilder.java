package uebung04.aufgabe14;

public class CarBuilder {

	private final int topSpeed;
	private final int power;
	private final FuelType fuelType;

	private boolean cdPlayer = true;
	private boolean sunroof = false;
	private boolean aircon = true;

	public CarBuilder(int pTopSpeed, int pPower, FuelType pFuelType) {
		this.topSpeed = pTopSpeed;
		this.power = pPower;
		this.fuelType = pFuelType;
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

	public boolean hasCDPlayer() {
		return cdPlayer;
	}

	public boolean hasSunroof() {
		return sunroof;
	}

	public boolean hasAirCondition() {
		return aircon;
	}

	public CarBuilder cdPlayer(boolean cdPlayer) {
		this.cdPlayer = cdPlayer;
		return this;
	}

	public CarBuilder sunroof(boolean sunroof) {
		this.sunroof = sunroof;
		return this;
	}

	public CarBuilder airCondition(boolean airCondition) {
		this.aircon = airCondition;
		return this;
	}

	public Car build() {
		return new Car(this);
	}

}
