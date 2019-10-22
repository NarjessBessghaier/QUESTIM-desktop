package metrics;

import java.util.ArrayList;

import metrics.Region.widget;


/**
 * @author Mathiew ZEN
 */
public class Concentricity extends Metric {
	
	public static double calculate(ArrayList<widget> rectXY, int frameWidth, int frameHeight){
		
		double value = 0.0;
		double ddiag = Math.hypot((double)frameWidth/2,(double)frameHeight/2);
		double dbar = 0.0;
		double dic = 0.0;
		int xc = frameWidth/2;
		int yc = frameHeight/2;
		
		for(int i=0;i<rectXY.size();i++){
			widget data =  rectXY.get(i); 
			dbar += Math.hypot((double)(data.getX()+data.getWidth()/2)-xc, (double)(data.getY()+data.getHeight()/2)-yc);
		}
		
		dbar/=rectXY.size();
		
		value = dbar/ddiag;
		
		return value;
		
	}

}
