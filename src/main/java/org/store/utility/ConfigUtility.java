package org.store.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
    public static Properties getConfig(String fileName) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/resources/Configuration/" + fileName + ".properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return properties;
    }
}
