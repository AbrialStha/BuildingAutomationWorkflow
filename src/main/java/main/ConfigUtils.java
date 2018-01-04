package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by LT102 on 1/3/2018.
 */
public class ConfigUtils {
    private ConfigUtils() {
        throw new IllegalStateException("ConfigUtils");
    }

    /**
     * This method reads and returns specified property from properties file
     * Note that VM argument -Dfuse.env=value is mandatory
     */
    public static String getProperty(String text) {
        Properties prop = new Properties();
        String propFileName = "config." + ConfigUtils.getEnvironmentVariable() + ".properties";

        InputStream inputStream = ConfigUtils.class.getClassLoader()
                .getResourceAsStream(propFileName);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println(String.valueOf(e.getStackTrace()));
        }
        if (inputStream == null) {
            try {
                throw new FileNotFoundException("Property file '"
                        + propFileName + "' not found in classpath");
            } catch (FileNotFoundException e) {
                System.out.println(String.valueOf(e.getStackTrace()));
            }
        }

        return prop.getProperty(text);

    }

    /**
     * This method reads the environment variables supplied as vm arguments to
     * the program
     *
     * @return fusetest.env
     */
    private static String getEnvironmentVariable() {
        return System.getProperty("fusetest.env");
    }
}
