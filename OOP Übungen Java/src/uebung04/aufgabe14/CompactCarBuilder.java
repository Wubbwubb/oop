package uebung04.aufgabe14;

public class CompactCarBuilder extends CarBuilder {

	@Override
	public void setTopSpeed() {
		getCar().setTopSpeed(140);
	}

	@Override
	public void setPower() {
		getCar().setPower(50);
	}

	@Override
	public void setFuelType() {
		getCar().setFuelType(FuelType.GASOLINE);
	}

	@Override
	public void setAircon() {
		getCar().setAircon(false);
	}

}
