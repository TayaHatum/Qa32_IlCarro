package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){

        if(app.user().isLogOutPresent()){
            app.user().logout();
        }
    }

    @Test
    public void registrationSuccess(){
        int index = (int)(System.currentTimeMillis()/1000)%36000;

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm("Lia","Snow","lia"+index+"@gmail.com","Llia12345$");
        // app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(),"You are logged in success");

    }
    @Test
    public void registrationSuccessNew(){
        int index = (int)(System.currentTimeMillis()/1000)%36000;

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm("Lia","Snow","lia"+index+"@gmail.com","Llia12345$");
        // app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(),"You are logged in success");

    }

    @AfterMethod
    public void postCondition(){
        app.user().submitOkButton();
    }
}
