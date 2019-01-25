package com.ECFW.genericClass;

import java.io.FileInputStream; 
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelHandling implements AutoConstant
{
		static Workbook book;
		static Sheet sheet;
		static Row row;
		static Cell cell;
		static String value;
		public static String excelRead(String sheetname, int rownum,int cellnum)
		{
			String path = EXCEL_PATH;
			try 
			{
				book=WorkbookFactory.create(new FileInputStream(path));
				sheet=book.getSheet(sheetname);
				row=sheet.getRow(rownum);
				cell=row.getCell(cellnum);
				//cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellType(CellType.STRING);
				value = cell.toString();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return value; 
		}
		public static void excelwrite(String sheetname, int rownum,int cellnum,String result)
		{
			String path = EXCEL_PATH;
			try 
			{
			book=WorkbookFactory.create(new FileInputStream(path));
			sheet=book.getSheet(sheetname);
			row=sheet.getRow(rownum);
			cell=row.createCell(cellnum);
			cell.setCellValue(result);
			book.write(new FileOutputStream(path));
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
	
}
