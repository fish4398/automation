
package lifetek.vn.projects.website.crm.testcases;

import lifetek.vn.annotations.FrameworkAnnotation;
import lifetek.vn.common.BaseTest;
import lifetek.vn.enums.AuthorType;
import lifetek.vn.enums.CategoryType;
import lifetek.vn.dataprovider.DataProviderManager;
import lifetek.vn.projects.website.crm.pages.Clients.ClientPage;
import lifetek.vn.projects.website.crm.pages.Dashboard.DashboardPage;
import lifetek.vn.projects.website.crm.pages.SignIn.SignInPage;
import lifetek.vn.utils.WebUI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test CRM")
@Feature("Clients Test")
public class ClientTest extends BaseTest {

    public SignInPage signInPage;
    public DashboardPage dashboardPage;
    public ClientPage clientPage;

    public ClientTest() {
        signInPage = new SignInPage();
    }

    @FrameworkAnnotation(author = {AuthorType.AUTOMATION, AuthorType.LIFETEK},
            category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(priority = 1, dataProvider = "getClientDataHashTable", dataProviderClass = DataProviderManager.class)
    @Step("Add new Client")
    public void testAddClient(Hashtable<String, String> data) {
        dashboardPage = signInPage.signInWithAdminRole();
        clientPage = dashboardPage.openClientPage();
        clientPage.openClientTabPage();
        clientPage.addClient(data);
    }
    
    @FrameworkAnnotation(author = {AuthorType.LIFETEK, AuthorType.AUTOMATION},
            category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(priority = 2)
    @Step("Search Client")
    public void testSearchClient() {
        dashboardPage = signInPage.signInWithAdminRole();
        clientPage = dashboardPage.openClientPage();
        clientPage.openClientTabPage();
        // Search the first
        clientPage.enterDataSearchClient("lifetek");
        WebUI.checkContainsSearchTableByColumn(2, "lifetek");
        // Search the second
        clientPage.enterDataSearchClient("lifetek Client 1406A1");
        WebUI.checkContainsSearchTableByColumn(2, "lifetek Client 1406A1");

    }

}