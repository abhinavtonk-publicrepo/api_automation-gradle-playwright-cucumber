package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public String getProperty(String filePath, String propertyKey) throws IOException {
        File f = new File(filePath);
        FileInputStream fis = new FileInputStream(f);
        Properties properties = new Properties();
        properties.load(fis);

        return properties.getProperty(propertyKey);
    }
}
