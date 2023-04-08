package vtiger.GenericUtilitiws;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains genreic methods related to excel file
 * @author Yogesh
 *
 */

public class ExcelFileUtility {
	
	/**
	 * THis method will read data from excel sheet based on row and cell value
	 * @param sheet
	 * @param row
	 * @param cel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFromExcel(String sheet, int row, int cel) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 
		
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(row);
		Cell ce = rw.getCell(cel);
		String value = ce.getStringCellValue();
		return value;
		
	}
	
	/**
	 * This method will get Total row utility
	 * @param sheet
	 * @return rowCount
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowcount(String Sheet) throws EncryptedDocumentException, IOException
	{
	  FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
	 Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheet);
	int rowCount = sh.getLastRowNum();
	return rowCount;
	}
	
	/**
	 * this method will help to write data into excel
	 * @param sheet
	 * @param row
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int row, int cel, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		  Row rw = wb.getSheet(sheet).getRow(row);
		  rw.createCell(cel).setCellValue(value);
		  
		  FileOutputStream fos=new FileOutputStream(IConstantUtility.ExcelFilePath);
		  wb.write(fos);
		  System.out.println(value+"data added");
		  wb.close();
	}
	
	public Object[][] createMultipleData(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(Sheetname);
		 int lastrow = sh.getLastRowNum();
		int lastcel = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastrow][lastcel];
		
		for(int i=0; i<lastrow; i++) 
		{
		for(int j=0;j<lastcel;j++) 
		{
			data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
		}
		return data;
	}

}
