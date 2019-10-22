package metrics;


import java.util.ArrayList;

/**
 * @author NarjesBessghaier
 */
 class Region {
	public static ArrayList<widget> list=new ArrayList<>();
	 class widget
	 {
			String id, name;
			public int x1 = 0, y1 = 0, width = 0, height = 0;

	
			public widget clone(){
				widget r = new widget(getX1(),y1,width,height);
				
				return r;
			}
	
	 widget (int x, int y, int width, int height){
		this.setX1(x);
		this.y1 = y;
		this.width = width;
		this.height = height;
		
	}
	public int getX(){
		return getX1();
	}
	public int getY(){
		return y1;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	public void setX(int x){
		this.setX1(x);
	}
	public void setY(int y){
		this.y1 = y;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}
	 }
	public void addValues(int[] x, int[] y, int[] width, int[] height) {
		// TODO Auto-generated method stub
		 
		for (int i = 0; i < NbElements.rowTotal; i++) 
        { 
            list.add(new  widget(x[i], y[i], width[i], 
                                              height[i])); 
        } 
		printValues(list); 
        
  	
	}

	private void printValues(ArrayList<widget> list) {
		// TODO Auto-generated method stub
		
			for (int i = 0; i < list.size(); i++) 
	        {
				widget data = list.get(i); 
	  
	           // System.out.println(data.x1+" "+data.y1+data.width+" "+data.height); 
		}

		}
	


	
	
	
}
