package com.example.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SB_FWSKKP")
@XmlAccessorType(XmlAccessType.FIELD)
public class SB_FWSKKP {
   
	 @XmlElement(name = "SB_FWSKKP_BTXX")
	private SB_FWSKKP_BTXX SB_FWSKKP_BTXX;
	 
	 @XmlElement(name = "SB_FWSKKP_FPXX")
	private SB_FWSKKP_FPXX SB_FWSKKP_FPXX;
	
	public SB_FWSKKP_BTXX getSB_FWSKKP_BTXX() {
		return SB_FWSKKP_BTXX;
	}
	public void setSB_FWSKKP_BTXX(SB_FWSKKP_BTXX sB_FWSKKP_BTXX) {
		SB_FWSKKP_BTXX = sB_FWSKKP_BTXX;
	}
	public SB_FWSKKP_FPXX getSB_FWSKKP_FPXX() {
		return SB_FWSKKP_FPXX;
	}
	public void setSB_FWSKKP_FPXX(SB_FWSKKP_FPXX sB_FWSKKP_FPXX) {
		SB_FWSKKP_FPXX = sB_FWSKKP_FPXX;
	}
	
}
