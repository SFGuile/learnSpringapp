package com.example.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SP")
@XmlAccessorType(XmlAccessType.FIELD)
public class SP {
   
	@XmlElement(name = "JE")
	private double JE;
	
	@XmlElement(name = "SL")
	private double SL;
	
	@XmlElement(name = "SE")
	private double SE;
	
	@XmlElement(name = "SPMC")
	private String SPMC;
	
	@XmlElement(name = "SPSM")
	private String SPSM;
	
	@XmlElement(name = "GGXH")
	private String GGXH;
	
	@XmlElement(name = "JLDW")
	private String JLDW;
	
	@XmlElement(name = "SHUL")
	private String SHUL;
	
	@XmlElement(name = "DJ")
	private String DJ;
	
	@XmlElement(name = "FLBM")
	private String FLBM;
	
	@XmlElement(name = "HSBZ")
	private String HSBZ; 
	
	
	public double getJE() {
		return JE;
	}
	public void setJE(double jE) {
		JE = jE;
	}
	public double getSL() {
		return SL;
	}
	public void setSL(double sL) {
		SL = sL;
	}
	public double getSE() {
		return SE;
	}
	public void setSE(double sE) {
		SE = sE;
	}
	public String getSPMC() {
		return SPMC;
	}
	public void setSPMC(String sPMC) {
		SPMC = sPMC;
	}
	public String getSPSM() {
		return SPSM;
	}
	public void setSPSM(String sPSM) {
		SPSM = sPSM;
	}
	public String getGGXH() {
		return GGXH;
	}
	public void setGGXH(String gGXH) {
		GGXH = gGXH;
	}
	public String getJLDW() {
		return JLDW;
	}
	public void setJLDW(String jLDW) {
		JLDW = jLDW;
	}
	public String getSHUL() {
		return SHUL;
	}
	public void setSHUL(String sHUL) {
		SHUL = sHUL;
	}
	public String getDJ() {
		return DJ;
	}
	public void setDJ(String dJ) {
		DJ = dJ;
	}
	public String getFLBM() {
		return FLBM;
	}
	public void setFLBM(String fLBM) {
		FLBM = fLBM;
	}
	public String getHSBZ() {
		return HSBZ;
	}
	public void setHSBZ(String hSBZ) {
		HSBZ = hSBZ;
	}
}
