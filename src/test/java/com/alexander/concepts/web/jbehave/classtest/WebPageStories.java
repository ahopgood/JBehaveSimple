package com.alexander.concepts.web.jbehave.classtest;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.web.selenium.PerStorySeleniumSteps;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumScreenshotOnFailure;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.jbehave.web.selenium.SeleniumSteps;

import com.alexander.concepts.web.jbehave.classtest.pages.PageFactory;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class WebPageStories extends JUnitStories {

    private Selenium selenium 				= SeleniumConfiguration.defaultSelenium();
    private ConditionRunner conditionRunner = SeleniumConfiguration.defaultConditionRunner(selenium);
    private PageFactory pages				= new PageFactory(selenium, conditionRunner);
    private SeleniumSteps lifecycleSteps 	= new PerStorySeleniumSteps(selenium);
    private SeleniumContext seleniumContext = new SeleniumContext();
	
    @Override
    public Configuration configuration(){
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new SeleniumConfiguration()
            .useSelenium(selenium) 
            .useSeleniumContext(seleniumContext)
            .useStepMonitor(new SeleniumStepMonitor(selenium, seleniumContext, new SilentStepMonitor()))
            .useStoryLoader(new LoadFromClasspath(embeddableClass))
            .useStoryReporterBuilder(new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                .withDefaultFormats()
                .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML));
    }
    
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new IndexPageSteps(pages),
                lifecycleSteps,
                new SeleniumScreenshotOnFailure(selenium));
    }
    
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(),
                new IndexPageSteps(pages),
                lifecycleSteps,
                new SeleniumScreenshotOnFailure(selenium)).createCandidateSteps();
    }
    
	@Override
	protected List<String> storyPaths() {
		return new StoryFinder()
        	.findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/*.story"), null);
	}

}
