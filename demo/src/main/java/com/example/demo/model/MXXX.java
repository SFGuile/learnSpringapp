package com.example.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "MXXX")
@XmlAccessorType(XmlAccessType.FIELD)
public class MXXX {
  
	 @XmlElement(name = "SB_FWSKKP_MXXX_XFDZDH")
	private String SB_FWSKKP_MXXX_XFDZDH;
	 
	 @XmlElement(name = "SB_FWSKKP_MXXX_XFYHZH")
	private String SB_FWSKKP_MXXX_XFYHZH;
	
	public String getSB_FWSKKP_MXXX_XFDZDH() {
		return SB_FWSKKP_MXXX_XFDZDH;
	}
	public void setSB_FWSKKP_MXXX_XFDZDH(String sB_FWSKKP_MXXX_XFDZDH) {
		SB_FWSKKP_MXXX_XFDZDH = sB_FWSKKP_MXXX_XFDZDH;
	}
	public String getSB_FWSKKP_MXXX_XFYHZH() {
		return SB_FWSKKP_MXXX_XFYHZH;
	}
	public void setSB_FWSKKP_MXXX_XFYHZH(String sB_FWSKKP_MXXX_XFYHZH) {
		SB_FWSKKP_MXXX_XFYHZH = sB_FWSKKP_MXXX_XFYHZH;
	}
	
	
}
