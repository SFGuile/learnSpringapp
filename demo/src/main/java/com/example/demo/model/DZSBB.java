package com.example.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DZSBB")
@XmlAccessorType(XmlAccessType.FIELD)
public class DZSBB {
   
	 @XmlElement(name = "SB_FWSKKP")
	private SB_FWSKKP SB_FWSKKP;

	public SB_FWSKKP getSB_FWSKKP() {
		return SB_FWSKKP;
	}

	public void setSB_FWSKKP(SB_FWSKKP sB_FWSKKP) {
		SB_FWSKKP = sB_FWSKKP;
	}
}
