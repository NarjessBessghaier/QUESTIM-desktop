package metrics;


import java.util.ArrayList;
/**
 * @author Mathiew ZEN
 */
public class RegionTree {
	public RegionNode root;
	
	public RegionTree(){
		
	}
	
	public RegionTree(Region r){
		root = new RegionNode(r);
	}
	
	public RegionNode getRoot(){
		return root;
	}
	
	public RegionNode setRoot(Region r){
		root = new RegionNode(r);
		return root;
	}
}


	
