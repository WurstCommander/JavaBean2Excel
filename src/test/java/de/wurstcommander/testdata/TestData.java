package de.wurstcommander.testdata;

import java.util.ArrayList;
import java.util.List;

public class TestData {

	public static List<Car> createTestData() {
		List<Car> tempList = new ArrayList<Car>();
		// create cars
		Car a = new Car("Golf GTI Mk7", 90, 17000.24);
		Car b = new Car("VW Golf I", 37, 2500.23);
		Car c = new Car("Glas/BMW 3000 V8", 110, 25000.78);
		Car d = new Car("BMW E30", 175, 7000.78);
		Car e = new Car("Audi 80 B3", 77, 150.5);

		// add cars to list
		tempList.add(a);
		tempList.add(b);
		tempList.add(c);
		tempList.add(d);
		tempList.add(e);
		return tempList;
	}
}