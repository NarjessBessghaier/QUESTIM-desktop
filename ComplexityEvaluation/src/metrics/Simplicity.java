package metrics;

import java.util.ArrayList;

import metrics.Region.widget;


/**
 * @author Mathiew ZEN
 */
public class Simplicity extends Metric {
	
	static int treshold = 1;
	static int n;
	static int verticalAlignment1;
	static int horizontalAlignment1;
	static int verticalAlignment2;
	static int horizontalAlignment2;
	static int DAV;
	static int DAH;
	
	public static double calculate(ArrayList<widget> rectXY, int frameWidth, int frameHeight){
		
		double value = 0.0;
		
		verticalAlignment1 = 0;
		horizontalAlignment1 = 0;
		verticalAlignment2 = 0;
		horizontalAlignment2 = 0;
		DAV = 0;
		DAH = 0;
		n = rectXY.size();
		
		for(int i=0; i<rectXY.size();i++){	
			widget data =  rectXY.get(i); 
			verticalAlignment1 = 0;
			horizontalAlignment1 = 0;
			verticalAlignment2 = 0;
			horizontalAlignment2 = 0;
			for(int j=0; j<rectXY.size();j++){
				if(j!=i){				
					widget data1 =  rectXY.get(i); 
					if(!(data.getX()<=data1.getX()+treshold) && !(data.getX()>=data1.getX()-treshold))
						verticalAlignment1=1;
					if(!(data.getX()+data.getWidth()<=data1.getX()+data1.getWidth()+treshold) && !(data.getX()+data.getWidth()>=data1.getX()+data1.getWidth()-treshold))
						verticalAlignment2=1;
					if(!(data.getY()<=data1.getY()+treshold) && !(data.getY()>=data1.getY()-treshold))
						horizontalAlignment1=1;
					if(!(data.getY()+data.getHeight()<=data1.getY()+data1.getHeight()+treshold) && !(data.getY()+data.getHeight()>=data1.getY()+data1.getHeight()-treshold))
						horizontalAlignment2=1;
				}
			}
			
			DAV += verticalAlignment1 + verticalAlignment2;
			DAH += horizontalAlignment1 + horizontalAlignment2;					
		}
		value = (double) 1/(DAV+DAH+n);
		//Formule différente
		
		
		return value;
	}
}
