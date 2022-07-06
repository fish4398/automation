package lifetek.vn.projects.website.crm.pages.SignIn;

import lifetek.vn.constants.FrameworkConstants;
import lifetek.vn.helpers.ExcelHelpers;
import lifetek.vn.projects.website.crm.models.SignInModel;
import lifetek.vn.projects.website.crm.pages.Dashboard.DashboardPage;
import lifetek.vn.utils.DecodeUtils;
import lifetek.vn.utils.ObjectUtils;
import lifetek.vn.utils.WebUI;
import org.testng.Assert;

import java.util.Hashtable;

public class SignInPage {

    private String pageUrl = "/signin";
    private String pageText = "";
    private String dashboardPageURL = "/dashboard";

    public SignInPage() {
    }

    public DashboardPage signInWithAdminRole() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_PATH, "SignIn");
        WebUI.getToUrl(FrameworkConstants.BASE_URL);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of sign in page not match.");
        WebUI.setText(ObjectUtils.getObject("inputEmail"), excelHelpers.getCellData(1, SignInModel.getEmail()));
        WebUI.setText(ObjectUtils.getObject("inputPassword"), DecodeUtils.decrypt(excelHelpers.getCellData(1, SignInModel.getPassword())));
        WebUI.clickElement(ObjectUtils.getObject("buttonSignIn"));
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(dashboardPageURL), "Sign in failed. Can not redirect to Dashboard page.");
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }

    public DashboardPage signInWithTeamLeaderRole() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_PATH, "SignIn");
        WebUI.getToUrl(FrameworkConstants.BASE_URL);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of sign in page not match.");
        WebUI.setText(ObjectUtils.getObject("inputEmail"), excelHelpers.getCellData(2, SignInModel.getEmail()));
        WebUI.setText(ObjectUtils.getObject("inputPassword"), DecodeUtils.decrypt(excelHelpers.getCellData(2, SignInModel.getPassword())));
        WebUI.clickElement(ObjectUtils.getObject("buttonSignIn"));
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(dashboardPageURL), "Sign in failed. Can not redirect to Dashboard page.");
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }

    public DashboardPage signInWithTeamMemberRole() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_PATH, "SignIn");
        WebUI.getToUrl(FrameworkConstants.BASE_URL);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of sign in page not match.");
        WebUI.setText(ObjectUtils.getObject("inputEmail"), excelHelpers.getCellData(3, SignInModel.getEmail()));
        WebUI.setText(ObjectUtils.getObject("inputPassword"), DecodeUtils.decrypt(excelHelpers.getCellData(3, SignInModel.getPassword())));
        WebUI.clickElement(ObjectUtils.getObject("buttonSignIn"));
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(dashboardPageURL), "Sign in failed. Can not redirect to Dashboard page.");
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }

    public DashboardPage signIn(String email, String password) {
        WebUI.getToUrl(FrameworkConstants.BASE_URL);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of Sign in page not match.");
        WebUI.sleep(1);
        WebUI.setText(ObjectUtils.getObject("inputEmail"), email);
        WebUI.setText(ObjectUtils.getObject("inputPassword"), password);
        WebUI.clickElement(ObjectUtils.getObject("buttonSignIn"));
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }

    public DashboardPage signIn(Hashtable<String, String> data) {
        WebUI.getToUrl(FrameworkConstants.BASE_URL);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of sign in page not match.");
        WebUI.setText(ObjectUtils.getObject("inputEmail"), data.get(SignInModel.getEmail()));
        WebUI.setText(ObjectUtils.getObject("inputPassword"), DecodeUtils.decrypt(data.get(SignInModel.getPassword())));
        WebUI.clickElement(ObjectUtils.getObject("buttonSignIn"));
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(dashboardPageURL), "Sign in failed. Can not redirect to Dashboard page.");
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }

}
