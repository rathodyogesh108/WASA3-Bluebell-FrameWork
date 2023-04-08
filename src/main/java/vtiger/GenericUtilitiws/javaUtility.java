package vtiger.GenericUtilitiws;

import java.util.Date;
import java.util.Random;

/**
 * This class contains all the generic methods ro java
 * @author Yogesh
 *
 */

public class javaUtility {
	
	/**
	 * this method will provide the system date
	 * @return
	 */

	public String getSytstemDate()
	{
		Date d=new Date();
		return d.toString();
	}
	
	/**
	 * this method will getsystemdateformat
	 * @return
	 */
	
	public String getSystemDateInFormat()
	
	{
		Date d=new Date();
		String date[]=d.toString().split(" ");
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		
		String finalDate = date1+" "+month+" "+year+" "+time;
		return finalDate;
		
	}
	
	
	public int getrandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
}
