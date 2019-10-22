package metrics;



import java.util.ArrayList;




import metrics.Region.widget;


/**
 * @author Mathiew ZEN
 */
public class Density extends Metric {

	static float density;
	static float area = 0;
	static float areaframe;
	
	public static double calculate(ArrayList<widget> rectXY, int frameWidth, int frameHeight) {
		double value = 0;
		areaframe=0;
		area=0;
		
		for(int i=0; i<rectXY.size(); i++){
			widget data =  rectXY.get(i); 
			if(data.getX()!=0 || data.getY()!=0)
			{
				area += data.getWidth()*data.getHeight();
			}
			
			areaframe = frameWidth*frameHeight;
		
			value = area/areaframe;
		
		}
		
		return value;

	}
	
}
	
