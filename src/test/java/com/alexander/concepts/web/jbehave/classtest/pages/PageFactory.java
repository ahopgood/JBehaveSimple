package com.alexander.concepts.web.jbehave.classtest.pages;

import org.jbehave.web.selenium.WebDriverProvider;

import com.alexander.concepts.web.jbehave.classtest.IndexPageSteps;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class PageFactory {

	private Selenium selenium;
	private ConditionRunner conditionRunner;
	
	private WebDriverProvider driverProvider;
	private IndexPage indexPage;
//	private IndexPageSteps indexPageSteps;
	
	public PageFactory(WebDriverProvider driverProvider){
		this.driverProvider = driverProvider;
	}
	
	public PageFactory(Selenium selenium, ConditionRunner conditionRunner){
		this.selenium 			= selenium;
		this.conditionRunner 	= conditionRunner;
	}

	public IndexPage indexPage(){
		if (indexPage == null){
			indexPage = new IndexPage(selenium, conditionRunner);
		}
		return indexPage;
	}
}
