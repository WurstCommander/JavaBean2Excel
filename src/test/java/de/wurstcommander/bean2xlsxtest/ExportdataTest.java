package de.wurstcommander.bean2xlsxtest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.wurstcommander.bean2xlsx.Bean2xlsx;
import de.wurstcommander.testdata.Car;
import de.wurstcommander.testdata.TestData;
import de.wurstcommander.util.BeanColumn;
import de.wurstcommander.util.FormatType;

public class ExportdataTest {

	@Test
	public void exportDataToXlxs() {
		// Column definitions
		BeanColumn[] columns = new BeanColumn[] {
				new BeanColumn("name", "Carmodel", FormatType.TEXT),
				new BeanColumn("power", "Power", FormatType.INTEGER),
				new BeanColumn("priceinEuro", "Price in Euro", FormatType.MONEY) };
		// create testdata
		List<Car> data = TestData.createTestData();
		Bean2xlsx beanexcel = new Bean2xlsx();
		beanexcel.bean2xlsx(data, columns, "Data/exceldata2.xlsx", "Cars");
	}

	@Test
	public void createBigXLSx() {
		BeanColumn[] columns = new BeanColumn[] {
				new BeanColumn("name", "Carmodel", FormatType.TEXT),
				new BeanColumn("power", "Power", FormatType.INTEGER),
				new BeanColumn("priceinEuro", "Price in Euro", FormatType.MONEY) };
		List<Car> manycars = new ArrayList<Car>();
		while (manycars.size() <= 500000) {
			manycars.addAll((TestData.createTestData()));
		}
		Bean2xlsx beanexcel = new Bean2xlsx();
		beanexcel.bean2xlsx(manycars, columns, "Data/exceldataBig2.xlsx", "Cars");
	}

	//my writen test case
	
	
	  @Test
	    public void exportEmptyDataToXlsx() {
	        // Column definitions
	        BeanColumn[] columns = new BeanColumn[] {
	                new BeanColumn("name", "Carmodel", FormatType.TEXT),
	                new BeanColumn("power", "Power", FormatType.INTEGER),
	                new BeanColumn("priceinEuro", "Price in Euro", FormatType.MONEY) };

	        // Create an empty list for empty data
	        List<Car> emptyData = new ArrayList<>();
	        String excelPath = "Data/emptyExcelData.xlsx";
	        String sheetName = "EmptyDataSheet";

	       
	        Bean2xlsx beanExcel = new Bean2xlsx();
	        beanExcel.bean2xlsx(emptyData, columns, excelPath, sheetName);

	        // Verify test case
	        File file = new File(excelPath);
	        assertTrue("Excel file not created", file.exists());
	        assertTrue("Excel file is empty", file.length() > 0);
	    }
}
