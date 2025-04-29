package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is used to instantiate page classes.
 */
public class BasePageFactory {
    private static final Logger log = LoggerFactory.getLogger(BasePageFactory.class);

    public static <T extends BasePage> T createInstance(WebDriver driver, Class<T> page) {
        try {
            BasePage instance = page.getDeclaredConstructor().newInstance();
            instance.init(driver);

            return page.cast(instance);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        throw new NullPointerException("Page class instantiation failed.");
    }
}
