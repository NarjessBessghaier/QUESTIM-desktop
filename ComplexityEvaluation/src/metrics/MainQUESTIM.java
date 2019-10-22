package metrics;



import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;




/**
 * @author NarjesBessghaier
 */
public class MainQUESTIM{

public static Region rectXY;
	static int frameWidth = (int) Widgets.OnlyWidgets.FrameWidth;
	static int frameHeight = (int)  Widgets.OnlyWidgets.FrameHeight;
	
	public static void main(String[] args) throws Exception  {

		
    String[] widgets= new String[NbElements.rowTotal];
    int[] X= new int[NbElements.rowTotal];
    int[] Y= new int[NbElements.rowTotal];
    int[] Width= new int[NbElements.rowTotal];
    int[] Height= new int[NbElements.rowTotal];
    

		String file=metrics.main.xlspath.getText();
		InputStream input = new FileInputStream(file);
 		 HSSFWorkbook workbook     = new HSSFWorkbook(input);
 		 HSSFSheet sheet = workbook.getSheetAt(0); //first sheet
		
for ( int r=1;r<=NbElements.rowTotal; r++)
	        
        {   
      	  HSSFRow row     = sheet.getRow(r); 
      	  
      	  //fill the nature table
      	  for (int c=0;c<1; c++)
    	        
  	        {  HSSFCell cell= row.getCell(c);
      		if (sheet.getRow(r) != null && 
	                sheet.getRow(r).getCell(0) != null && 
	               !sheet.getRow(r).getCell(0).toString().equals("")){
      		
      		 
      		  widgets[r-1]= (cell.getStringCellValue());
      		}
		
		
      		 //fill the nature table
        	  for (int c1=1;c1<2; c1++)
      	        
    	        {  HSSFCell cellX= row.getCell(c1);
        		if (sheet.getRow(r) != null && 
  	                sheet.getRow(r).getCell(1) != null && 
  	               !sheet.getRow(r).getCell(1).toString().equals("")){
        		
        		  X[r-1]= (int) (cellX.getNumericCellValue());
        		}
  		
		
        		//fill the nature table
          	  for (int c2=2;c2<3; c2++)
        	        
      	        {  HSSFCell cellY= row.getCell(c2);
          		if (sheet.getRow(r) != null && 
    	                sheet.getRow(r).getCell(2) != null && 
    	               !sheet.getRow(r).getCell(2).toString().equals("")){
          		
          		 
          		  Y[r-1]= (int) (cellY.getNumericCellValue());
          		}
    		
          	//fill the nature table
            	  for (int c3=3;c3<4; c3++)
          	        
        	        {  HSSFCell cellW= row.getCell(c3);
            		if (sheet.getRow(r) != null && 
      	                sheet.getRow(r).getCell(3) != null && 
      	               !sheet.getRow(r).getCell(3).toString().equals("")){
            		
            		 
            		  Width[r-1]= (int) (cellW.getNumericCellValue());
            		}
		
		
            		//fill the nature table
              	  for (int c4=4;c4<5; c4++)
            	        
          	        {  HSSFCell cellH= row.getCell(c4);
              		if (sheet.getRow(r) != null && 
        	                sheet.getRow(r).getCell(4) != null && 
        	               !sheet.getRow(r).getCell(4).toString().equals("")){
              		
              		 
              		  Height[r-1]= (int) (cellH.getNumericCellValue());
              		}
  		
		
		
    	        }
        	        }}}}}
               
	             rectXY=new Region();
              	rectXY.addValues(X,Y,Width,Height)  ;
        	      
        	         
	}

	



}
