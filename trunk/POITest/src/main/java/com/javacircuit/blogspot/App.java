package com.javacircuit.blogspot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author Sudarsan Simple Example to Read an Excel-Sheet
 * 
 */
public class App {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(new File("CMCData.xls"));

			// Reads an Existing WorkBook
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
			// Reads a Sheet with given index
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

			// Get Total Rows from the Sheet
			Iterator<Row> rowIterator = hssfSheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// Get Total Cells from the Sheet
				Iterator<Cell> cellIterator = row.iterator();

				while (cellIterator.hasNext()) {

					// Get Every Cell in the Row
					Cell cell = cellIterator.next();

					// Get Cell Type
					int cellType = cell.getCellType();

					switch (cellType) {
					case Cell.CELL_TYPE_NUMERIC:
						break;

					case Cell.CELL_TYPE_STRING:
						// Extract the Content of Cell and Print
						System.out
								.println(cell.getStringCellValue() + "\t\t\t");
						break;
					}
				}

			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
