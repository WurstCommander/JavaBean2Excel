package de.wurstcommander.testdata;

/**
 * The Class Car.
 * 
 * Example Java Bean
 */
public class Car {

	/** The name. */
	private String name;

	/** The power. */
	private int power;

	/** The pricein euro. */
	private double priceinEuro;

	/**
	 * Instantiates a new car.
	 * 
	 * @param name
	 *            the name
	 * @param power
	 *            the power
	 * @param priceinEuro
	 *            the pricein euro
	 */
	public Car(String name, int power, double priceinEuro) {
		super();
		this.name = name;
		this.power = power;
		this.priceinEuro = priceinEuro;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the power.
	 * 
	 * @return the power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * Sets the power.
	 * 
	 * @param power
	 *            the new power
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * Gets the pricein euro.
	 * 
	 * @return the pricein euro
	 */
	public double getPriceinEuro() {
		return priceinEuro;
	}

	/**
	 * Sets the pricein euro.
	 * 
	 * @param priceinEuro
	 *            the new pricein euro
	 */
	public void setPriceinEuro(double priceinEuro) {
		this.priceinEuro = priceinEuro;
	}

}
