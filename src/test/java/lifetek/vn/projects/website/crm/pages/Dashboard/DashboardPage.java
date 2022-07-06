package lifetek.vn.projects.website.crm.pages.Dashboard;

import lifetek.vn.projects.website.crm.pages.Projects.ProjectPage;
import lifetek.vn.utils.ObjectUtils;
import lifetek.vn.utils.WebUI;
import lifetek.vn.projects.website.crm.pages.Clients.ClientPage;

public class DashboardPage {

    public DashboardPage() {
    }

    public String pageText = "Project Timeline";
    public String pageUrl = "/dashboard";

    public ClientPage openClientPage() {
        WebUI.clickElement(ObjectUtils.getObject("menuClients"));

        return new ClientPage();
    }

    public ProjectPage openProjectPage() {
        WebUI.clickElement(ObjectUtils.getObject("menuProjects"));

        return new ProjectPage();
    }
}
