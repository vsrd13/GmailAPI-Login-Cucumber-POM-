package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.TestProperties;
import utilities.Utilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kumar on 2/11/2017.
 */
public class BaseTest extends Utilities {

    protected static WebDriver driver;
    private static String IEBROWSER = null;
    private static String IEBROWSER64 = null;
    private static String CBROWSER = null;

    protected static TestProperties _properties = new TestProperties();

    protected WebDriver getDriver() throws Exception {
        String browser = _properties.getProperty(TestProperties.BROWSERTYPE);
        if (driver == null) {
            IEBROWSER = _properties.getProperty(TestProperties.IEBROWSERDRIVER);
            IEBROWSER64 = _properties.getProperty(TestProperties.IEBROWSERDRIVER64);
            CBROWSER = _properties.getProperty(TestProperties.CHROMEDRIVER);
            if (browser.equals("Firefox")) {
                FirefoxProfile Prof = new FirefoxProfile();
                DesiredCapabilities dc = DesiredCapabilities.firefox();
                dc.setJavascriptEnabled(true);
                Prof.setPreference("browser.download.folderList", 2);
                File directory = new File(".//");
                String strConsltFilePath = directory.getCanonicalPath() + "\\DownloadingFiles";
                Prof.setPreference("browser.download.dir", strConsltFilePath);
                Prof.setPreference("browser.helperApps.neverAsk.saveToDisk",
                        "text/csv,application/x-zip-compressed,application/octet-stream,application/pdf,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.fdf, application/x-msdos-program, application/x-unknown-application-octet-stream, application/vnd.ms-powerpoint, application/excel, application/vnd.ms-publisher, application/x-unknown-message-rfc822, application/vnd.ms-excel, application/msword, application/x-mspublisher, application/x-tar, application/zip, application/x-gzip,application/x-stuffit,application/vnd.ms-works, application/powerpoint, application/rtf, application/postscript, application/x-gtar, video/quicktime, video/x-msvideo, video/mpeg, video/mp4, audio/x-wav, audio/x-midi, audio/x-aiff, image/png, image/jpeg, image/pjpeg, application/vnd.oasis.opendocument.text, text/plain"); // tipo
                // especï¿½fico
                Prof.setPreference("pdfjs.disabled", true);
                Prof.setPreference("plugin.scan.Acrobat", "99.0");
                Prof.setPreference("plugin.scan.plid.all", false);
                Prof.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");
                driver = new FirefoxDriver(Prof);
            }
            if (browser.equals("IE")) {
                if (System.getProperty("sun.arch.data.model").equals("64")) {
                    System.setProperty("webdriver.ie.driver", IEBROWSER64);
                } else {
                    System.setProperty("webdriver.ie.driver", IEBROWSER);
                }
                DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
                dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver = new InternetExplorerDriver(dc);
            }
            if (browser.equals("Chrome")) {

                // ChromeOptions options = new ChromeOptions();
                // options.addArguments("--disable-extensions");
                // driver = new ChromeDriver(options);
                System.setProperty("webdriver.chrome.driver", CBROWSER);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-notifications");
                Map<String, Object> prefs = new HashMap<String, Object>();
                // To Turns off multiple download warning
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
                // Turns off download prompt
                prefs.put("download.prompt_for_download", false);
                DesiredCapabilities dc = DesiredCapabilities.chrome();
                dc.setJavascriptEnabled(true);
                options.addArguments("test-type");
                dc.setCapability("chrome.binary", CBROWSER);
                dc.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(dc);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void getURL(String URL) {
        driver.get(URL);
    }
}
