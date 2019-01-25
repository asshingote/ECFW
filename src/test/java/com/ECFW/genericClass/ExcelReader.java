package com.ECFW.genericClass;


import java.io.FileInputStream; 
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelReader implements AutoConstant
{

	private static Workbook book;
	private static Sheet sheet;
	private static Row row;
	private static Cell c;
		
	public ExcelReader(String path)
	{
		try 
		{
			book = WorkbookFactory.create(new FileInputStream(path));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public String getTestData(String sheetname, int rownum,int cellnum)
	{
		sheet = book.getSheet(sheetname);
		c= sheet.getRow(rownum).getCell(cellnum);
		//c.setCellType(Cell.CELL_TYPE_STRING);
		c.setCellType(CellType.STRING);
		String returnData = c.getStringCellValue();
		return returnData;
	}
	
	public int fetchRowCount(String sheetname)
	{
		int row = book.getSheet(sheetname).getLastRowNum();
		//c.setCellType(Cell.CELL_TYPE_STRING);
		System.out.println(row);
		
		return row;
	}
	public int fetchCellCount(String sheetname)
	{
		int cell=book.getSheet(sheetname).getRow(0).getLastCellNum();
		return cell;
	}
	
	public static void excelwrite(String sheetname, int rownum,int cellnum,String result)
	{
		String path = EXCEL_PATH;
		try 
		{
		book=WorkbookFactory.create(new FileInputStream(path));
		sheet=book.getSheet(sheetname);
		row=sheet.getRow(rownum);
		c=row.createCell(cellnum);
		c.setCellValue(result);
		book.write(new FileOutputStream(path));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
