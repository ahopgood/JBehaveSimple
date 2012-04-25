package com.alexander.concepts.web.jbehave.classtest.pages;

import org.jbehave.web.selenium.SeleniumPage;
import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

import static org.junit.Assert.*;

public class IndexPage extends SeleniumPage { 
	//extends WebDriverPage {
	//possibly create a class called abstract page here that holds operations common to all pages
	
	//Provides a facade to the selenium api
	public IndexPage(Selenium selenium, ConditionRunner conditionRunner){
		super(selenium, conditionRunner);
	}
	
//	private WebDriverProvider driverProvider;
//	public IndexPage(WebDriverProvider driverProvider){
//		super(driverProvider);
//	}
	
	//List of methods that represent our desired actions on a page
	public void open(){
		this.open("/");
		this.waitForPageToLoad();
	}
	
	public void verifyPage(){
		this.textIsVisible("Sample Web Application");
		assertEquals("Sample Web Application", this.getTitle());
	}

}
