package metrics;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author NarjesBessghaier
 */
public class Metric {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
	
	
	NbElements DN= new NbElements();
	double NbElements=DN.NbElements();
	metrics.main.nbelements.setText(Double.toString(NbElements));
	if (NbElements<=0.4)
		{metrics.main.nbelements.setBackground(Color.GREEN);}
	else if (NbElements>0.4 & NbElements<=0.6)
	{metrics.main.nbelements.setBackground(Color.YELLOW);}
	else {metrics.main.nbelements.setBackground(Color.RED);}
	//System.out.println("heree");
	MainQUESTIM Region1= new MainQUESTIM();
	Region1.main(new String[]{});
	
	Concentricity CN= new Concentricity();
	double Concentricity=CN.calculate(Region.list,MainQUESTIM.frameWidth,MainQUESTIM.frameHeight);
	metrics.main.Concentricityt.setText(Double.toString(Concentricity));
	
	if (Concentricity<=0.5)
	{metrics.main.Concentricityt.setBackground(Color.GREEN);}
else if (Concentricity>0.5 & Concentricity<=0.8)
{metrics.main.Concentricityt.setBackground(Color.YELLOW);}
else {metrics.main.Concentricityt.setBackground(Color.RED);}
	
	Alignment AN= new Alignment();
	double Alignment=AN.calculate(Region.list);
	metrics.main.Alignmentt.setText(Double.toString(Alignment));
	
	if (Alignment<0.2)
	{metrics.main.Alignmentt.setBackground(Color.RED);}
else if (Alignment>=0.2 & Alignment<0.5)
{metrics.main.Alignmentt.setBackground(Color.YELLOW);}
else {metrics.main.Alignmentt.setBackground(Color.GREEN);}
	
	Balance BM= new Balance();
	double Balance=BM.calculate(Region.list,MainQUESTIM.frameWidth,MainQUESTIM.frameHeight);
	metrics.main.balancet.setText(Double.toString(Balance));
	
	if (Balance<0.5)
	{metrics.main.balancet.setBackground(Color.RED);}
else if (Balance>=0.5 & Balance<0.8)
{metrics.main.balancet.setBackground(Color.YELLOW);}
else {metrics.main.balancet.setBackground(Color.GREEN);}
	
	
	CenterAlignment CA= new CenterAlignment();
	double CenterAlignment=CA.calculate(Region.list);
	metrics.main.CenterAlignmentt.setText(Double.toString(CenterAlignment));
	
	if (CenterAlignment<0.2)
	{metrics.main.CenterAlignmentt.setBackground(Color.RED);}
else if (CenterAlignment>=0.2 & CenterAlignment<0.5)
{metrics.main.CenterAlignmentt.setBackground(Color.YELLOW);}
else {metrics.main.CenterAlignmentt.setBackground(Color.GREEN);}
	
	Density DM= new Density();
	double Density=DM.calculate(Region.list,MainQUESTIM.frameWidth,MainQUESTIM.frameHeight);
	metrics.main.Densityt.setText(Double.toString(Density));
	
	if (Density<0.2)
	{metrics.main.Densityt.setBackground(Color.GREEN);}
else if (Density<=0.2&Density<0.8)
{metrics.main.Densityt.setBackground(Color.YELLOW);}
else {metrics.main.Densityt.setBackground(Color.RED);}
	
	Simplicity SM= new Simplicity();
	double Simplicity=SM.calculate(Region.list,MainQUESTIM.frameWidth,MainQUESTIM.frameHeight);
	metrics.main.Simplicityt.setText(Double.toString(Simplicity));
	
	if (Simplicity<0.5)
	{metrics.main.Simplicityt.setBackground(Color.GREEN);}
else if (Simplicity<=0.5&Simplicity<0.8)
{metrics.main.Simplicityt.setBackground(Color.YELLOW);}
else {metrics.main.Simplicityt.setBackground(Color.RED);}
	
	
	double complexity= (Simplicity+Density+CenterAlignment+Balance+Alignment+Concentricity+NbElements)/7;
	metrics.main.complex.setText(Double.toString(complexity));
	
	if (complexity<0.4)
	{metrics.main.complex.setBackground(Color.GREEN);}
else if (complexity<=0.4&complexity<0.5)
{metrics.main.complex.setBackground(Color.YELLOW);}
else {metrics.main.complex.setBackground(Color.RED);}
	
	
	
}}
