package Widgets;

import java.io.File;

/**
 * @author bessghaiernarjess
 */
public class DeleteEmptyRowsFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String outputFile;
		
		outputFile= OnlyWidgets.outputFile;
		File f1 = new File(outputFile);
		if (f1.delete()) {
		    //System.out.println("File " + f1.getName() + " file is deleted.");
		} else {
		    //System.out.println("File " + f1.getName() + " file not deleted.");
		}
	}

}
