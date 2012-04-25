package com.alexander.concepts.web.jbehave.classtest;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import com.alexander.concepts.web.jbehave.classtest.pages.PageFactory;



public class IndexPageSteps {
	
	private final PageFactory pages;
	
	public IndexPageSteps(PageFactory pages){
		this.pages = pages;
	}
	
	@Given("Given the user opens the index page")
	public void userOpensIndexPage(){
		pages.indexPage().open();
	}
	
	@Then("Then the index page should be displayed")
	public void indexPageDisplayed(){
		pages.indexPage().verifyPage();
		
	}
	

}
