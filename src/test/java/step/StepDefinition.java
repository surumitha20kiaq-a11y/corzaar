package step;


import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.pom_class;

public class StepDefinition  extends BaseClass {
	pom_class pom = new pom_class(driver);

	//	=================Login page======================================================

	@Given("user is on the Corzaar login page")
	public void user_is_on_the_corzaar_login_page() {
		enterApplicationUrl("https://dci3e266umn5y.cloudfront.net/");
		}
    @When("user enter invalid {string}")
	public void user_enter_invalid(String string) {
		waitForvisibility(pom.signinbutton());
		clickElement(pom.signinbutton());
		waitForvisibility(pom.fullnamefield());
		insertvalue(pom.fullnamefield(),string);
	}
	@Then("student not login with invalid Name")
	public void student_not_login_with_invalid_name() {
		System.out.println("Failed");
	}
    @When("user enter invalid mobile {string}")
	public void user_enter_invalid_mobile(String string) {
		waitForvisibility(pom.signinbutton());
		clickElement(pom.signinbutton());
		waitForvisibility(pom.mobilefield());
		insertvalue(pom.mobilefield(),string);
		scrollToElement(pom.sendonetimepasscodebutton());
		clickWithRetry(pom.sendonetimepasscodebutton());
		clickElement(pom.sendonetimepasscodebutton());
		waitForElementToClickable(pom.sendonetimepasscodebutton());
    }
	@Then("student not login with invalid mobile number")
	public void student_not_login_with_invalid_mobile_number() {
		waitForvisibility(pom.failedmessage());
		WebElement actual = pom.failedmessage();
		String actualmessage = actual.getText();
		Assert.assertTrue(actualmessage.contains("Failed to send OTP"));
	}
    @When("user enter valid mobile number and name")
	public void user_enter_valid_mobile_number_and_name() {
		waitForvisibility(pom.signinbutton());
		clickElement(pom.signinbutton());
		waitForvisibility(pom.Autofilldemo());
		clickElement(pom.Autofilldemo());
		scrollToElement(pom.sendonetimepasscodebutton());
		clickWithRetry(pom.sendonetimepasscodebutton());
		clickElement(pom.sendonetimepasscodebutton());
		waitForElementToClickable(pom.sendonetimepasscodebutton());
	}
	@When("user successfully verify the OTP")
	public void user_successfully_verify_the_otp() {
		
		clickElement(pom.autofillotpbutton());
		waitForElementToClickable(pom.autofillotpbutton());
		waitForvisibility(pom.verifyotpbutton());
		clickElement(pom.verifyotpbutton());
		waitForElementToClickable(pom.verifyotpbutton());
	}
	@Then("student successfully login and navigate to course explore page.")
	public void student_successfully_login_and_navigate_to_course_explore_page() {
		getapplicationTitle();
		System.err.println("user successfully login with valid credentials");
   }
	 //    ======================== courses module =====================================
	
