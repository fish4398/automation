
package lifetek.vn.projects.website.crm.testcases;

import lifetek.vn.common.BaseTest;
import lifetek.vn.dataprovider.DataProviderManager;
import lifetek.vn.projects.website.crm.pages.Dashboard.DashboardPage;
import lifetek.vn.projects.website.crm.pages.SignIn.SignInPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test CRM")
@Feature("Sign In Test")
public class SignInTest extends BaseTest {

    SignInPage signInPage;
    DashboardPage dashboardPage;

    public SignInTest() {
        signInPage = new SignInPage();
    }
    
    //Using library DataProvider with read Hashtable
    @Test(priority = 1, dataProvider = "getSignInDataHashTable", dataProviderClass = DataProviderManager.class)
    @Step("SignInTestDataProviderHashtable")
    public void SignInTestDataProviderHashtable(Hashtable<String, String> data) {
        signInPage.signIn(data);
    }

    @Test(priority = 2, dataProvider = "getSignInDataHashTable2", dataProviderClass = DataProviderManager.class)
    @Step("SignInTestDataProviderHashtable")
    public void SignInTestDataProviderHashtable2(Hashtable<String, String> data) {
        signInPage.signIn(data);
    }

}
