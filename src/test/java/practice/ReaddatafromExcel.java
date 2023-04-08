package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddatafromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1:open the document in java readable format
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		
		//step2:create a workbook
		 Workbook wb = WorkbookFactory.create(fis);
		 
		//step3:get control of sheet
		 Sheet sh = wb.getSheet("Sheet2");
		
		//step4:get control of row
		Row rw = sh.getRow(4);
		
		//step5:get control of cell
		Cell ce = rw.getCell(2);
		 
		 //step6:read the data inside the cell
		String value = ce.getStringCellValue();
        System.out.println(value);
	}

}
