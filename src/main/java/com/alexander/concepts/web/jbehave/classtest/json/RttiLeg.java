package com.alexander.concepts.web.jbehave.classtest.json;

import java.io.Serializable;

public class RttiLeg implements Serializable {

	private static final long serialVersionUID = -8922145152981999636L;
	private String arrival;
	private String departure;
	
	public RttiLeg(String arrival, String departure){
		this.arrival 	= arrival;
		this.departure 	= departure;
	}
	
	public String getArrival(){
		return this.arrival;
	}
	
	public String getDeparture(){
		return this.departure;
	}
}
