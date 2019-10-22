package metrics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



/**
 * @author NarjesBessghaier
 */
public class NbElements {
	public static double value=0;
	public static int rowTotal;
	public static double NbElements () throws IOException, FileNotFoundException  {
		// TODO Auto-generated method stub

		String file=metrics.main.xlspath.getText();
		InputStream input = new FileInputStream(file);
 		 HSSFWorkbook workbook     = new HSSFWorkbook(input);
 		 HSSFSheet sheet = workbook.getSheetAt(0); //first sheet
 		  
		  rowTotal = sheet.getLastRowNum();
 		int k=0;
 		for ( int r=1;r<rowTotal; r++){ 
 			 int noOfColumns = sheet.getRow(r).getLastCellNum(); 
 			for (int c=0;c<noOfColumns; c++)
 				
 			{	if (sheet.getRow(r) != null && 
                sheet.getRow(r).getCell(c) != null && 
               !sheet.getRow(r).getCell(c).toString().equals("")){
 				
 				k++;
 			}
 		}
			
 		}
     
		rowTotal=k/5;
		String[] nature=new String[rowTotal]; 
		int[] text=new int[rowTotal]; 
		for ( int r=1;r<=rowTotal; r++)
	        
        {   
      	  HSSFRow row     = sheet.getRow(r); 
      	  
      	  //fill the nature table
      	  for (int c=0;c<1; c++)
    	        
  	        {  HSSFCell cell= row.getCell(c);
      		if (sheet.getRow(r) != null && 
	                sheet.getRow(r).getCell(0) != null && 
	               !sheet.getRow(r).getCell(0).toString().equals("")){
      		
      		 
      		  nature[r-1]= (cell.getStringCellValue());
      		}
  	        }
      	 for (int c=4;c<5; c++)
   	        
	        {  HSSFCell cell= row.getCell(c);
   		if (sheet.getRow(r) != null && 
	                sheet.getRow(r).getCell(4) != null && 
	               !sheet.getRow(r).getCell(4).toString().equals("")){
   		
 		 
 		  text[r-1]= (int) (cell.getNumericCellValue());
   		}
	        }
		
        }
		
		 
		value= (1-0)* ((rowTotal-4)/(double)(45-4))+0;

		 value =Double.parseDouble(new DecimalFormat("##.###").format(value));
		 //System.out.println("nb"+value);
		 if (value>=1)
		 {
			 value=1;
		 }
		return value;
	}

}
