package com.example.demo.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SB_FWSKKP_FPXX")
@XmlAccessorType(XmlAccessType.FIELD)
public class SB_FWSKKP_FPXX {
	
	@XmlElement(name = "SB_FWSKKP_MXXX")
   private List<SB_FWSKKP_MXXX> SB_FWSKKP_MXXX=null;

public List<SB_FWSKKP_MXXX> getSB_FWSKKP_MXXX() {
	return SB_FWSKKP_MXXX;
}

public void setSB_FWSKKP_MXXX(List<SB_FWSKKP_MXXX> sB_FWSKKP_MXXX) {
	SB_FWSKKP_MXXX = sB_FWSKKP_MXXX;
}
   
}
