package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {

       typeCity(city);
        selectPeriod(dataFrom,dataTo);
    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector(".pac-item"));

    }

    private void selectPeriod(String dataFrom, String dataTo) {
        //"4/10/2022"  ,"4/20/2022"
        click(By.id("dates"));
//    "4/10/2022"
        String [] from = dataFrom.split("/");   // [04][10][2022]
        String dayF = from[1];

        String locatorFrom = String.format("//div[text()=' %s ']",dayF);

        click(By.xpath(locatorFrom));


        //"4/20/2022"
        String[] to = dataTo.split("/"); // [04][20][2022]
        String dayT = to[1];
        String locatorTo = String.format("//div[text()=' %s ']",dayT);
        click(By.xpath(locatorTo));


    }

    public void searchCurrentMonthInPast(String city, String dataFrom, String dataTo) {
       // typeCity(city);
       // typePerionInPast(dataFrom,dataTo); === >>>>> sendKey("2/10/2022 - 4/20/2022");
    }

    public void searchAnyPeriod(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodAnyData(dataFrom,dataTo);
    }

    private void selectPeriodAnyData(String dataFrom, String dataTo) {
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        //"04/05/2022"     [04][05][2022] String yearfFrom = "2022" int 2022

        click(By.id("dates"));
        int diffYear;
        int diffMonth;

        diffYear = from.getYear()- now.getYear();
        if(diffYear==0){
            diffMonth = from.getMonthValue()-now.getMonthValue();
        }else {
            diffMonth =12- now.getMonthValue() +from.getMonthValue();
        }
        clickByNextMonth(diffMonth);

        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

//****************************************
        diffYear = to.getYear() -from.getYear();
        if(diffYear==0){
            diffMonth = to.getMonthValue() -from.getMonthValue();
        }else {
            diffMonth = 12-from.getMonthValue() +to.getMonthValue();
        }

        clickByNextMonth(diffMonth);

        locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));


    }

    private void clickByNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }
}
