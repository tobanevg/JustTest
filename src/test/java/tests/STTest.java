package tests;

import odel.User;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class STTest {
    private tests.Application app = new tests.Application();

    @Test
    @UseDataProvider(value = "validUsers", location = DataProviders.class)
    public void register(User user) {
        app.registration(user);
        app.purchasing();
        app.logout();
        app.login();
        app.quit();
    }

}