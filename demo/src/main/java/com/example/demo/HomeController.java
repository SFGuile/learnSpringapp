package com.example.demo;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.springframework.core.io.InputStreamResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.DZSBB;
import com.example.demo.model.ExcelContents;
import com.example.demo.model.MXXX;
import com.example.demo.model.SB_FWSKKP;
import com.example.demo.model.SB_FWSKKP_BTXX;
import com.example.demo.model.SB_FWSKKP_FPXX;
import com.example.demo.model.SB_FWSKKP_MXXX;
import com.example.demo.model.SP;
import com.example.demo.model.SPXX;


@Controller
public class HomeController {
    
	@RequestMapping( value={"/","/home"})
	public String home(){
		
		System.out.print("hi");
		return "home";
	}
	
	@RequestMapping( value={"/releasenote"})
	public String releasenote(){
		
		System.out.print("hi");
		return "releasenote";
	}
	
	
	
	 
	@PostMapping("/uploadfile")
	 public   ModelAndView uploadFile(@RequestParam("file") MultipartFile file,
	    		@RequestParam(name="address", required = false) String myaddress,
	    		@RequestParam(name="bankaccount", required = false) String mybankaccount,
	    		@RequestParam(name="kpr", required = false) String mykpr,
	    		@RequestParam(name="skr", required = false) String myskr,
	    		@RequestParam(name="fhr", required = false) String myfhr) {

		String TYPE = "application/vnd.ms-excel";
		
		if (TYPE.equals(file.getContentType())) {
	        try {
	    
	        	
	          List<ExcelContents> tempExcelcontentList = new ArrayList<ExcelContents>();
	           HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
	            
	      	   
	           String consequencemsg="";
	           int errsheetcount=0;
	           int recordscount=0;
	           int sheetscount=0;
	           int invoiceindex=0;
	           
	           for (int  j= 0; j < workbook.getNumberOfSheets(); j++) {
	            	 HSSFSheet worksheet = workbook.getSheetAt(j);
	            	 String sheetname=workbook.getSheetName(j);
	            	 short notoligable=0;
	      	    for(int i=0;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	      	    	 HSSFRow row=worksheet.getRow(i);
	      	    	if (i==0)
	      	    	{
	      	    		
	      	    		String title=row.getCell(0).getStringCellValue();
	      	    		String comparestr="??????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
	      	    		 
	      	    			consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(1).getStringCellValue();
	      	    		comparestr="????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
	      	    			consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel?????????????????????</br> ";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(2).getStringCellValue();
	      	    		comparestr="????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
	      	    			consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(3).getStringCellValue();
	      	    		comparestr="???????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	    	 	{
	      	    			consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(4).getStringCellValue();
	      	    		comparestr="????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
	      	    			consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel?????????????????????</br> ";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(5).getStringCellValue();
	      	    		comparestr="???????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
	      	    			consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(6).getStringCellValue();
	      	  		    comparestr="????????????";
	      	  		    if (!title.trim().equals(comparestr))
	      	    		{
	  	    		  	    consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	  	    			    errsheetcount++;
	  	    			  notoligable=1;
	  	    			    break;
	      	    		}
	      	    		
	      	    		
	  	    		    title=row.getCell(7).getStringCellValue();
	  	    		    comparestr="??????????????????";
	  	    		    if (!title.trim().equals(comparestr))
	      	    	 
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
		    		    
	      	    		title=row.getCell(8).getStringCellValue();
	      	    	    comparestr="??????????????????";
	      	    	  if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(9).getStringCellValue();
	      	    	    comparestr="??????";
	      	    	  if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel?????????????????????</br> ";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(10).getStringCellValue();
	      	    		comparestr="????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	      		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(11).getStringCellValue();
	      	    	    comparestr="??????";
	      	    	  if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel?????????????????????</br> ";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(12).getStringCellValue();
	      	    	    comparestr="??????";
	      	    	  if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(13).getStringCellValue();
	      	    		comparestr="??????????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(14).getStringCellValue();
	      	    		comparestr="??????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(15).getStringCellValue();
	      	    	    comparestr="????????????";
	      	    	    if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(16).getStringCellValue();
	      	    		comparestr="????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel?????????????????????</br> ";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(17).getStringCellValue();
	      	    		comparestr="????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(18).getStringCellValue();
	      	    	    comparestr="??????????????????";
	      	    	  if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(19).getStringCellValue();
	      	    		comparestr="????????????";
	      	    		if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
	      	    		title=row.getCell(20).getStringCellValue();
	      	    	    comparestr="????????????";
	      	    	    if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
		    		    title=row.getCell(21).getStringCellValue();
	      	    	    comparestr="????????????????????????";
	      	    	    if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel?????????????????????</br> ";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
		    		    
		    		    title=row.getCell(22).getStringCellValue();
	      	    	    comparestr="??????";
	      	    	    if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
		    		    title=row.getCell(23).getStringCellValue();
	      	    	    comparestr="??????";
	      	    	    if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel?????????????????????</br> ";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
		    		    title=row.getCell(24).getStringCellValue();
	      	    	    comparestr="??????";
	      	    	    if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel?????????????????????</br> ";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
	      	    		
		    		    title=row.getCell(25).getStringCellValue();
	      	    	    comparestr="??????";
	      	    	    if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
		    		    
		    		    title=row.getCell(26).getStringCellValue();
	      	    	    comparestr="????????????";
	      	    	    if (!title.trim().equals(comparestr))
	      	    		{
		    		    	consequencemsg=consequencemsg+"Excel ?????????"+sheetname+"???"+Integer.toString(i+1) +"???????????????"+comparestr+"???????????????Excel????????????????????? </br>";
	      	    			errsheetcount++;
	      	    			notoligable=1;
	      	    			 break;
	      	    		}
		    		    
	      	    	}
	      	    	else
	      	    	{
	      	    	   ExcelContents invoiceexcelcontent = new ExcelContents();
	      	    	   invoiceexcelcontent.setSn(row.getCell(0).getStringCellValue());
	      	    	   invoiceexcelcontent.setInvoicecode(row.getCell(1).getStringCellValue());
	      	    	   invoiceexcelcontent.setInvoicenum(row.getCell(2).getStringCellValue());
	      	    	   invoiceexcelcontent.setSellerid(row.getCell(3).getStringCellValue());
	      	    	   invoiceexcelcontent.setSellername(row.getCell(4).getStringCellValue());
	      	    	   invoiceexcelcontent.setBuyerid(row.getCell(5).getStringCellValue());
	      	    	   invoiceexcelcontent.setBuyername(row.getCell(6).getStringCellValue());
	      	    	   invoiceexcelcontent.setBuyeradd(row.getCell(7).getStringCellValue());
	      	    	   invoiceexcelcontent.setBuyerbankacc(row.getCell(8).getStringCellValue());
	      	    	   invoiceexcelcontent.setCryptocontents(row.getCell(9).getStringCellValue());
	      	    	   invoiceexcelcontent.setIssuedate(row.getCell(10).getStringCellValue());
	      	    	   invoiceexcelcontent.setTotal(row.getCell(11).getNumericCellValue());
	      	    	   invoiceexcelcontent.setTaxtotal(row.getCell(12).getNumericCellValue());
	      	    	   invoiceexcelcontent.setMainproductname(row.getCell(13).getStringCellValue());
	      	    	   invoiceexcelcontent.setMemo(row.getCell(14).getStringCellValue());
	      	    	   invoiceexcelcontent.setIfappeal(row.getCell(15).getStringCellValue());
	      	    	   invoiceexcelcontent.setInvoicetype(row.getCell(16).getStringCellValue());
	      	    	   invoiceexcelcontent.setIfaccquired(row.getCell(17).getStringCellValue());
	      	    	   invoiceexcelcontent.setIfdiffecent(row.getCell(18).getStringCellValue());
	      	    	   invoiceexcelcontent.setPoscode(row.getCell(19).getStringCellValue());
	      	    	   invoiceexcelcontent.setProductname(row.getCell(20).getStringCellValue());
	      	    	   invoiceexcelcontent.setTaxtypecode(row.getCell(21).getStringCellValue());
	      	    	   
	      	    	   if (isNumeric(row.getCell(22).getStringCellValue().trim()))
	      	    	   {
	      	    		 invoiceexcelcontent.setThenumber(Double.parseDouble(row.getCell(22).getStringCellValue().trim())); 
	      	    		 invoiceexcelcontent.setNullvaluemark(false);
	      	    	   }
	      	    	   else
	      	    	   {
	      	    		 invoiceexcelcontent.setThenumber(0);
	      	    		 invoiceexcelcontent.setNullvaluemark(true);
	      	    		 consequencemsg=consequencemsg+"????????? ???Excel?????????'"+sheetname+"' ???"+ Integer.toString(i+1) +"???'??????'?????????????????????????????????????????????????????????</br>";
	      	    	   }
	      	    	   
	      	    	//   invoiceexcelcontent.setThenumber(row.getCell(22).getNumericCellValue());
	      	    	   invoiceexcelcontent.setAmount(row.getCell(23).getNumericCellValue());
	      	    	   invoiceexcelcontent.setTax(row.getCell(24).getNumericCellValue());
	      	    	   invoiceexcelcontent.setTaxrate(row.getCell(25).getNumericCellValue());
	      	    	   invoiceexcelcontent.setProdsize(row.getCell(26).getStringCellValue());	 
	      	    	   tempExcelcontentList.add(invoiceexcelcontent);
	      	    	   recordscount++;
	      	    	}
	      	     
	      	          
	      	     }
	      	    
	      	       if(notoligable==0)
	      	       {
	      	    	 consequencemsg=consequencemsg+"Excel ???'"+sheetname+"'????????????   </br>";
	      	    	 sheetscount++;
	      	       }
	      	    }
	            
	           
	           if (errsheetcount==workbook.getNumberOfSheets())
	           {
	        	   consequencemsg="???excel?????????????????????Excel???????????????????????????</br>";
	           }
	           else if(recordscount==0)
	           {
	        	   consequencemsg="???excel????????????</br>";
	           }
	           else
	           {
	        	   consequencemsg=consequencemsg+" ?????????"+Integer.toString(sheetscount)+"?????????"+Integer.toString(recordscount)+"?????????</br>";
	           }
	           
	           workbook.close();
	           
	           String invoicenumbercurrent="";
	           String invoicenumberprevious="";
	           DZSBB dzsbb=new DZSBB();
	           SB_FWSKKP fwskpp=new SB_FWSKKP();
	           dzsbb.setSB_FWSKKP(fwskpp);
	           
	           SB_FWSKKP_BTXX fwskkpbtxx=new SB_FWSKKP_BTXX();
	           SB_FWSKKP_FPXX fwskkpfpxx=new SB_FWSKKP_FPXX();
	           List<SB_FWSKKP_MXXX> mxxlist=new ArrayList<SB_FWSKKP_MXXX>();
	           List<SP> splist=new ArrayList<SP>();
	          
	           fwskkpfpxx.setSB_FWSKKP_MXXX(mxxlist);
	           
	           int elementindex=0;
	           boolean nullvaluemark=false;
	           boolean continueignore=false;
	           int nullvaluemarkcount=0;
	           for (ExcelContents xc:tempExcelcontentList) {
	        	   
	        	   if (elementindex==0)
	        	   {
	        		   fwskkpbtxx.setSB_FWSKKP_BTXX_NSRSBH(xc.getSellerid());
	        		   String issuedatestring=xc.getIssuedate();
	        		   if (issuedatestring.length()>=6)
	        		   fwskkpbtxx.setSB_FWSKKP_BTXX_KPYF(issuedatestring.substring(0,6));
	        		   // //?????????????????????
	        		   fwskkpbtxx.setSB_FWSKKP_BTXX_NSRMC("");
	        		   fwskkpbtxx.setSB_FWSKKP_BTXX_KPDMC("");
	        		   fwskkpbtxx.setSB_FWSKKP_BTXX_FPXH("");
	        		   fwskkpbtxx.setSB_FWSKKP_BTXX_MAC("");
	        		   //????????????
	        		   fwskpp.setSB_FWSKKP_BTXX(fwskkpbtxx);
	        		   fwskpp.setSB_FWSKKP_FPXX(fwskkpfpxx);
	        		  
	        		   
	        	   }
	        	   
	        	   
	        	       invoicenumbercurrent=xc.getInvoicenum();
	        	  
	        		  
	        	       SB_FWSKKP_MXXX fwskkpmxxx=new SB_FWSKKP_MXXX();
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_XH(Integer.toString(invoiceindex));
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_FPDM(xc.getInvoicecode());
	        		   String theinvoicenumber=xc.getInvoicenum();
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_FPHM(theinvoicenumber);
	        		   
	        		//   if(theinvoicenumber.equals("04185825"))
	        		//	   System.out.print("04185825");
	                           		   
	        		   MXXX mxxx=new MXXX();
	        		   mxxx.setSB_FWSKKP_MXXX_XFDZDH(myaddress);
	        		   mxxx.setSB_FWSKKP_MXXX_XFYHZH(mybankaccount);
	        		    
	        		
	        		   
	        		 //  String myaddressGBK=charsetConvert(myaddress,"GBK");
	        	
	        		 //  String myaddressGBK=utf8Togbk(myaddress);
	        		 //  mxxx.setSB_FWSKKP_MXXX_XFDZDH(myaddressGBK);
	        		   
	        		
	        		   
	        		//   String mybankaccountGBK=charsetConvert(mybankaccount,"GBK");
	        		
	        		//   String mybankaccountGBK=utf8Togbk(mybankaccount);
	        		//   mxxx.setSB_FWSKKP_MXXX_XFYHZH(mybankaccountGBK);
	        		   
	        		   fwskkpmxxx.setMXXX(mxxx);
	        		  
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_XFMC(xc.getSellername());
	        		  // String sellernameGBK=charsetConvert(xc.getSellername(),"GBK");
	        		//   String sellernameGBK=utf8Togbk(xc.getSellername());
	        		 //  fwskkpmxxx.setSB_FWSKKP_MXXX_XFMC(sellernameGBK);
	        		   
	        		 
	        		   
	        		   
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_XFSBH(xc.getSellerid());
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_GFMC(xc.getBuyername());
	        		   
	        		//   String BuyernameGBK=charsetConvert(xc.getBuyername(),"GBK");
	        		 //  String BuyernameGBK=utf8Togbk(xc.getBuyername());
	        		 //  fwskkpmxxx.setSB_FWSKKP_MXXX_GFMC(BuyernameGBK);
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_GFSBH(xc.getBuyerid());
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_KPJH(xc.getPoscode());
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_GFDZDH(xc.getBuyeradd());
	        		//   String buyeraddGBK=charsetConvert(xc.getBuyeradd(),"GBK");
	        		 //  String buyeraddGBK=utf8Togbk(xc.getBuyeradd());
	        		 //  fwskkpmxxx.setSB_FWSKKP_MXXX_GFDZDH(buyeraddGBK);
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_GFYHZH(xc.getBuyerbankacc());
	        		//   String BuyerbankaccGBK=charsetConvert(xc.getBuyerbankacc(),"GBK");
	        	
	        		  // String BuyerbankaccGBK=utf8Togbk(xc.getBuyerbankacc());
	        		  // fwskkpmxxx.setSB_FWSKKP_MXXX_GFYHZH(BuyerbankaccGBK);
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_MW(xc.getCryptocontents());
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_KPRQ(xc.getIssuedate());
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_JE(xc.getTotal());
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_SL(xc.getTaxrate());
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_SE(xc.getTaxtotal());
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_ZYSPMC(xc.getMainproductname());
	        		 //  String MainproductnameGBK=charsetConvert(xc.getMainproductname(),"GBK");
	        		 //  String MainproductnameGBK=utf8Togbk(xc.getMainproductname());
	        		 //  fwskkpmxxx.setSB_FWSKKP_MXXX_ZYSPMC(MainproductnameGBK);
	        		   
	        		   String invoicetype=xc.getInvoicetype();
	        		   if (invoicetype.trim().equals("?????????????????????"))
	        		   {
	        				   fwskkpmxxx.setSB_FWSKKP_MXXX_SPSM("4001");
	        				   fwskkpmxxx.setSB_FWSKKP_MXXX_FPZL(2);
	        		   }
	        		   else
	        		   {
	        			   fwskkpmxxx.setSB_FWSKKP_MXXX_FPZL(1);
	        		   }
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_BZ(xc.getMemo());
	        		   
	        		   
	        		   String ifdifference=xc.getIfdiffecent();
	        		   if (ifdifference.trim().equals("???????????????"))
	        			   fwskkpmxxx.setSB_FWSKKP_MXXX_CEZS(0);
	        		   else
	        			   fwskkpmxxx.setSB_FWSKKP_MXXX_CEZS(1);
	        		   
	        		   String ifappealstr=xc.getIfappeal();
	        		   
	        		   if(ifappealstr.trim().equals("?????????"))
	        		     fwskkpmxxx.setSB_FWSKKP_MXXX_ZFBZ(0);
	        		   else
	        			   fwskkpmxxx.setSB_FWSKKP_MXXX_ZFBZ(1);
	        		   
	        		   String ifaccquired=xc.getIfaccquired();
	        		   if(ifaccquired.trim().equals("???????????????"))
	        			   fwskkpmxxx.setSB_FWSKKP_MXXX_SGBZ(0);
	        		   else
	        			   fwskkpmxxx.setSB_FWSKKP_MXXX_SGBZ(1);
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_JSHJ(xc.getTotal()+xc.getTaxtotal());
	        		  fwskkpmxxx.setSB_FWSKKP_MXXX_KPR(mykpr);
	        		//   String mykprGBK=charsetConvert(mykpr,"GBK");
	        		//   String mykprGBK=utf8Togbk(mykpr);
	        		 //  fwskkpmxxx.setSB_FWSKKP_MXXX_KPR(mykprGBK);
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_SKR(myskr); 
	        		 //  String myskrGBK=charsetConvert(myskr,"GBK");
	        	
	        		//   String myskrGBK=utf8Togbk(myskr);
	        		 //  fwskkpmxxx.setSB_FWSKKP_MXXX_SKR(myskrGBK);
	        		   
	        		  fwskkpmxxx.setSB_FWSKKP_MXXX_FHR(myfhr);
	        		//   String myfhrGBK=charsetConvert(myfhr,"GBK");
	        	
	        		//   String myfhrGBK=utf8Togbk(myfhr);
	        		//   fwskkpmxxx.setSB_FWSKKP_MXXX_FHR(myfhrGBK);
	        		  
	        		  // //?????????????????????
	        		  fwskkpmxxx.setSB_FWSKKP_MXXX_SPSM("");
	        		  fwskkpmxxx.setSB_FWSKKP_MXXX_JQBH("");
	        		  //????????????
	        		   
	        		   nullvaluemark=xc.isNullvaluemark();
	        		   
	        				  
	        		   if (!invoicenumbercurrent.equals(invoicenumberprevious))
	            	   {
	        			  
	        			   
	        			   splist.clear();
	        			   continueignore=false;
		        		   nullvaluemarkcount=0;
		        		   invoiceindex++;
		        		   fwskkpmxxx.setSB_FWSKKP_MXXX_XH(Integer.toString(invoiceindex));
		        		   mxxlist.add(fwskkpmxxx);
	            	   }
	        		   
	        		   if (nullvaluemark==true)
	        			   continueignore=true;
	        			  
	        		  
	        	    if (continueignore==false)
	        	    {
	        	       SP sp=new SP();
	        	       sp.setJE(xc.getAmount());
	        	       sp.setSL(xc.getTaxrate());
	        	       sp.setSE(xc.getTax());
	        	       sp.setSPMC(xc.getProductname());
	        	   //     String productnameGBK=charsetConvert(xc.getProductname(),"GBK");
	        	 
	        	   //    String productnameGBK=utf8Togbk(xc.getProductname());
	        	   //     sp.setSPMC(productnameGBK);
	        	         
	        	       
	        	         sp.setGGXH(xc.getProdsize());
	        	    //    String prodsizeGBK=charsetConvert(xc.getProdsize(),"GBK");
	        	    
	        	     //   String prodsizeGBK=utf8Togbk(xc.getProdsize());
	        	     //   sp.setSPMC(prodsizeGBK);
	        	      sp.setJLDW("???");
	        	      //  String monadGBK=charsetConvert("???","GBK");
	        	      //  String monad="???";
	        	 
	        	      //  String monadGBK=utf8Togbk(monad);
	        	      //  sp.setJLDW(monadGBK);
	        	        
	        	       sp.setSHUL(String.valueOf(xc.getThenumber()));
	        	       double theprice=(xc.getAmount()+xc.getTax())/xc.getThenumber();
	        	       sp.setDJ(String.valueOf(theprice));
	        	       sp.setFLBM(xc.getInvoicecode());
	        	       if (xc.getAmount()>0)
	        	       sp.setHSBZ("True");
	        	       else
	        	       sp.setHSBZ("False");
	        	       
	        	       //?????????
	        	       sp.setSPSM("");
	        	       //
	        	       
	        	       splist.add(sp);
	        	       List<SP> splistcopy=new ArrayList<SP>(splist);
	        	       for(int k=0;k<splist.size();k++)
	        	       {
	        	    	   splistcopy.set(k, splist.get(k));
	        	       }
	        	      
				       SPXX spxx=new SPXX();
				       spxx.setSPXX(splistcopy);
				       fwskkpmxxx.setSPXX(spxx);
				       mxxlist.set(invoiceindex -1 , fwskkpmxxx);
	        	   }
	        	   else if (nullvaluemarkcount==0)
	        	   {
	        		   
	        		   
	        		   fwskkpmxxx.setSB_FWSKKP_MXXX_XH(Integer.toString(invoiceindex));
	        		   splist.clear();
	        		   SP sp=new SP();
		        	   sp.setJE(xc.getTotal());
		        	   sp.setSL(xc.getTaxrate());
		        	   sp.setSE(xc.getTaxtotal());
		        	   sp.setSPMC("(??????????????????)");
		        	 //  String prodnameGBK=charsetConvert("(??????????????????)","GBK");
		        	//   String prodname="(??????????????????)";
		        	
		          //	   String prodnameGBK=utf8Togbk(prodname);
		        //	   sp.setSPMC(prodnameGBK);
		        	   sp.setHSBZ("False");
		        	   
		        	 //?????????
	        	       sp.setSPSM("");
	        	       sp.setGGXH("");
	        	       sp.setJLDW("");
	        	       sp.setSHUL("");
	        	       sp.setDJ("");
	        	       sp.setFLBM("");
	        	       //
		        	   
		        	   splist.add(sp);	
	        		   nullvaluemarkcount++;
	    		  	  
	        		   List<SP> splistcopy=new ArrayList<SP>(splist);
	        	       for(int k=0;k<splist.size();k++)
	        	       {
	        	    	   splistcopy.set(k, splist.get(k));
	        	       }
	        	       
				       SPXX spxx=new SPXX();
				       spxx.setSPXX(splistcopy);
				       fwskkpmxxx.setSPXX(spxx);
				       mxxlist.set(invoiceindex -1 , fwskkpmxxx);
	        	   }
	        	 
	        	  
				   
	    		  
	        	   
	        	   elementindex++;
	        	   invoicenumberprevious=invoicenumbercurrent;
	           }
	           
	          
	           
	           UUID uuid = UUID.randomUUID();
	           
	           File xmlfilename = new File(uuid.toString()+".xml");
	       
	           JAXBContext jaxbContext = JAXBContext.newInstance(DZSBB.class);
	           Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	           // output pretty printed
	           
	          // String charset=System.getProperty("file.encoding");
	           jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK"); 
	           jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	          // jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
	                 
	           
	           
	           StringWriter sw = new StringWriter();
	           
	           jaxbMarshaller.marshal(dzsbb, sw);
	           //  jaxbMarshaller.marshal(dzsbb, System.out);
	           
	           String xmlstring=sw.toString();
	        //   xmlstring.replaceFirst("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "<?xml version=\"1.0\" encoding=\"GBK\"?>");
	           
	       
	           String xmlstringGBK= utf8Togbk(xmlstring); 
	           
	        //   System.out.print(xmlstringGBK);
	           Writer out = new BufferedWriter(new OutputStreamWriter(
	        		    new FileOutputStream(xmlfilename), "GBK"));
	        		try {
	        		    out.write(xmlstringGBK);
	        		} finally {
	        		    out.close();
	        		}
	           
	           ModelAndView model = new ModelAndView("result");
	           model.addObject("excecontentslist",tempExcelcontentList);
	           model.addObject("message",consequencemsg);
	           model.addObject("downloadfile",xmlfilename);
	           model.addObject("test","hello world!");
	           return model;
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new FileStorageException("??????Excel???????????? " + file.getOriginalFilename()
	                + ". ?????????!");
	        }
		}
		else
		{
			  ModelAndView model = new ModelAndView("exception");
	         
	           model.addObject("message","???????????????Excel");
	           
	           return model;
		}
	    }
	
	
	@RequestMapping(path = "/download", method = RequestMethod.POST)
	public void saveTxtFile(HttpServletResponse response,@RequestParam("filename") String filename) throws IOException {

	    String yourXmlFileInAString;
	    response.setContentType("application/xml; charset=GBK");
	    response.setCharacterEncoding("GBK");
	    response.setHeader("Content-Disposition", "attachment;filename="+filename);

	    BufferedReader br = new BufferedReader(
	            new InputStreamReader(
	                      new FileInputStream(filename), "GBK"));
	    String line;
	    StringBuilder sb = new StringBuilder();

	    while((line=br.readLine())!= null){
	        sb.append(line);
	    }

	    yourXmlFileInAString  = sb.toString();
        
	    ServletOutputStream outStream = response.getOutputStream();
	    outStream.write(yourXmlFileInAString.getBytes("GBK"));
	    outStream.flush();
	    outStream.close();
	}
	
	private static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	/*private String charsetConvert(String str, String charset) {
	    try {
	        str = new sun.misc.BASE64Encoder().encode(str.getBytes(charset));
	        byte[] bytes = new sun.misc.BASE64Decoder().decodeBuffer(str);
	        str = new String(bytes, charset);
	    } catch(IOException e) {
	        e.printStackTrace();
	    }
	    return str;
	}*/
	
	private String utf8Togbk(String str) throws UnsupportedEncodingException {
		 
		byte[] mybankaccountUTF8=str.getBytes();                                 
		String mybankaccountUNI=new String(mybankaccountUTF8,"UTF-8"); 
		String b=new String(mybankaccountUNI.getBytes("GBK"),"GBK");
        return b;
  }
}
