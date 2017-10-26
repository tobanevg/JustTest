package Tests;

import Odel.User;

import Tests.Application;
import Tests.DataProviders;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class STTest {
    private Application app = new Application();

    @Test
    @UseDataProvider(value = "validUsers", location = DataProviders.class)
    public void register(User user) {
        app.registration(user);
        app.purchuasing();
        app.logout();
        app.login();
        app.quit();
    }


}