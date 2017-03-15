package utilities;

import Base.ResultSheetHelper;
import junit.framework.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Kumar on 2/11/2017.
 */
public class TestProperties extends ResultSheetHelper {

    public static TestProperties _proProperties = new TestProperties();
    public final static String IEBROWSERDRIVER = "IEBROWSERDRIVER";
    public final static String CHROMEDRIVER = "CHROMEDRIVER";
    public final static String IEBROWSERDRIVER64 = "IEBROWSERDRIVER64";
    public static final String BROWSERTYPE = "BROWSERTYPE";

    public final static String PROPERTY_FILENAME = "config/Test.properties";
    public Properties test_properties = new Properties();

    public TestProperties() {
        try {
            test_properties.load(new FileInputStream(PROPERTY_FILENAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assert !test_properties.isEmpty();
    }

    public String getProperty(final String key) {
        String property = test_properties.getProperty(key);
        return property != null ? property.trim() : property;
    }
}
