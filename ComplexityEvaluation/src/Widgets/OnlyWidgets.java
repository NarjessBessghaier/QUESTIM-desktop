package Widgets;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JOptionPane;
import javax.swing.event.*; 

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
	public class OnlyWidgets {
	public static String UIXFilePath;
	public static String data_File= UIXFilePath+"file.xls";
	public static String outputFile;
	public static int FrameHeight, FrameWidth;
	  @SuppressWarnings({ "null", "static-access" })
		public static void main(String[] args) throws Exception  {
			// TODO Auto-generated method stub

			UIXFilePath=metrics.main.Field.getText();
			File sourceCode = new File(UIXFilePath );	
		    BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceCode.getAbsolutePath()));
		    StringWriter out = new StringWriter();
			       int b;
			       while ((b=in.read()) != -1)
			       out.write(b);
			       out.flush();
			       out.close();
			       in.close();
			       String Contenu= out.toString();

			 //#######################
		    //#########################
			//get components name       class="androidx.viewpager.widget.ViewPager"  | class="android.support.v4.widget.ViewPager" 
			//#######################
		     //#########################
			     /*  
			    		   | \\bclass=\"android.(.*).(?<=\\.)(.*?)(?=\")
			       */
			     String name = "";
			     String[] FinalName=null;
			   
			     String text;
			     int countlayouts=0;
			     String[] widget = null;
			   //  String regex =  "\\bclass=\"android.(.*).(?<=\\.)(.*?)(?=\")";
			     String regex = "\\bclass=\"android.\\b[a-zA-Z]*.\\b[a-zA-Z]*";
			    // String regex = "\\bclass=\"android.widget.\\b[a-zA-Z]*";
			     Pattern pattern = Pattern.compile(regex);
			     Matcher matcher = pattern.matcher((CharSequence) Contenu);
			     while (matcher.find())
			     {
			    	 text=matcher.group();
			    	
			    	 widget= text.split("\\bclass=\"android.\\b[a-zA-Z]*.\\b");
			    	// widget= text.split("\\bclass=\"android.widget.\\b");
			    	// widget= text.split("\\bclass=\"android.(.*).(\\b)");
			    	  for(int k=0;k<widget.length;k++){
			    		
				    		name= name+widget[k]+",";
				    		
				    	 }
			     }	
		    		 FinalName=name.split(",,"); 
		    		
		    		 for(int k=0;k<FinalName.length;k++){
		    			 if (
		    					 (FinalName[k].equals("LinearLayout") )
				    				||(FinalName[k].equals("FrameLayout") )
				    						|| (FinalName[k].equals("GridLayout"))
				    								|| (FinalName[k].equals("RelativeLayout") )
				    								||(FinalName[k].equals("ViewGroup") )
				    						|| (FinalName[k].equals(",ViewGroup"))
				    								|| (FinalName[k].equals("ViewGroup,") )
				    								|| (FinalName[k].equals(",LinearLayout") )|| (FinalName[k].equals("LinearLayout,") )
			    				||(FinalName[k].equals(",FrameLayout") ) ||(FinalName[k].equals("FrameLayout,") )
	    						|| (FinalName[k].equals(",GridLayout")) ||(FinalName[k].equals("GridLayout,")) 
	    								|| (FinalName[k].equals(",RelativeLayout") ) 
||(FinalName[k].equals("DrawerLayout"))||(FinalName[k].equals("v"))||(FinalName[k].equals("View"))||(FinalName[k].equals("View,"))||(FinalName[k].equals(",View"))
||(FinalName[k].equals("appcompat"))	||(FinalName[k].equals("viewpager"))||(FinalName[k].equals("LinearLayout"))			 )
				    		{
			    			FinalName[k]="Layout";
				    		}	
			    	 }
		    		 for(int k=0;k<FinalName.length;k++){		
				    	 } 
		    		 
		    	
				     //##################
		    	     // Get FrameHeight and Width
		    		 
		    		 
		    		 
		    		
		    		 //#######################
		    		 //#########################
		    		//get the x 
		    		//#######################
		    		 //######################### 
				     String xval = "";
				     String[] Finalx=null;
				     String[] X = null;
				     String D= Contenu.replaceAll("\\[", "(");
				     String d1= D.replaceAll("\\]", ")");
				     String regexX = "\\bbounds=\"(\\s)*[(]\\b((\\d*)*)";
				     Pattern patternX = Pattern.compile(regexX);
				     Matcher matcherX = patternX.matcher((CharSequence) d1);
				     int p = 0;
				     while (matcherX.find())
				     {
				    	 text=matcherX.group();
				    	 X= text.split("\\bbounds=\"(\\s)*[(]\\b");
				    	  for(int k=0;k<X.length;k++){
					    		xval= xval+X[k]+",";
					    	 }
				     } 
		    		 Finalx=xval.split(",,"); 
		    		 for(int k=0;k<Finalx.length;k++){ 
			    	 }
		    		 
		    		
		    		 //#######################
		    		 //#########################
		    		//get the y 
		    		//#######################
		    		 //######################### 
		    		 
				     String yval = "";
				     String[] Finaly=null;
				     String[] Y = null;
				     String DY= Contenu.replaceAll("\\[", "(");
				     String dy= DY.replaceAll("\\]", ")");
				     String regexY = "\\bbounds=\"(\\s)*[(]\\b((\\d*)*)(,)((\\d*)*)";
				     Pattern patternY = Pattern.compile(regexY);
				     Matcher matcherY = patternY.matcher((CharSequence) dy);
				     int w = 0;
				     while (matcherY.find())
				     {
				    	 text=matcherY.group();
				    	 Y= text.split("\\bbounds=\"(\\s)*[(]\\b((\\d*)*)[,]");
				    	 
				    	  for(int k=0;k<Y.length;k++){
					    		yval= yval+Y[k]+",";
					    	 }
				     } 
		    		 Finaly=yval.split(",,"); 
		    	 
		    		 for(int k=0;k<Finaly.length;k++){
			    	 }
		    		 
		    		 //#######################
		    		 //#########################
		    		//get the width 
		    		//#######################
		    		 //######################### 
		    		 
				     String wval = "";
				     String[] Finalw=null;
				     String[] W = null;
				     String DW= Contenu.replaceAll("\\[", "(");
				     String dw= DW.replaceAll("\\]", ")");
				     String regexW = "\\bbounds=\"(\\s)*[(]\\b((\\d*)*)(,)((\\d*)*)[)](\\s)*[(]((\\d*)*)";
				     Pattern patternW = Pattern.compile(regexW);
				     Matcher matcherW = patternW.matcher((CharSequence) dw);
				     int q = 0;
				     while (matcherW.find())
				     {
				    	
				    	 text=matcherW.group();
				    	 W= text.split("\\bbounds=\"(\\s)*[(]\\b((\\d*)*)(,)((\\d*)*)[)](\\s)*[(]");
				    	 
				    	  for(int k=0;k<W.length;k++){
					    		wval= wval+W[k]+",";
					    	 }

				     } 
		    		 Finalw=wval.split(",,"); 
		    		 for(int k=0;k<Finalw.length;k++){
			    	 }
		    		 
		    		 if(Finalw[0].startsWith(","))
  					{Finalw[0]=Finalw[0].substring(1 );}
		    		 FrameWidth=Integer.parseInt(Finalw[0]);
		    		 //#######################
		    		 //#########################
		    		//get the height
		    		//#######################
		    		 //###
				     String hval = "";
				     String[] Finalh=null;
				     String[] H = null;
				     String DH= Contenu.replaceAll("\\[", "(");
				     String dh= DH.replaceAll("\\]", ")");
				     String regexH = "\\bbounds=\"(\\s)*[(]\\b((\\d*)*)(,)((\\d*)*)[)](\\s)*[(]((\\d*)*)(,)((\\d*)*)";
				     Pattern patternH = Pattern.compile(regexH);
				     Matcher matcherH = patternH.matcher((CharSequence) dh);
				     int n = 0;
				     while (matcherH.find())
				     {
				    	
				    	 text=matcherH.group();
				    	 H= text.split("\\bbounds=\"(\\s)*[(]\\b((\\d*)*)(,)((\\d*)*)[)](\\s)*[(]((\\d*)*)(,)");
				    	  for(int k=0;k<H.length;k++){ 
					    		hval= hval+H[k]+",";
					    	 }
				     } 
		    		 Finalh=hval.split(",,"); 
		    		 if(Finalh[0].startsWith(","))
  					{Finalh[0]=Finalh[0].substring(1 );}
		    		 FrameHeight=Integer.parseInt(Finalh[0]);
		    		 
		    		 
		    		 
		    		 String[] header= {"nature","x","y","width","height"};
		    		 
		    			String sheetName = "Sheet1";

		    			HSSFWorkbook wb = new HSSFWorkbook();
		    			HSSFSheet sheet = wb.createSheet(sheetName) ;
		    	        Row headerRow = sheet.createRow(0);
		    	        for(int t = 0; t < header.length; t++) {
		    	            Cell cell = headerRow.createCell(t);
		    	            cell.setCellValue(header[t]);
		    	        }
		    		
		    	        int k=1;
		    			for (int r=k;r < FinalName.length+1 ; r++ )
		    			{
		    				HSSFRow row = sheet.createRow(r);
		    					HSSFCell cell = row.createCell(0);
		    					 if(
		    						 FinalName[r-1].equals("Layout"))
		    						
		    				 
		    					 {k=r-1; continue;
		    						 }
		    					 
		    					else{ 
		    						 
		    						 String valname=FinalName[r-1];
			 	    					if(valname.endsWith(","))
			 	    					{valname=valname.substring(0,valname.length()-1 );}
			    						 cell.setCellValue(valname);	
		    				    		
		    						 Cell cell1 = row.createCell(1);
		    						 String valX=Finalx[r-1];
		 	    					if(valX.endsWith(","))
		 	    						
		 	    					{valX=valX.substring(0,valX.length()-1 );}
		 	    					int valx= Integer.parseInt(valX);
		    						 cell1.setCellValue(valx);	
	                                 
		    						 Cell cell2 = row.createCell(2);
	                                 String valY=Finaly[r-1];
			 	    					if(valY.endsWith(","))
			 	    					{valY=valY.substring(0,valY.length()-1 );}
			 	    					int valy= Integer.parseInt(valY);
			    						 cell2.setCellValue(valy);	
		    						  
			    						 Cell cell3 = row.createCell(3);
		    						  String valW=Finalw[r-1];
			 	    					if(valW.endsWith(","))
			 	    					{valW=valW.substring(0,valW.length()-1 );}
			 	    					int valw= Integer.parseInt(valW);
			 	    					cell3.setCellValue(valw);
			    						 
			 	    					Cell cell4 = row.createCell(4);
			    						  String valH=Finalh[r-1];
				 	    					if(valH.endsWith(","))
				 	    					{valH=valH.substring(0,valH.length()-1 );}
				 	    					int valh= Integer.parseInt(valH);
				    						 cell4.setCellValue(valh);	
				    						 
				    						
		    					}
		    			}
		    			outputFile=OnlyWidgets.UIXFilePath+"fileWithEmptyRows.xls";
		    			FileOutputStream fileOut = new FileOutputStream(outputFile);
		    			wb.write(fileOut);
		    			fileOut.flush();
		    			fileOut.close();
		    			Widgets.DeleteEmptyRows delete= new Widgets.DeleteEmptyRows();
		    			delete.main(new String[]{});
		    			

		    			ComputeWidth width= new ComputeWidth();
		    			width.main(args);
		    			ComputeHeight heigth= new ComputeHeight();
		    			heigth.main(args);
		    			DeleteEmptyRowsFile deleteFile= new DeleteEmptyRowsFile();
		    			deleteFile.main(args);
		    			
		    		
		}


		
	}


