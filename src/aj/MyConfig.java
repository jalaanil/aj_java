package aj;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;


public class MyConfig {
	String configValue = "";
	InputStream inputStream;
	
	public static void main(String args[] )
	{
		try {
		System.out.println("Hello world ");
		MyConfig c = new MyConfig();
		System.out.println(c.getConfig("name"));
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
 
	public String getConfig(String configName) throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			} 
			// get the property value and print it out
			String configValue = prop.getProperty(configName);
			return configValue;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			inputStream.close();
		}

	}
}