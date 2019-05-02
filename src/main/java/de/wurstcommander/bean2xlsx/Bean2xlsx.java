package de.wurstcommander.bean2xlsx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import de.wurstcommander.util.BeanColumn;
import de.wurstcommander.util.FormatType;

/**
 * The Class Bean2Xlsx.
 * 
 * @author WurstCommander
 */
public class Bean2xlsx {

	private CellStyle cellstyle;
	private Workbook workbook;

	public Bean2xlsx() {
		workbook = new XSSFWorkbook();
		cellstyle = workbook.createCellStyle();
	}

	private void addSheet(List<?> data, BeanColumn[] columns, String sheetname) {
		Sheet sheet = workbook.createSheet(sheetname);
		// count of columns
		int colcount = columns.length;
		int currentRow = 0;
		Row row;

		// Header creation
		row = sheet.createRow(currentRow);
		// Loop over colums of the provided Bean and write the headers
		for (int i = 0; i < colcount; i++) {
			// write headertext for each column
			writeCell(row, i, (Object) columns[i].getHeader(), FormatType.TEXT,
					null, null);
		}
		currentRow++; // Increment row after writing header

		// Write the real reportdata
		for (int i = 0; i < data.size(); i++) {
			// create a row in the spreadsheet
			row = sheet.createRow(currentRow++);
			// Get the data from the bean for the current row
			Object bean = data.get(i);
			// For each column object, create a column on the current row
			for (int y = 0; y < colcount; y++) {
				Object value = null;
				// Get value of property
				try {
					value = PropertyUtils.getProperty(bean,
							columns[y].getProperty());
				} catch (IllegalAccessException | InvocationTargetException
						| NoSuchMethodException e) {
					System.err
							.println("Error getting value from the provided bean!");
					e.printStackTrace();
				}
				writeCell(row, y, value, columns[y].getType(),
						columns[y].getColor(), columns[y].getFont());
			}
		}
	}

	public void bean2xlsx(List<?> data, BeanColumn[] columns, String filename,
			String sheetname) {
		addSheet(data, columns, sheetname);
		File f = new File(filename);
		// delete file -- testing!
		f.delete();
		try {
			FileOutputStream output = new FileOutputStream(filename);
			// Write Excelfile
			write(output);

		} catch (FileNotFoundException e) {
			System.err.println("File was not found!" + filename);
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Some error occured ");
			e.printStackTrace();
		}

	}

	private void write(OutputStream outputStream) throws Exception {
		workbook.write(outputStream);
	}

	private void writeCell(Row row, int col, Object value,
			FormatType formatType, Short bgColor, Font boldFont) {
		Cell cell;
		if (value == null) {
			return;
		}
		if (boldFont != null) {
			// font later
			System.out.println("font given, but not yet implemented");
		}
		switch (formatType) {
		case TEXT:
			cell = row.createCell(col);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(value.toString());
			break;
		case INTEGER:
			cell = row.createCell(col);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue(Double.valueOf(value.toString()));
			break;
		case MONEY:
			cell = row.createCell(col);
			Double bg = (Double) value;
			cellstyle.setDataFormat(workbook.getCreationHelper()
					.createDataFormat().getFormat("#,##0.00\\ €"));
			cell.setCellValue(bg.doubleValue());
			cell.setCellStyle(cellstyle);
			break;
		case PERCENTAGE:
			System.err.println("NOT YET IMPLEMENTED!");
		case FLOAT:
			System.err.println("NOT YET IMPLEMENTED!");
			break;
		case DATE:
			System.err.println("NOT YET IMPLEMENTED!");
			break;
		default:
			break;
		}
		if (bgColor != null) {
			// color later... :)
			System.out
					.println("backgroundcolor given, but not yet implemented");
		}
	}

}