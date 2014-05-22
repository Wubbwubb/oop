package uebung04.aufgabe14;

public class Car {

	private int topSpeed;
	private int power;
	private FuelType fuelType;

	private boolean cdPlayer;
	private boolean sunroof;
	private boolean aircon;

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public boolean hasCdPlayer() {
		return cdPlayer;
	}

	public void setCdPlayer(boolean cdPlayer) {
		this.cdPlayer = cdPlayer;
	}

	public boolean hasSunroof() {
		return sunroof;
	}

	public void setSunroof(boolean sunroof) {
		this.sunroof = sunroof;
	}

	public boolean hasAircon() {
		return aircon;
	}

	public void setAircon(boolean aircon) {
		this.aircon = aircon;
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
