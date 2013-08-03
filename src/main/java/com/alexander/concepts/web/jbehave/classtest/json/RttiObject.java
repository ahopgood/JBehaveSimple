package com.alexander.concepts.web.jbehave.classtest.json;

import java.io.Serializable;
import java.util.ArrayList;

public class RttiObject implements Serializable {

	private static final long serialVersionUID = -5834401343527050159L;
	String route;
	String status;
	ArrayList<RttiLeg> legs;
	
	public RttiObject(String route, String status, ArrayList<RttiLeg> legs){
		 this.route 	= route;
		 this.status 	= status;
		 this.legs 		= legs;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<RttiLeg> getLegs() {
		return legs;
	}

	public void setLegs(ArrayList<RttiLeg> legs) {
		this.legs = legs;
	}
	
	
}
