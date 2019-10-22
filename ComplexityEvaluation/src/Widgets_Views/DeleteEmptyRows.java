package Widgets_Views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import metrics.main;

/**
 * @author bessghaiernarjess
 */
public class DeleteEmptyRows {
	private static Object row;
	private static HSSFSheet sheet;
	private static int [] array;
	public static String	outputFileNew;
	@SuppressWarnings("null")
	public static void main(String[] args) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		
		
		String outputFile=Widgets_Views.nativeApps.outputFile;
		 String indice = ""; 
		InputStream input = new FileInputStream(outputFile);
		 HSSFWorkbook wb     = new HSSFWorkbook(input);
		 sheet = wb.getSheetAt(0); 
		 int rowTotal = sheet.getLastRowNum();
	
     if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
         rowTotal++;
     }
   	
     for ( int r=0;r<rowTotal; r++){     
			 HSSFRow row     = sheet.getRow(r); 
			 int noOfColumns = sheet.getRow(r).getLastCellNum(); 
			 for (int c=0;c<1; c++)
		        {
			 HSSFCell cell= row.getCell(c);
			 String text= cell.getStringCellValue();
			 if (text.equals("v")||text.equals("view"))
			 {
				indice=indice+r+",";
			 }
	}
     
     }
     
     for (int j = 0; j < indice.length(); ++j) { 
		}
     String[] Finalindice=null;
     Finalindice=indice.split(","); 
 
	 for(int k=0;k<Finalindice.length;k++){	
	 }
     
	 //array = Arrays.stream(Finalindice).mapToInt(Integer::parseInt).toArray();

	// for(int k=0;k<array.length;k++){
		// }
	 boolean   isRowEmpty = false;
	 
	    for(int i = 0; i < sheet.getLastRowNum(); i++){
	        if(sheet.getRow(i)==null){
	            sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
	            i--;
	        continue;
	        }
	        for(int j =0; j<sheet.getRow(i).getLastCellNum();j++){
	            if(sheet.getRow(i).getCell(j).toString().trim().equals("")){
	               isRowEmpty=true;
	            }else {
	                isRowEmpty=false;
	                break;
	            }
	        }
	        if(isRowEmpty==true){
	            sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
	            i--;
	        }
	    }
	
	    outputFileNew=Widgets_Views.nativeApps.UIXFilePath+"OriginalFile.xls";
	
	 FileOutputStream fileOut = new FileOutputStream(outputFileNew);
	 metrics.main.xlspath.setText(outputFileNew);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
		
	}

}
