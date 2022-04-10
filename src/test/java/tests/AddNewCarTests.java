package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if(!app.user().isLogOutPresent()){
            User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
            app.user().login(user);
            logger.info("Test start with user -->  " + user.toString());
        }
    }

    @Test
    public void addNewCarSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 36000;
        logger.info(" 'Car Reg number' 100-22" +index);


        Car car = Car.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2022")
                .engine("2.5")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("100-22-" + index)
                .price("65")
                .distanceIncluded("500")
                .features("Type of features")
                .about("Very good car")
                .build();
        logger.info("Add car --->" + car.toString());

        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("/Users/tayahatum/Qa32/Qa32_IlCarro/auto2.jpeg");
        logger.info("Attach photo --> /Users/tayahatum/Qa32/Qa32_IlCarro/auto2.jpeg" );
        app.car().submit();

        Assert.assertTrue(app.car().isCarAdded());


    }
}
