package vtiger.GenericUtilitiws;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of generic methods to read data from property file
 * @author Yogesh
 *
 */

public class PropertyFileUtility {
	/**
	 * This method will read data from  property file
	 * 
	 * @param key
	 * @return 
	 * @throws IOException 
	 * @throws
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
