package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){

        if(app.user().isLogOutPresent()){
            app.user().logout();
            logger.info("Test needs logout");
        }
    }

    @Test
    public void loginSuccess(){
        logger.info("Start test LoginSuccess");
        logger.info("The test starts with data [noa@gmail.com] & [Nnoa12345$]" );

        app.user().openLoginForm();
        logger.info("opened form");
        app.user().fillLoginForm("noa@gmail.com","Nnoa12345$");
        logger.info("fill form");
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"Logged in success");
        logger.info("Test passed");

    }

    @Test
    public void loginSuccessModel(){
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

        app.user().openLoginForm();
        app.user().fillLoginForm(user);
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"Logged in success");

    }
    @Test (dataProvider = "dataLoginCSV",dataProviderClass = MyDataProvider.class)
    public void loginSuccessModelCSV(User user){
        logger.info("Test start with user -->" +user.toString());

        app.user().openLoginForm();
        app.user().fillLoginForm(user);
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"Logged in success");

    }

    @Test (dataProvider = "dataLogin",dataProviderClass = MyDataProvider.class)
    public void loginSuccessNew(String email,String password){

        app.user().openLoginForm();
        app.user().fillLoginForm(email,password);
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"Logged in success");



    }

    @AfterMethod
    public void postCondition(){
        app.user().submitOkButton();
    }
}
