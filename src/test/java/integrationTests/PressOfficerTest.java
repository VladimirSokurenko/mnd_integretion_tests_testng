package integrationTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import content_creator_pages.*;
import press_officer_pages.AssignmentsPage;
import press_officer_pages.ContentMarketMenuPage;
import press_officer_pages.CreateJobAssignmentPage;
import press_officer_pages.NewsRoomListPage;
import web_driver_setup.WebDriverSetup;

public class PressOfficerTest extends WebDriverSetup {

    @Test(priority = 1, description = "checks ability to login as Press Officer")
    public void login_as_press_officer_test(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NewsRoomListPage newsRoomListPage = PageFactory.initElements(driver, NewsRoomListPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver,ContentMarketMenuPage.class);
        AssignmentsPage assignmentsPage = PageFactory.initElements(driver, AssignmentsPage.class);
        go_to_the_site("staging");
        loginPage.login_as("pressofficer3", "123123qwe");
        newsRoomListPage.click_on_first_newsroom();
        contentMarketMenuPage.navigate_to("assignments");
        assignmentsPage.verify_assignments_heading_displayed();
        assignmentsPage.verify_create_assignment_btn_is_present();

    }

    @Test(priority = 2,description = "checks creation of job assignment")
    public void create_job_assignment(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NewsRoomListPage newsRoomListPage = PageFactory.initElements(driver, NewsRoomListPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver,ContentMarketMenuPage.class);
        AssignmentsPage assignmentsPage = PageFactory.initElements(driver, AssignmentsPage.class);
        CreateJobAssignmentPage createJobAssignmentPage = PageFactory.initElements(driver, CreateJobAssignmentPage.class);
        go_to_the_site("staging");
        loginPage.login_as("pressofficer3", "123123qwe");
        newsRoomListPage.click_on_first_newsroom();
        contentMarketMenuPage.navigate_to("assignments");
        assignmentsPage.verify_assignments_heading_displayed();
        assignmentsPage.verify_create_assignment_btn_is_present();
        assignmentsPage.click_on_create_assignment_btn();
        String random_title = get_random_text("Assignment random title: ");
        createJobAssignmentPage.fill_in_assignment_title(random_title);
        String random_description = get_random_text("Assignment random description: ");
        createJobAssignmentPage.fill_in_assignment_description(random_description);
        createJobAssignmentPage.select_pr_content_item();
        createJobAssignmentPage.select_swedish_item();
        createJobAssignmentPage.click_on_project_scope_selector();
        createJobAssignmentPage.select_other_scope();
        String random_scope = get_random_text("other scope: ");
        createJobAssignmentPage.fill_in_other_scope_filed(random_scope);
        createJobAssignmentPage.fill_in_deadline_date("17/08/2018");

    }

}

