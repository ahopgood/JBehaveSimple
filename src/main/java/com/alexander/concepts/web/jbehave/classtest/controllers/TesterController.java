package com.alexander.concepts.web.jbehave.classtest.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alexander.concepts.web.jbehave.classtest.json.RttiLeg;
import com.alexander.concepts.web.jbehave.classtest.json.RttiObject;
import com.alexander.concepts.web.jbehave.classtest.json.TestObject;

@RequestMapping("/testers/*")
@Controller
public class TesterController {
	
	@RequestMapping("/getRttiFileList")
	public String[] getRttiFileList(){
		return new String[]{"file1.csv","file2.csv"};
	}
	
	@RequestMapping("/getFile")
	public ArrayList<RttiObject> getRttiObjects(){
		ArrayList<RttiObject> rttis = new ArrayList<RttiObject>();
		return rttis;
	}
	
	@RequestMapping(value="/writestring", method=RequestMethod.POST)
	public @ResponseBody String writeString(@RequestBody String string){
		System.out.println("String arg "+string);
		return "testtesttest"+string;
	}
	
	@RequestMapping(value="/writestring", method=RequestMethod.GET)
	public @ResponseBody String writeString(){
		return "testtesttest";
	}
	
	@RequestMapping("/getView/{viewname}")
	public String test(@PathVariable String viewname){
		return viewname;
	}

	@RequestMapping(value="/jsonget", headers="Accept=application/json", method=RequestMethod.GET)
	public @ResponseBody RttiObject writeJson(){
		ArrayList<RttiLeg> legs = new ArrayList<RttiLeg>();
		legs.add(new RttiLeg("0","0"));
		return new RttiObject("Man-Eus","ONTIME",legs);
	}
	
	@RequestMapping(value="/json", method=RequestMethod.GET)
	public @ResponseBody TestObject readJson(){
//		ArrayList<RttiLeg> legs = new ArrayList<RttiLeg>();
//		legs.add(new RttiLeg("0","0"));
//		return new RttiObject("Man-Eus","ONTIME",legs);
		return new TestObject("test Object");
	}
	
	@RequestMapping(value="/json", method=RequestMethod.POST)
	public @ResponseBody TestObject readJson(@RequestBody String string){
		System.out.println("In readJson post");
		System.out.println(string);
		return new TestObject(string);
	}
}
