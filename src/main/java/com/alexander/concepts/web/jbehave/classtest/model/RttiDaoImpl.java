package com.alexander.concepts.web.jbehave.classtest.model;

import java.util.ArrayList;
import java.util.List;

import com.alexander.concepts.web.jbehave.classtest.json.RttiLeg;
import com.alexander.concepts.web.jbehave.classtest.json.RttiObject;

public class RttiDaoImpl implements RttiDao {

	public List<RttiObject> getRttiList() {
		ArrayList<RttiLeg> legs = new ArrayList<RttiLeg>();
		legs.add(new RttiLeg("0","0"));
		legs.add(new RttiLeg("5","5"));
		legs.add(new RttiLeg("0","5"));
		legs.add(new RttiLeg("6","0"));
		RttiObject rtti1 = new RttiObject("Man-Eus","ONTIME",legs);
		ArrayList<RttiObject> objects = new ArrayList<RttiObject>();
		objects.add(rtti1);
		return objects;
	}
}
