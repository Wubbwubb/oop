package uebung04.aufgabe14;

public class RoadsterBuilder extends CarBuilder {

	@Override
	public void setTopSpeed() {
		getCar().setTopSpeed(250);
	}

	@Override
	public void setPower() {
		getCar().setPower(200);
	}

	@Override
	public void setFuelType() {
		getCar().setFuelType(FuelType.DIESEL);
	}

	@Override
	public void setSunroof() {
		getCar().setSunroof(true);
	}

}
