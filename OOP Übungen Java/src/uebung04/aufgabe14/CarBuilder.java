package uebung04.aufgabe14;

public abstract class CarBuilder {

	private Car car;

	public void buildCar() {
		setCar(new Car());
	}

	protected Car getCar() {
		return car;
	}

	private void setCar(Car car) {
		this.car = car;
	}

	public abstract void setTopSpeed();

	public abstract void setPower();

	public abstract void setFuelType();

	public void setCDPlayer() {
		getCar().setCdPlayer(true);
	}

	public void setSunroof() {
		getCar().setSunroof(false);
	}

	public void setAircon() {
		getCar().setAircon(true);
	}

	public Car deliver() {
		return car;
	}

}
