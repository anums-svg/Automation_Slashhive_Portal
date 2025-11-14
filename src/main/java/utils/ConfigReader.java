package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;

	public ConfigReader() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src/main/resources/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValidEmail() {
		return prop.getProperty("valid_email");
	}

	public String getValidPassword() {
		return prop.getProperty("valid_password");
	}

	public String getInValidEmail() {
		return prop.getProperty("invalid_Email");
	}

	public String getInValidPassword() {
		return prop.getProperty("invalid_Password");
	}
}
