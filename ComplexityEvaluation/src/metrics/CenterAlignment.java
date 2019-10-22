package metrics;

import java.util.ArrayList;




import metrics.Region.widget;


/**
 * @author Mathiew ZEN
 */
public class CenterAlignment extends Metric {
	
	static int treshold = 5;
	static int n;
	static int verticalCentralAlignment;
	static int horizontalCentralAlignment;
	static int CAV;
	static int CAH;
	
	public static double calculate(ArrayList<widget> rectXY) {
		
		verticalCentralAlignment = 0;
		horizontalCentralAlignment = 0;
		CAV = 0;
		CAH = 0;
		n = rectXY.size();
		double value = 0;
		
		for(int i=0; i<rectXY.size();i++){	
			widget data =  rectXY.get(i); 
			verticalCentralAlignment = 0;
			horizontalCentralAlignment = 0;
			for(int j=0; j<rectXY.size();j++){
				if(j!=i){				
					widget data1 =  rectXY.get(i); 
					if((data.getX()+data.getWidth()/2<=data1.getX()+data1.getWidth()/2+treshold) && (data.getX()+data.getWidth()/2>=data1.getX()+data1.getWidth()/2-treshold))
						verticalCentralAlignment = 1;
					if((data.getY()+data.getHeight()/2<=data1.getY()+data1.getHeight()/2+treshold) && (data.getY()+data.getHeight()/2>=data1.getY()+data1.getHeight()/2-treshold))
						horizontalCentralAlignment = 1;
				}
			}
			
			CAV += verticalCentralAlignment;
			CAH += horizontalCentralAlignment;
			
		}
		
		//Window.alert(""+CAV+" - "+CAH);
		value = (double)(CAV + CAH)/(n*2);
		return value;

	}
	
}
	
