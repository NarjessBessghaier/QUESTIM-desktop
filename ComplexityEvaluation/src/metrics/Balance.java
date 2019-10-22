package metrics;

import java.util.ArrayList;




import metrics.Region.widget;

/**
 * @author Mathiew ZEN
 */
public class Balance extends Metric {

	
	public static double calculate(ArrayList<widget> rectXY, int frameWidth, int frameHeight) {
		
		double [][] belonging = new double [rectXY.size()][4];
		double [] a = new double [rectXY.size()];
		double value = 0.0;
		
		double BMvert;
		double BMhori;
		
		double amax = 0;
		
		double wl = 0;
		double wr = 0;
		double wt = 0;
		double wb = 0;
		
		for(int i=0;i<rectXY.size();i++){
			
			widget data =  rectXY.get(i); 
			
			
			a[i] = (double)data.getWidth()* (double)data.getHeight();
			if(a[i]>amax){
				amax = a[i];
			}
			
			
			//Belonging tests
			//UL
			
			if((data.getX() < frameWidth/2) && (data.getX()+data.getWidth() > frameWidth/2) && (data.getY() < frameHeight/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][0] = ((double)(frameWidth/2 - data.getX())  * (frameHeight/2 - data.getY()))/(data.getWidth()*data.getHeight());
			}
			
			else if((frameWidth/2 - data.getX() < data.getWidth()) && (frameHeight/2 - data.getY() > data.getHeight()))
			{
				belonging[i][0] = ((double)(frameWidth/2 - data.getX())/(data.getWidth()));
			}
			
			else if((frameWidth/2 - data.getX() > data.getWidth()) && (frameHeight/2 - data.getY() < data.getHeight()))
			{
				belonging[i][0] = ((double)(frameHeight/2 - data.getY())/(data.getHeight()));
			}
			
			else if((frameWidth/2 - data.getX() > data.getWidth()) && (frameHeight/2 - data.getY() > data.getHeight()))
			{
				belonging[i][0] = 1;
			}
			
			//UR
						
			if((data.getX() < frameWidth/2) && (data.getX()+data.getWidth() > frameWidth/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][1] = ((double)(data.getX()+data.getWidth()  - frameWidth/2)  * (frameHeight/2 - data.getY()))/(data.getWidth()*data.getHeight());
			}
			
			else if((data.getX()+data.getWidth() > frameWidth/2) && (data.getY()+data.getHeight() < frameHeight/2))
			{
				belonging[i][1] = ((double)(data.getX()+data.getWidth()  - frameWidth/2)/(data.getWidth()));
			}
			
			else if((data.getX() > frameWidth/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][1] = ((double)(frameHeight/2 - data.getY())/(data.getHeight()));
			}
			
			if((data.getX() > frameWidth/2) && (data.getY()+data.getHeight() < frameHeight/2))
			{
				belonging[i][1] = 1;
			}
			
			//LL
			
			if((data.getX() < frameWidth/2) && (data.getX()+data.getWidth() > frameWidth/2) && (data.getY() < frameHeight/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][2] = ((double)(frameWidth/2 - data.getX())  * (data.getY()+data.getHeight() - frameHeight/2))/(data.getWidth()*data.getHeight());
			}
			
			else if((data.getX() < frameWidth/2) && (data.getX()+data.getWidth() < frameWidth/2) && (data.getY() < frameHeight/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][2] = ((double)(data.getY()+data.getHeight()-frameHeight/2)/(data.getHeight()));
			}
			
			else if((data.getX() < frameWidth/2) && (data.getX()+data.getWidth() > frameWidth/2) && (data.getY() > frameHeight/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][2] = ((double)(frameWidth/2 - data.getX())/(data.getWidth()));
			}
			
			else if((data.getX() < frameWidth/2) && (data.getX()+data.getWidth() < frameWidth/2) && (data.getY() > frameHeight/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][2] = 1;
			}
			
			//LR
			if((data.getX() < frameWidth/2) && (data.getX()+data.getWidth() > frameWidth/2) && (data.getY() < frameHeight/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][3] = ((double)(data.getX()+data.getWidth()  - frameWidth/2)  * (data.getY()+data.getHeight() - frameHeight/2))/(data.getWidth()*data.getHeight());
			}
			
			else if((data.getX() > frameWidth/2) && (data.getX()+data.getWidth() > frameWidth/2) && (data.getY() < frameHeight/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][3] = ((double)(data.getY()+data.getHeight()-frameHeight/2)/(data.getHeight()));
			}
			
			else if((data.getX() < frameWidth/2) && (data.getX()+data.getWidth() > frameWidth/2) && (data.getY() > frameHeight/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][3] = ((double)(data.getX()+data.getWidth()-frameWidth/2)/(data.getWidth()));
			}
			
			else if((data.getX() > frameWidth/2) && (data.getX()+data.getWidth() > frameWidth/2) && (data.getY() > frameHeight/2) && (data.getY()+data.getHeight() > frameHeight/2))
			{
				belonging[i][3] = 1;
			}
			
			for(int j=0; j<4; j++){
				if(belonging[i][j]<0){
					belonging[i][j]=0;
				}
			}
			
			
			if(belonging[i][0] == 1 || belonging[i][1] == 1 || belonging[i][2] == 1 || belonging [i][3] == 1)
			{
			wl += belonging[i][0]*(1+(frameWidth/2 - (data.getX()+data.getWidth()/2))/frameWidth/2)*(a[i]/amax)+belonging[i][2]*(1+(frameWidth/2 - (data.getX()+data.getWidth()/2))/frameWidth/2)*(a[i]/amax);
			wr += belonging[i][1]*(1+((data.getX()+data.getWidth()/2) - frameWidth/2)/frameWidth/2)*(a[i]/amax)+belonging[i][3]*(1+((data.getX()+data.getWidth()/2) - frameWidth/2)/frameWidth/2)*(a[i]/amax);
			wt += belonging[i][0]*(1+(frameHeight/2 - (data.getY()+data.getHeight()/2))/frameHeight/2)*(a[i]/amax)+belonging[i][1]*(1+(frameHeight/2 - (data.getY()+data.getHeight()/2))/frameHeight/2)*(a[i]/amax);
			wb += belonging[i][2]*(1+((data.getY()+data.getHeight()/2) - frameHeight/2)/frameHeight/2)*(a[i]/amax)+belonging[i][3]*(1+((data.getY()+data.getHeight()/2) - frameHeight/2)/frameHeight/2)*(a[i]/amax);
			}
			else
			{
			wl += belonging[i][0]*(a[i]/amax)+belonging[i][2]*(a[i]/amax);
			wr += belonging[i][1]*(a[i]/amax)+belonging[i][3]*(a[i]/amax);
			wt += belonging[i][0]*(a[i]/amax)+belonging[i][1]*(a[i]/amax);
			wb += belonging[i][2]*(a[i]/amax)+belonging[i][3]*(a[i]/amax);
			}
			
		}
			
			
			BMvert = (wl-wr)/Math.max(wl,wr);
			BMhori = (wt-wb)/Math.max(wt,wb);
			
			value = 1-(Math.abs(BMvert)+Math.abs(BMhori))/2;
			
			//Window.alert("LEFT: "+wl+"\n RIGHT "+wr+"\n TOP: "+wt+"\n BOTTOM: "+wb);
			
		
		return value;
	}

	
	}

