package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="SPXX")
@XmlAccessorType(XmlAccessType.FIELD)
public class SPXX {
	
	@XmlElement(name = "SP")
	private List<SP> SP=null;
	
	public List<SP> getSPXX() {
		return SP;
	}
	public void setSPXX(List<SP> sPXX) {
		this.SP = sPXX;
	//	Collections.copy(sPXX,this.SP);
	/*	SP.clear();
		for (int i=0;i<sPXX.size();i++)
		{
			SP sp=sPXX.get(i);
			SP.add(sp);
		}
		*/
	}
}
