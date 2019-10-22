package Widgets_Views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

/**
 * @author NarjesBessghaier
 */
public class ComputeWidth {
	private static Object row;
	private static HSSFSheet sheet;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String outputFile=Widgets_Views.DeleteEmptyRows.outputFileNew;
		 String indice = ""; 
		InputStream input = new FileInputStream(outputFile);
		 HSSFWorkbook wb     = new HSSFWorkbook(input);
		 sheet = wb.getSheetAt(0); 
		 int rowTotal = sheet.getLastRowNum();
	
    if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
        rowTotal++;
    }
  	
    for ( int r=1;r<rowTotal; r++){     
			 HSSFRow row     = sheet.getRow(r); 
			 int noOfColumns = sheet.getRow(r).getLastCellNum(); 
			  int FX=0;
			  if (sheet.getRow(r) != null && 
		                sheet.getRow(r).getCell(1) != null && 
		               !sheet.getRow(r).getCell(1).toString().equals("")){
   			       HSSFCell cellX= row.getCell(1);
   			    cellX.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
   			     FX= (int)(cellX.getNumericCellValue());
			  }
   		     //System.out.print(FX);
   		     //int FX= Integer.parseInt(X);
   		if (sheet.getRow(r) != null && 
                sheet.getRow(r).getCell(3) != null && 
               !sheet.getRow(r).getCell(3).toString().equals("")){
   			HSSFCell cellW= row.getCell(3);
   		 cellW.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
 			    int FW= (int)(cellW.getNumericCellValue());
 			   int width= FW-FX;
 			     FW=width;
 			     cellW.setCellValue(FW);
 			   		  }
		    
	}
    
    FileOutputStream fileOut = new FileOutputStream(outputFile);
		
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
  
    
		
		
		
		
		
		
		
		
		
		
	}

}
