package Widgets_Views;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author NarjesBessghaier
 */
public class ComputeHeight {
	private static Object row;
	private static HSSFSheet sheet;

	public void main(String[] args) throws IOException {
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
			 int FY=0;
			 if (sheet.getRow(r) != null && 
		                sheet.getRow(r).getCell(2) != null && 
		               !sheet.getRow(r).getCell(2).toString().equals("")){
			       HSSFCell cellY= row.getCell(2);
			    cellY.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			     FY= (int)(cellY.getNumericCellValue());
			  }
				if (sheet.getRow(r) != null && 
		                sheet.getRow(r).getCell(4) != null && 
		               !sheet.getRow(r).getCell(4).toString().equals("")){
		   			HSSFCell cellH= row.getCell(4);
		   		 cellH.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		 			    int FH= (int)(cellH.getNumericCellValue());
		 			   int height= FH-FY;
		 			     FH=height;
		 			     cellH.setCellValue(FH);
		    
	}
    
	}
    FileOutputStream fileOut = new FileOutputStream(outputFile);
	
	wb.write(fileOut);
	fileOut.flush();
	fileOut.close();
}}
