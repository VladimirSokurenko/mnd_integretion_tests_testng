package integrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import content_creator_pages.*;
import web_driver_setup.WebDriverSetup;

    /**
    @Test(dependsOnMethods = "{test_case_1, tes_case_2}")
    this is dependence, for grouping the test cases */

    /**
    Assertion usage hint
     Assert.assertEquals(Sting a, String a1, "also some assertion description could be add, displayed in case of test failure");

     <============>

     String a = "test is the test"
     Assert.assertTrue(a.contains("test")); == true

     Soft assertion
        SoftAssert s = new SoftAssert();
        s.assertEquals(12, 13);
        s.assertAll();

     */




public class ContentCreatorTests extends WebDriverSetup {

    @Test(priority = -2, description = "This test will verify login feature for Content Creator")
    public void login_as_content_creator_test(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
    }

    @Test(priority = -1, description = "check logout functionality")
    public void log_out_test(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        contentMarketMenuPage.log_out();
        landingPage.verify_login_button_present("Log In");

    }

    @Test(priority = 1, description = "check main navigation menu interactions")
    public void main_navigation_menu_interaction(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        AboutPage aboutPage = PageFactory.initElements(driver, AboutPage.class);
        AssignmentsPage assignmentsPage = PageFactory.initElements(driver, AssignmentsPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("assignments");
        assignmentsPage.verify_heading_text("Available assignments");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("about");
        aboutPage.verify_heading_text("About Content Market");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("assignments");
        assignmentsPage.verify_heading_text("Available assignments");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("about");
        aboutPage.verify_heading_text("About Content Market");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("assignments");
        assignmentsPage.verify_heading_text("Available assignments");


    }

    @Test(priority = 2, description = "verify view as visitor feature")
    public void view_as_visitor_test() {
        ViewAsVisitorPage viewAsVisitorPage = PageFactory.initElements(driver, ViewAsVisitorPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        portfolioPage.click_view_as_visitor_btn();
        portfolioPage.verify_portfolio_sections_present();
        viewAsVisitorPage.click_back_btn();
        portfolioPage.verify_portfolio_sections_present();
    }

    @Test(priority = 3, description = "verify edit portfolio")
    public void edit_portfolio_test() throws InterruptedException{
        EditPortfolioPage editPortfolioPage = PageFactory.initElements(driver, EditPortfolioPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.click_edit_portfolio_btn();
        editPortfolioPage.agile_avatar_upload("/home/alexander/Desktop/testng.jpg");
        editPortfolioPage.agile_cover_image_upload("/home/alexander/Desktop/coverimg.jpg");
        String random_name = get_random_text("name:");
        editPortfolioPage.fill_in_name_field(random_name);
        String random_title = get_random_text("title:");
        editPortfolioPage.fill_in_title_filed(random_title);
        String random_about = get_random_text("About me:");
        editPortfolioPage.fill_in_about_field(random_about);
        editPortfolioPage.click_save_portfolio_btn();
        portfolioPage.verify_name_text(random_name);
        portfolioPage.verify_title_text(random_title);
        portfolioPage.verify_about_text(random_about);
        portfolioPage.verify_avatar_is_displayed();
        portfolioPage.verify_cover_image_is_displayed();

    }

    @Test(priority = 4, description = "verify create portfolio item") // does not work - done
    public void create_portfolio_item() throws InterruptedException{
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        NewPortfolioItemPage newPortfolioItemPage = PageFactory.initElements(driver, NewPortfolioItemPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.click_add_project_btn();
        String random_title = get_random_text("test: ");
        newPortfolioItemPage.fill_in_title(random_title);
        String random_description = get_random_text("description: ");
        newPortfolioItemPage.fill_in_description(random_description);
        newPortfolioItemPage.fill_in_url("www.youtube.com");
        newPortfolioItemPage.upload_portfolio_item_image("/home/alexander/Desktop/testng.jpg");
        newPortfolioItemPage.click_save_portfolio_item_btn();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.verify_portfolio_item_title_text(random_title);
        portfolioPage.verify_portfolio_item_description_text(random_description);
        portfolioPage.verify_portfolio_item_cover_image();
    }

    @Test(priority = 5, description = "verify ability to edit portfolio item") // change - done
    public void edit_portfolio_item() throws InterruptedException{
        EditPortfolioPage editPortfolioPage = PageFactory.initElements(driver, EditPortfolioPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        NewPortfolioItemPage newPortfolioItemPage = PageFactory.initElements(driver, NewPortfolioItemPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.click_edit_portfolio_item_btn();
        newPortfolioItemPage.remove_text_fom_title();
        String random_title = get_random_text("title_edit: ");
        newPortfolioItemPage.fill_in_title(random_title);
        newPortfolioItemPage.remove_text_fom_description();
        String random_description = get_random_text("description_edit: ");
        newPortfolioItemPage.fill_in_description(random_description);
        newPortfolioItemPage.remove_text_fom_url();
        newPortfolioItemPage.fill_in_url("https://javarush.ru/");
        newPortfolioItemPage.remove_portfolio_item_image_if_present();
        newPortfolioItemPage.click_save_portfolio_item_btn();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.verify_portfolio_item_title_text(random_title);
        portfolioPage.verify_portfolio_item_description_text(random_description);
    }

    @Test(priority = 6, description = "checks ability to view portfolio item") // change - done
    public void view_portfolio_item() throws InterruptedException{
        NewPortfolioItemPage newPortfolioItemPage = PageFactory.initElements(driver, NewPortfolioItemPage.class);
        ViewPortfolioItemPage viewPortfolioItemPAge = PageFactory.initElements(driver, ViewPortfolioItemPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.click_add_project_btn();
        String custom_title = "Title: view PI";
        String custom_description = "Description: view PI";
        newPortfolioItemPage.fill_in_title(custom_title);
        newPortfolioItemPage.fill_in_description(custom_description);
        newPortfolioItemPage.upload_portfolio_item_image("/home/alexander/Desktop/coverimg.jpg");
        newPortfolioItemPage.upload_portfolio_item_image("/home/alexander/Desktop/second_test_Image.jpg");
        newPortfolioItemPage.click_save_portfolio_item_btn();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.click_portfolio_item_card();
        viewPortfolioItemPAge.verify_title_is_present();
        viewPortfolioItemPAge.verify_title_text(custom_title);
        viewPortfolioItemPAge.verify_description_text(custom_description);
        viewPortfolioItemPAge.click_on_image_thumbnail();
        viewPortfolioItemPAge.click_on_next_image_btn();
        viewPortfolioItemPAge.click_on_previous_image_btn();
        viewPortfolioItemPAge.click_on_close_gallery();
        viewPortfolioItemPAge.click_profile_breadcrumbs();
        portfolioPage.verify_portfolio_sections_present();

    }

    @Test(priority = 7, description = "checks ability to delete PI")
    public void delete_portfolio_item() throws InterruptedException{
        NewPortfolioItemPage newPortfolioItemPage = PageFactory.initElements(driver, NewPortfolioItemPage.class);
        ViewPortfolioItemPage viewPortfolioItemPAge = PageFactory.initElements(driver, ViewPortfolioItemPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.click_add_project_btn();
        String random_title = get_random_text("Title: ");
        String random_description = get_random_text("Description: ");
        newPortfolioItemPage.fill_in_title(random_title);
        newPortfolioItemPage.fill_in_description(random_description);
        newPortfolioItemPage.click_save_portfolio_item_btn();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.click_edit_portfolio_item_btn();
        newPortfolioItemPage.click_delete_btn();
        newPortfolioItemPage.click_delete_confirmation_btn();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.verify_portfolio_item_deleted(random_title);

    } // done

    @Test(priority = 8, description = "checks portfolio item link transferring")
    public void portfolio_item_link_transferring() throws InterruptedException{
        NewPortfolioItemPage newPortfolioItemPage = PageFactory.initElements(driver, NewPortfolioItemPage.class);
        ViewPortfolioItemPage viewPortfolioItemPAge = PageFactory.initElements(driver, ViewPortfolioItemPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.click_add_project_btn();
        newPortfolioItemPage.fill_in_title("title");
        newPortfolioItemPage.fill_in_description("description");
        newPortfolioItemPage.fill_in_url("codecademy.com");
        newPortfolioItemPage.click_save_portfolio_item_btn();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.click_portfolio_item_card();
        viewPortfolioItemPAge.click_on_url_link();
        String mnd_window = driver.getWindowHandle();
        viewPortfolioItemPAge.switch_to_new_browser_tab();
        viewPortfolioItemPAge.wait_for_transfer();
        viewPortfolioItemPAge.verify_link_transferring("Learn to Code - for Free | Codecademy");
        viewPortfolioItemPAge.navigate_to_tab(mnd_window);

    } // change

    @Test(priority = 9, description = "checks ability to remove avatar")
    public void delete_portfolio_avatar_image() throws InterruptedException{
        EditPortfolioPage editPortfolioPage = PageFactory.initElements(driver, EditPortfolioPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.click_edit_portfolio_btn();
        editPortfolioPage.agile_avatar_upload("/home/alexander/Desktop/island.jpg");
        editPortfolioPage.click_save_portfolio_btn();
        portfolioPage.click_edit_portfolio_btn();
        editPortfolioPage.remove_avatar_image();
        editPortfolioPage.click_save_portfolio_btn();
        portfolioPage.click_edit_portfolio_btn();
        editPortfolioPage.verify_avatar_is_not_present();
    }

    @Test(priority = 10, description = "checks ability to remove cover image")
    public void delete_portfolio_cover_image() throws InterruptedException {
        EditPortfolioPage editPortfolioPage = PageFactory.initElements(driver, EditPortfolioPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.click_edit_portfolio_btn();
        editPortfolioPage.agile_cover_image_upload("/home/alexander/Desktop/coverimg.jpg");
        editPortfolioPage.click_save_portfolio_btn();
        portfolioPage.click_edit_portfolio_btn();
        editPortfolioPage.remove_cover_image();
        editPortfolioPage.click_save_portfolio_btn();
        portfolioPage.click_edit_portfolio_btn();
        editPortfolioPage.verify_cover_image_is_not_present();

    } // change

    @Test(priority = 11, description = "checks sub-navigation menu interactions")
    public void sub_navigation_interactions(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        SubNavigationMenuPage subNavigationMenuPage = PageFactory.initElements(driver, SubNavigationMenuPage.class);
        AboutPage aboutPage = PageFactory.initElements(driver, AboutPage.class);
        AssignmentsPage assignmentsPage = PageFactory.initElements(driver, AssignmentsPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("assignments");
        subNavigationMenuPage.click_on_portfolio_tab();
        portfolioPage.verify_portfolio_sections_present();
        subNavigationMenuPage.click_on_about_tab();
        aboutPage.verify_heading_text("About Content Market");
        aboutPage.verify_infobox_present();
        subNavigationMenuPage.click_on_portfolio_tab();
        portfolioPage.verify_portfolio_sections_present();
        subNavigationMenuPage.click_on_assignments_tab();
        assignmentsPage.verify_heading_text("Available assignments");
        subNavigationMenuPage.click_on_about_tab();
        aboutPage.verify_heading_text("About Content Market");
        aboutPage.verify_infobox_present();
        subNavigationMenuPage.click_on_assignments_tab();
        assignmentsPage.verify_heading_text("Available assignments");



    }

    @Test(priority = 12, description = "checks filtering section")
    public void check_assignments_selector(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        AssignmentsPage assignmentsPage = PageFactory.initElements(driver, AssignmentsPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("assignments");
        assignmentsPage.verify_heading_text("Available assignments");
        assignmentsPage.click_on_services_selector();
        assignmentsPage.verify_pr_content_present("PR Content");
        assignmentsPage.click_on_languages_selector();
        assignmentsPage.verify_main_languages("Swedish", "Finnish");

    }

    @Test(priority = 13, description = "checks apply for a job")
    public void apply_job_assignment() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        AssignmentsPage assignmentsPage = PageFactory.initElements(driver, AssignmentsPage.class);
        ViewAssignmentPage viewAssignmentPage = PageFactory.initElements(driver, ViewAssignmentPage.class);
        ApplyForAssignmentPage applyForAssignmentPage = PageFactory.initElements(driver, ApplyForAssignmentPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("assignments");
        assignmentsPage.scroll_to_assignments_list();
        assignmentsPage.click_on_view_assignment_btn();
        viewAssignmentPage.scroll_to_apply_for_assignment_btn();
        viewAssignmentPage.click_on_apply_for_assignment_btn();
        applyForAssignmentPage.fill_in_subject_field("automation_test_subj");
        applyForAssignmentPage.fill_in_message_field("automation_test_message");
        applyForAssignmentPage.click_on_contact_button();
        assignmentsPage.verify_message_was_sent("The message was successfully sent");
        assignmentsPage.verify_heading_text("Available assignments");

    } // change

    @Test(priority = 14, description = "checks unfinished profile")
    public void unfinished_profile_message_appearing() throws InterruptedException{
        ViewAssignmentPage viewAssignmentPage = PageFactory.initElements(driver, ViewAssignmentPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        EditPortfolioPage editPortfolioPage = PageFactory.initElements(driver, EditPortfolioPage.class);
        AssignmentsPage assignmentsPage = PageFactory.initElements(driver, AssignmentsPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        portfolioPage.click_edit_portfolio_btn();
        editPortfolioPage.remove_title_text();
        editPortfolioPage.click_save_portfolio_btn();
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("assignments");
        assignmentsPage.scroll_to_assignments_list();
        assignmentsPage.click_on_view_assignment_btn();
        viewAssignmentPage.click_on_apply_for_assignment_btn();
        driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div/div/div/div[2]/button[2]")).click();
        editPortfolioPage.verify_edit_portfolio_heading("Edit your portfolio");
        editPortfolioPage.fill_in_title_filed("test");
        editPortfolioPage.click_save_portfolio_btn();
        portfolioPage.verify_portfolio_sections_present();

    } // change

    @Test(priority = 15, description = "check clearing filters via no result message button") // need to be implemented later ;-)
    public void clear_filters_via_zero_state_message(){

    }

    @Test(priority = 16, description = "checks view portfolio item in view as visitor mode")
    public void view_portfolio_item_in_view_as_visitor() throws InterruptedException{
        ViewPortfolioItemPage viewPortfolioItemPAge = PageFactory.initElements(driver, ViewPortfolioItemPage.class);
        NewPortfolioItemPage newPortfolioItemPage = PageFactory.initElements(driver,NewPortfolioItemPage.class);
        ViewAsVisitorPage viewAsVisitorPage = PageFactory.initElements(driver, ViewAsVisitorPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ContentMarketMenuPage contentMarketMenuPage = PageFactory.initElements(driver, ContentMarketMenuPage.class);
        PortfolioPage portfolioPage = PageFactory.initElements(driver, PortfolioPage.class);
        go_to_the_site("staging");
        loginPage.login_as("test3", "123123qwe");
        contentMarketMenuPage.open_cm_menu();
        contentMarketMenuPage.navigate_to("portfolio");
        portfolioPage.verify_portfolio_sections_present();
        portfolioPage.scroll_to_portfolio_items_section();
        portfolioPage.click_add_project_btn();
        String custom_title = "Title: view PI";
        String custom_description = "Description: view PI";
        newPortfolioItemPage.fill_in_title(custom_title);
        newPortfolioItemPage.fill_in_description(custom_description);
        newPortfolioItemPage.upload_portfolio_item_image("/home/alexander/Desktop/coverimg.jpg");
        newPortfolioItemPage.upload_portfolio_item_image("/home/alexander/Desktop/second_test_Image.jpg");
        newPortfolioItemPage.click_save_portfolio_item_btn();
        portfolioPage.verify_portfolio_sections_present();
        portfolioPage.click_view_as_visitor_btn();
        portfolioPage.verify_portfolio_sections_present();
        viewAsVisitorPage.click_on_portfolio_item_card();
        viewPortfolioItemPAge.verify_title_is_present();
        viewPortfolioItemPAge.verify_title_text(custom_title);
        viewPortfolioItemPAge.verify_description_text(custom_description);
        viewPortfolioItemPAge.click_on_image_thumbnail();
        viewPortfolioItemPAge.click_on_next_image_btn();
        viewPortfolioItemPAge.click_on_previous_image_btn();
        viewPortfolioItemPAge.click_on_close_gallery();
        viewPortfolioItemPAge.click_profile_breadcrumbs();
        portfolioPage.verify_portfolio_sections_present();
    }





















}
