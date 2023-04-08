package practice;

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

public class writedatafromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
        
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet2");
		
		Row rw = sh.getRow(4);
		
		Cell ce = rw.createCell(8);
		
		ce.setCellValue("wasa");
		
		 FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\testdata.xlsx");
		 
		 wb.write(fos);
		 System.out.println("data added");
	}

}
