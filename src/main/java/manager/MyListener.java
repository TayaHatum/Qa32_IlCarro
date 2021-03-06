package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start find element by ----> " +by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        if(element!=null && element.isDisplayed()) {
            logger.info("The element -->" + by + "was found");
        }else{
            logger.info("The element -->" + by + "wasn't found");
        }

    }

    @Override
    public void onException(Throwable throwable, WebDriver wd) {
        super.onException(throwable, wd);
        logger.info("We have a throwable -->" + Arrays.toString(throwable.getStackTrace()));

        logger.info("We have a throwable -->" + throwable.getMessage());
        logger.info("We have a throwable -->" + throwable.getLocalizedMessage());
        logger.info("We have a throwable -->" + throwable.getCause());
        logger.info("We have a throwable -->" + throwable.fillInStackTrace());

        int i= (int)(System.currentTimeMillis()/1000)%3600;
        String screenshot = "src/test/screenshots/screen-"+i+".png";
        HelperBase helperBase =new HelperBase(wd);
        helperBase.takeScreenshot(screenshot);
        logger.info("Screen with throwable in screenshots --->"+screenshot);


    }

}
