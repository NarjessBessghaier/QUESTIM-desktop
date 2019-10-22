package metrics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;






/**
 * @author NarjesBessghaier
 */
public class main extends JFrame{
	 static JButton browse,eval;
	 static JFrame frame ;
	public static JTextField Field;
	public static JTextField xlspath,balancet,Alignmentt,CenterAlignmentt,Concentricityt,Densityt,Simplicityt,nbelements,complex;
	 public static final Color Gold = new Color(255,204,51);
	 public main() {
	 
	
		//Create and set up the window.
	frame	 = new JFrame("QUESTIM for desktop");
	       
	   // GridLayout dumppath = new GridLayout(1,1);
	 JPanel englobe = new JPanel();
	 englobe.setLayout(new BoxLayout(englobe,BoxLayout.Y_AXIS));
	 
	    JPanel text = new JPanel();
	   // frame.add(text, BorderLayout.NORTH);
	    //text.setLayout(dumppath);
	    JLabel first = new JLabel ("Enter the DumpFile path:");
	    text.add(first);
		
	    JPanel path = new JPanel();
	    GridLayout dumppath1 = new GridLayout(1,2);
	    path.setLayout(dumppath1);
		Field= new JTextField("",30);
		Field.setEditable(false);
		
			browse= new JButton("Browse");
		
			browse.addActionListener(new selectFile());
			path.add(Field);
			path.add(browse);	
			
			JPanel btns = new JPanel();
		    GridLayout dumppath2 = new GridLayout(1,2);
		    path.setLayout(dumppath2);
			JButton Compute= new JButton("Extract Widgets");
			Compute.addActionListener(new parser());
			JButton WV= new JButton("Extract Widgets&Views");
			WV.addActionListener(new parserWV());
			btns.add(Compute);
			btns.add(WV);
			JPanel start = new JPanel();
		    GridLayout dumppath3 = new GridLayout(1,1);
			eval= new JButton("Start evaluating");
			eval.addActionListener(new evaluate());
			eval.setEnabled(false);
			start.add(eval);
			 xlspath= new JTextField("Excel file path...");
			 xlspath.setEditable(true);
			
			englobe.add(text);
			 englobe.add(path);
			 englobe.add(btns);
			 englobe.add(start);
			 englobe.add(xlspath);
			 
			frame.add(englobe, BorderLayout.NORTH);
     JPanel metrics = new JPanel();
     frame.add(metrics);
   
     JLabel balance= new JLabel("Balance");
     JLabel Alignment= new JLabel("Alignment");
     JLabel CenterAlignment= new JLabel("CenterAlignment");
     JLabel Concentricity= new JLabel("Concentricity");
     JLabel Density= new JLabel("Density");
     JLabel Simplicity= new JLabel("Simplicity");
     JLabel nbelement= new JLabel("Nb-Elements");
     
     balancet= new JTextField("",5);
     balancet.setEditable(false);
     Alignmentt= new JTextField("",5);
     Alignmentt.setEditable(false);
     CenterAlignmentt= new JTextField("",5);
     CenterAlignmentt.setEditable(false);
     Concentricityt= new JTextField("",5);
     Concentricityt.setEditable(false);
     Densityt= new JTextField("",5);
     Densityt.setEditable(false);
     Simplicityt= new JTextField("",5);
     Simplicityt.setEditable(false);
     nbelements= new JTextField("",5);
     nbelements.setEditable(false);
   
		
     
     metrics.setLayout(new GridBagLayout());
    // metrics.setBackground(Color.green);
     frame.getContentPane().add(metrics);
     GridBagConstraints left = new GridBagConstraints();
     left.anchor = GridBagConstraints.EAST;
     GridBagConstraints right = new GridBagConstraints();
     right.weightx = 2.0;
     right.fill = GridBagConstraints.HORIZONTAL;
     right.gridwidth = GridBagConstraints.REMAINDER;
     metrics.add(balance, left);
     metrics.add(balancet, right);
     metrics.add(Alignment, left);
     metrics.add(Alignmentt, right);
     metrics.add(CenterAlignment, left);
     metrics.add(CenterAlignmentt, right);
     metrics.add(Concentricity, left);
     metrics.add(Concentricityt, right);
     metrics.add(Density, left);
     metrics.add(Densityt, right);
     metrics.add(Simplicity, left);
     metrics.add(Simplicityt, right);
     metrics.add(nbelement, left);
     metrics.add(nbelements, right);
     metrics.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
     

     JPanel result = new JPanel();
     frame.add(result, BorderLayout.SOUTH);
     
     JLabel Complexity= new JLabel("Layout Complexity");
      complex= new JTextField("",5);
     complex.setEditable(false);
     result.setLayout(new GridBagLayout());
     result.setBackground(Color.GRAY);
     frame.getContentPane().add(metrics);
     GridBagConstraints left1 = new GridBagConstraints();
     left.anchor = GridBagConstraints.EAST;
     GridBagConstraints right1 = new GridBagConstraints();
     right1.weightx = 2.0;
     right1.fill = GridBagConstraints.HORIZONTAL;
     right1.gridwidth = GridBagConstraints.REMAINDER;
     result.add(Complexity, left1);
     result.add(complex, right1);
  
     result.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
     
     
     frame.setSize(350,420);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setLocationRelativeTo(null);
     //Display the window.
    // frame.pack();
     frame.setVisible(true);
		
	 } 
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		 
		new main();
	}


//######## Browse button
	class selectFile implements ActionListener { 
		public void actionPerformed(ActionEvent Event) { 
		
	        
	        JFileChooser fc = new JFileChooser();
             fc.setBounds(100, 100, 100, 100);
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.uix", "uix");
	        fc.setFileFilter(filter);
	       // fc.addChoosableFileFilter(new FileNameExtensionFilter("*.uix", "uix"));
          fc.setCurrentDirectory(new java.io.File("/Desktop"));
          fc.setDialogTitle("File Browser...");
          
          fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
         
          if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION){
        	  Field.setText(fc.getSelectedFile().getAbsolutePath());
          }
	        
	        
	        
		}

	}	
	class parser implements ActionListener {  
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent Event) { 
			Widgets.OnlyWidgets parsernative = new 	Widgets.OnlyWidgets(); 
			if (!Field.getText().equals(""))
				{
				eval.setEnabled(true);
				try {
					parsernative.main(new String[]{});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			else {
				String message="<html><body><font color=\"red\">Choose a file before starting the parsing operation!</font></body></html>";
    			
    			JOptionPane.showMessageDialog(null,"Warning!!!"+ ""+"\n"+"\n"+message);
			}	
		}
		
	}	
	
	class parserWV implements ActionListener {  
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent Event) { 
			Widgets_Views.nativeApps parsernativeWV = new 	Widgets_Views.nativeApps(); 
			if (!Field.getText().equals(""))
				{
				eval.setEnabled(true);
				try {
					parsernativeWV.main(new String[]{});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			else {
				String message="<html><body><font color=\"red\">Choose a file before starting the parsing operation!</font></body></html>";
    			
    			JOptionPane.showMessageDialog(null,"Warning!!!"+ ""+"\n"+"\n"+message);
			}	
		}
		
	}
	
	class evaluate implements ActionListener {  
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent Event) { 
			metrics.Metric main = new 	metrics.Metric(); 	
			try {
				main.main(new String[]{});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
	
	
	
	
	
	
	
	
	
}