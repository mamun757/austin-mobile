package utilities;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class CapabilitiesManager {
    private static final Logger LOGGER = LogManager.getLogger(CapabilitiesManager.class);

    public DesiredCapabilities getCaps() {

        // Reading values from Config files
        String deviceName = ReadConfigFiles.getPropertyValues("deviceName");
        String udId = ReadConfigFiles.getPropertyValues("udId");
        String AndroidAutomationName = ReadConfigFiles.getPropertyValues("automationName");
        String appPackage = ReadConfigFiles.getPropertyValues("appPackage");
        String appActivity = ReadConfigFiles.getPropertyValues("appActivity");
        String appName = ReadConfigFiles.getPropertyValues("androidAppName");
        String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
                +"test" + File.separator + "resources" + File.separator + "apps" + File.separator
                +appName;
        LOGGER.debug("App location is: " + appPath );

        //Setting Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AndroidAutomationName);
        caps.setCapability(MobileCapabilityType.UDID, udId);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        //caps.setCapability(MobileCapabilityType.APP, appPath);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);


        return caps;
    }
}
