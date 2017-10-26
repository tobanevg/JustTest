package Tests;

import Odel.User;
import com.tngtech.java.junit.dataprovider.DataProvider;


public class DataProviders {

    @DataProvider
    public static Object[][] validUsers() {
        return new Object[][]{
                {User.newEntity()
                        .withFirstname("Vasya").withLastname("Pupkin")
                        .withEmail("vasya" + System.currentTimeMillis() + "@pupkin.com")
                        .withPassword("qwerty").build()},


        };
    }

}