	@When("user click the courses module")
	public void user_click_the_courses_module() {
		
		waitForvisibility(pom.explorecoursesbutton());
		clickWithRetry(pom.explorecoursesbutton());
	}
	@Then("user successfully navigate to the courses detailed page")
	public void user_successfully_navigate_to_the_courses_detailed_page() {
		String getapplicationTitle = getapplicationTitle();
		System.err.println(getapplicationTitle);
	}
	@When("user select the discipline dropdown values one by one")
	public void user_select_the_discipline_dropdown_values_one_by_one() throws InterruptedException {
		waitForvisibility(pom.explorecoursesbutton());
		clickWithRetry(pom.explorecoursesbutton());
		waitForvisibility(pom.disciplinedropdown());
		selectByVisibleText(pom.disciplinedropdown(),"Design");
		Thread.sleep(3000);
		Select select = new Select(pom.disciplinedropdown());
		System.out.println("selected values: "+select.getFirstSelectedOption().getText());
		int count =pom.disciplinedesign().size();
		System.out.println("Total courses displayed: "+ count);
		Assert.assertTrue(count > 0,"No design courses displayed");

	selectByVisibleText(pom.disciplinedropdown(),"Technology");
	Thread.sleep(3000);
	Select select1 = new Select(pom.disciplinedropdown());
	System.out.println("selected values: "+select1.getFirstSelectedOption().getText());
	int count1 =pom.disciplinetechnology().size();
	System.err.println("Total courses displayed: "+ count1);
	Assert.assertTrue(count > 0,"No design courses displayed");
	}
	@Then("user successfully select the values and view the relevent courses")
	public void user_successfully_select_the_values_and_view_the_relevent_courses() {
		System.out.println("successfully verify discipline dropdown values and relevent courses");
	}
	@When("user click the delivery format checkbox one by one and verify the displayed courses")
	public void user_click_the_delivery_format_checkbox_one_by_one_and_verify_the_displayed_courses() throws InterruptedException {
	         
		waitForvisibility(pom.explorecoursesbutton());
		clickWithRetry(pom.explorecoursesbutton());
		
			 waitForElementToClickable(pom.clickliveonline());
			 clickElement(pom.clickliveonline());
    Thread.sleep(3000);
    if(pom.getcoursestatuses().size()> 0) {
    	for (WebElement status : pom.getcoursestatuses()) {
    		Assert.assertEquals(status.getText().trim(),"📍 Live Online","live online filters showing incorrect courses");
    	}
    }
    else {
    	Assert.assertTrue(pom.emptycoursemessage().isDisplayed(),"Live online empty message not displayed");
    }
    
    Thread.sleep(2000);
   
    if(pom.clickliveonline().isSelected()) {
    	waitForElementToClickable(pom.clickliveonline());	
    }
   
  waitForElementToClickable(pom.clickpersonclassroom());
  clickElement(pom.clickpersonclassroom());
    initializeWait();
   List<WebElement> courses =pom.getcoursestatuses();
   if(courses.size()>0) {
	   String status = courses.get(0).getText();
	   System.out.println("course status: "+status);
   }
   
    else {
    	waitForvisibility(pom.emptycoursemessage());
    	String message =pom.emptycoursemessage().getText();
    	Assert.assertTrue(message.contains("No matching programs found"),"Expected empty message was not displayed");
    	System.err.println("pass : No In-person/classroom courses are available.Empty message displayed");
    }
   waitForElementToClickable(pom.clickhybrid());
   clickElement(pom.clickhybrid());
   initializeWait();
  List<WebElement> inpersoncourse =pom.getcoursestatuses();
  if(inpersoncourse.size()>0) {
	   String status1 = inpersoncourse.get(0).getText();
	   System.out.println("course status: "+status1);
  }
  
   else {
   	waitForvisibility(pom.emptycoursemessage());
   	String message =pom.emptycoursemessage().getText();
   	Assert.assertTrue(message.contains("No matching programs found"),"Expected empty message was not displayed");
   	System.err.println("pass :Hybrid courses are not available.Empty message displayed");
   }
   
	
  waitForElementToClickable(pom.clickselfpaced());
  clickElement(pom.clickselfpaced());
  initializeWait();
 List<WebElement> selfpacedcourse =pom.getcoursestatuses();
 if(selfpacedcourse.size()>0) {
	   String status2 = selfpacedcourse.get(0).getText();
	   System.out.println("course status: "+status2);
 }
 
  else {
  	waitForvisibility(pom.emptycoursemessage());
  	String message =pom.emptycoursemessage().getText();
  	Assert.assertTrue(message.contains("No matching programs found"),"Expected empty message was not displayed");
  	System.err.println("pass :In-person courses are not available.Empty message displayed");
  }
    }
	@Then("user successfully click the all delivery format checkbox")
	public void user_successfully_click_the_all_delivery_format_checkbox() {
		System.err.println("delivery format checkbox verified successfully");
	}
//	@When("user click the  program duration dropdown one by one and verify the displayed courses")
//	public void user_click_the_program_duration_dropdown_one_by_one_and_verify_the_displayed_courses() {
//		List<String> durationList = Arrays.asList(
//				"Any Duration",
//				"Under 1 month",
//				"1-3 months",
//				"3-6 months",
//				"6-12 months",
//				"1+ year"
//				);
//		for (String duration : durationList) {
//			selectByVisibleText(pom.programdurationdropdown(),duration);
//			int count = pom.durationcoursescard().size();
//			System.out.println("Selected Duration: " + duration);
//			if (count > 0) {
//				System.out.println("Course Count: " + count);
//				System.out.println("Courses displayed");
//			} else {
//				Assert.assertTrue(
//						pom.emptydropdownmessage().isDisplayed());
//				System.out.println("No matching courses found");
//				clickElement(pom.resetcoursesbutton());
//			}
//		}
//	}
//	@Then("user successfully click the all program duration dropdown")
//	public void user_successfully_click_the_all_program_duration_dropdown() {
//		System.out.println("successfully verify proggram  durationdropdown values");
//	}
//	@When("user click the free enrollment checkbox one by one and verify the displayed courses")
//	public void user_click_the_free_enrollment_checkbox_one_by_one_and_verify_the_displayed_courses() {
//		clickElement(pom.freeenrollmentcheckbox());
//	}
//	@Then("user successfully click the free enrollment checkbox")
//	public void user_successfully_click_the_free_enrollment_checkbox() {
//		int count1 = pom.freecoursescard().size();
//		System.out.println("Free courses count:"+ count1);
//		if(count1>0) {
//			for(WebElement course : pom.freecoursescard()) {
//				String courseText= course.getText();
//				Assert.assertTrue(courseText.contains("Free") );
//			}
//			System.out.println("Pass: only free courses displayed");
//		}else {
//			Assert.assertTrue(pom.emptydropdownmessage().isDisplayed());
//
//			System.out.println("No free courses available");
//		}
//	}
//	@When("user click the reset filter link")
//	public void user_click_the_reset_filter_link() {
//		clickElement(pom.clickresetlink());
//	}
//	@Then("All filters return to defalut value and display all default courses successfully.")
//	public void all_filters_return_to_defalut_value_and_display_all_default_courses_successfully() {
//		System.out.println("Reset all filters successfully");
//	}
//	@When("user click the sort filter values one by one and verify relevent courses displayed")
//	public void user_click_the_sort_filter_values_one_by_one_and_verify_relevent_courses_displayed() {
//		selectByvalue(pom.sortDropdownclick(),"Highest Rated");
//		
//		selectByvalue(pom.sortDropdownclick(),"Newest Releases");
//		selectByvalue(pom.sortDropdownclick(),"Price: Low to High");
//		selectByvalue(pom.sortDropdownclick(),"Price: High to Low");
//		selectByvalue(pom.sortDropdownclick(),"Most Enrolled");
//		}
//	@Then("user successfully select the All sort filter values")
//	public void user_successfully_select_the_all_sort_filter_values() {
//       System.out.println("verified sort dropdown");
//	}
//	@When("user enter the valid course name ,institute name and skills in search field")
//	public void user_enter_the_valid_course_name_institute_name_and_skills_in_search_field() {
//	 
//	
//  }
//  @Then("the field accept valid details and display relevant courses")
//	public void the_field_accept_valid_details_and_display_relevant_courses() {
//		
//	}
//
//	@When("student click the course and click enrollimmediately button")
//	public void student_click_the_course_and_click_enrollimmediately_button() {
//	    
//	}
//
//	@Then("student successfully click the enrollimmediately button")
//	public void student_successfully_click_the_enrollimmediately_button() {
//	    
//	}
//
//	@When("student select the favourite course and click add to card button")
//	public void student_select_the_favourite_course_and_click_add_to_card_button() {
//	}
//
//	@Then("student successfully click the add to card button")
//	public void student_successfully_click_the_add_to_card_button() {
//	}
//
//	@When("student select the free courses and enroll without payment.")
//	public void student_select_the_free_courses_and_enroll_without_payment() {
//	}
//
//	@Then("student successfully complete the free courses without payment.")
//	public void student_successfully_complete_the_free_courses_without_payment() {
//	    
//	}
//
//	@Then("student successfully verify the course modules")
//	public void student_successfully_verify_the_course_modules() {
//	    
//	}
//
//	@When("student click the Batches & schedules tab and select the scheduled batches")
//	public void student_click_the_batches_schedules_tab_and_select_the_scheduled_batches() {
//	    
//	}
//
//	@Then("student select the active batches successfully.")
//	public void student_select_the_active_batches_successfully() {
//	    
//	}
//
//	@When("student click the student review tab and verify displayed reviews")
//	public void student_click_the_student_review_tab_and_verify_displayed_reviews() {
//	    
//	}
//
//	@Then("student successfully verify student review tab")
//	public void student_successfully_verify_student_review_tab() {
//	  
//	}
//
//	@When("student Add their reviews in student tab")
//	public void student_add_their_reviews_in_student_tab() {
//	   
//	}
//
//	@Then("verify added reviews.")
//	public void verify_added_reviews() {
//	   
//	}
//
//	@When("student lick the offer modules and view the active coupons")
//	public void student_lick_the_offer_modules_and_view_the_active_coupons() {
//	    
//	}
//
//	@Then("student successfully verify the Active coupons.")
//	public void student_successfully_verify_the_active_coupons() {
//	   
//	}
//
//	@When("student click the my referral code button")
//	public void student_click_the_my_referral_code_button() {
//	    
//	}
//
//	@Then("Student navigate to referral page successfully.")
//	public void student_navigate_to_referral_page_successfully() {
//	    
//	}
//
//	@When("student click the verify module, enter valid certificate id and click verify credential status button")
//	public void student_click_the_verify_module_enter_valid_certificate_id_and_click_verify_credential_status_button() {
//	   
//	}
//
//	@Then("student successfully verify the certificate.")
//	public void student_successfully_verify_the_certificate() {
//	   
//	}
//
//	@When("student click the my learning space in top right")
//	public void student_click_the_my_learning_space_in_top_right() {
//	    
//	}
//
//	@Then("student successfully view  the enrolled courses and completed courses.")
//	public void student_successfully_view_the_enrolled_courses_and_completed_courses() {
//	   
//	}
//
//	@When("student click the wallet icon in top right")
//	public void student_click_the_wallet_icon_in_top_right() {
//	}
//
//	@Then("student successfully navigate to the Rewards Wallet & Referrals page.")
//	public void student_successfully_navigate_to_the_rewards_wallet_referrals_page() {
//	   
//	}
//
//	@When("student verify the wallet balance ,status, withdrawal amount.")
//	public void student_verify_the_wallet_balance_status_withdrawal_amount() {
//	    
//	}
//
//	@Then("student Successfully verify card")
//	public void student_successfully_verify_card() {
//	    
//	}
//
//	@When("student verify the referral code, copy button, referred friends")
//	public void student_verify_the_referral_code_copy_button_referred_friends() {
//	    
//	}
//
//	@When("student click up and  down arrow")
//	public void student_click_up_and_down_arrow() {
//	   
//	}
//
//	@Then("verify the minimum withdrawal amount")
//	public void verify_the_minimum_withdrawal_amount() {
//	   
//	}
//
//	@When("student enter the vald {string} in field")
//	public void student_enter_the_vald_in_field(String string) {
//	    
//	}
//
//	@Then("filed accept valid UPI ID")
//	public void filed_accept_valid_upi_id() {
//	   
//	}
//
//	@When("student click the Add to card icon in top right")
//	public void student_click_the_add_to_card_icon_in_top_right() {
//	   
//	}
//
//	@Then("student successfully view the Add to card page")
//	public void student_successfully_view_the_add_to_card_page() {
//	   
//	}
//
//	@When("student click  the user profile icon and click one by  one")
//	public void student_click_the_user_profile_icon_and_click_one_by_one() {
//	    
//	}
//
//	@Then("student successfully verify navigation after clicking the pages")
//	public void student_successfully_verify_navigation_after_clicking_the_pages() {
//	    
//	}
//
//	@When("student click the profile  icon and click my profile page")
//	public void student_click_the_profile_icon_and_click_my_profile_page() {
//	    
//	}
//
//	@When("change profile  values and save the changes")
//	public void change_profile_values_and_save_the_changes() {
//	}
//
//	@Then("student successfully verify the profile page")
//	public void student_successfully_verify_the_profile_page() {
//	   
//	}
//
//	@When("student click the signout button in profile page")
//	public void student_click_the_signout_button_in_profile_page() {
//	    
//	}
//
//	@Then("student successfully signout the account")
//	public void student_successfully_signout_the_account() {
//	    
//	}
//
//








} 


