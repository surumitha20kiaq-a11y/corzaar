package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pom_class {
	 WebDriver driver;
	    public pom_class(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//	    ==============Locators====================================
	      @FindBy(xpath="//span[contains(text(),'Sign In')]")
	     private WebElement signin;
	      
	      @FindBy(xpath="//button[contains(text(),'Auto-Fill Demo')]")
	      private WebElement autofilldemo;
	      
	      @FindBy(xpath="//button[@type='submit']")
	      private WebElement sendonetimepasscode;
	      
	      @FindBy(xpath="//button[contains(text(),'Auto')]")
	      private WebElement autofillotp;
	      
	      @FindBy(xpath="//span[contains(text(),'Verify ')]")
	      private WebElement verifyotp;
	       
	      @FindBy(xpath="//input[@type='tel']")
	      private WebElement mobile;
	      
	      @FindBy(xpath="//button[@type='button']/div")
	      private WebElement profile;
	      
          @FindBy(xpath="//span[contains(text(),'Failed ')]")
	      private WebElement errormessage;
	  
	      @FindBy(id="full-name-(optional-for-existing-learners)")
	      private WebElement fullname;
	      
	      @FindBy(xpath="//a[normalize-space()='Courses']")	
	      private WebElement courses;
	     
	      @FindBy(xpath="//input[@placeholder='Search courses, skills, institutes...']")
	      private WebElement search;
	      
	      @FindBy(xpath="//label[text()='Discipline']/following-sibling::select")
	      private WebElement discipline;
	      
	      @FindBy(xpath="//span[contains(text(),'Design')]")
	      private List<WebElement> design;
	      
	      @FindBy(xpath="//span[contains(text(),'Technology')]")
	      private List<WebElement> technologyname;
	      
	      @FindBy(xpath="//button[contains(normalize-space(),'Explore Courses')]")
	      private WebElement explorecourses;
	      
	      @FindBy(xpath="//span[contains(text(),'Technology')]")
	      private WebElement technology;
	      
	      
	      @FindBy(xpath="//h3[contains(text(),'Data Analytics with Python')]")
	      private WebElement dataanalytics;
	      
	      @FindBy(xpath="//div[@class='w-5 h-5 rounded-md border transition-all flex items-center justify-center border-slate-300 dark:border-slate-600 bg-white dark:bg-dark-surface peer-checked:bg-brand peer-checked:border-brand text-white peer-focus:ring-2 peer-focus:ring-brand/20']")
	      private List<WebElement> allcheckboxes;
	      
	      @FindBy(xpath="//select[.//option[contains(.,'Any Duration')]]")
	      private WebElement programduration;
	      
	      @FindBy(xpath="//h3[contains(text(),'No matching programs found')]")
	      private WebElement emptymessage;
	      
	      @FindBy(xpath="//span[contains(text(),'Reset All Filters')]")
	      private WebElement resetbutton;
	      
	      @FindBy(xpath="//span[@class='bg-surface-alt dark:bg-slate-800 px-2 py-0.5 rounded-md']")
	      private List<WebElement> durationcourses;
	      
	      @FindBy(xpath="//*[@id=\"root\"]/div[1]/main/div/div[2]/aside/div/div[5]/div/label/div[1]/div")
	      private WebElement freeenrollment;
	      
	      @FindBy(xpath="//span[contains(text(),'Free')]")
	      private List<WebElement> freecourses;
	      
	      @FindBy(xpath="//button[contains(text(),'Reset')]")
	      private WebElement resetlink;
	      
	      @FindBy(xpath="//*[@id=\"root\"]/div[1]/main/div/div[2]/main/div[1]/div/select")
	      private WebElement sortfilter;
	      
	      @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div/div[2]/main/div[1]/div/select")
	      WebElement sortDropdown;

	      @FindBy(xpath = "//h3[contains(text(),'No matching ')]")
	     WebElement emptycourse;
	      
	      
//	      ===============Getters=======================================
	      public WebElement signinbutton() {
	    	  return signin;
	      }
	      public WebElement Autofilldemo() {
	    	  return autofilldemo;
	      }
	      public WebElement sendonetimepasscodebutton() {
	    	  return sendonetimepasscode;
	      }
	      public WebElement autofillotpbutton() {
	    	  return autofillotp;
	      }
	      public WebElement verifyotpbutton() {
	    	  return verifyotp;
	      }
	      public WebElement mobilefield() {
	    	  return mobile;
	      }
	      public WebElement profileicon() {
	    	  return profile;
	      }
	      public WebElement failedmessage() {
	    	  return errormessage;
	      }
	      public WebElement fullnamefield() {
	    	  return fullname;
	      }
	      public WebElement  coursesmodule() {
	    	  return courses;
	      }
	      public WebElement  searchfield() {
	    	  return search;
	      }
	     
	      public WebElement disciplinedropdown() {
	    	  return discipline ;
	      }
	      public WebElement dataanalyticscourse() {
	    	  return dataanalytics;
	      }
	      public List<WebElement> disciplinedesign() {
	    	  return design;
	      }
	      public List<WebElement> disciplinetechnology() {
	    	  return technologyname ;
	      }
	      public WebElement explorecoursesbutton() {
	    	  return explorecourses;
	      }
	      public WebElement disciplinetech() {
	    	  return technology;
	      }
	      public List<WebElement> getallcheckboxes() {
	    	  return allcheckboxes;
	      }
	      public WebElement programdurationdropdown(){
	    	  return programduration;
	      }
	      public WebElement emptydropdownmessage(){
	    	  return emptymessage;
	      }
	      public WebElement resetcoursesbutton(){
	    	  return resetbutton;
	      }
	      public List<WebElement> durationcoursescard(){
	    	  return durationcourses;
	      }
	      public WebElement freeenrollmentcheckbox(){
	    	  return freeenrollment;
	      }
	      public List<WebElement> freecoursescard(){
	    	  return freecourses;
	      }
	      public WebElement clickresetlink(){
	    	  return resetlink;
	      }
	      public WebElement clicksortfilter(){
	    	  return sortfilter;
	      }
	      public WebElement sortDropdownclick(){
	    	  return sortDropdown;
	      }
	      public WebElement emptycoursemessage(){
	    	  return emptycourse;
	      }
	    

	     

	     


}
