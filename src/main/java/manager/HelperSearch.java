package manager;

import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {

        typeCity(city);
        selectPeriod(dataFrom,dataTo);
    }

    private void selectPeriod(String dataFrom, String dataTo) {
        // "04/10/2022","04/20/2022" ---> 10 -20
        String[] from=dataFrom.split("/"); //>>>> [04][10][2022] from.get(1)

        click(); ---->10
         click () --->20
    }

    public void searchCurrentMonthInPast(String city, String dataFrom, String dataTo) {
        typeCity(city);
        typePerionInPast(dataFrom,dataTo); === >>>>> sendKey("2/10/2022 - 4/20/2022");
    }
}
