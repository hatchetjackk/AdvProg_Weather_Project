package weather;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class WeatherWin extends JFrame {
	static JTextArea outputArea = new JTextArea();
	
	static String outputString = "";
	
	/* Output window */
	
	public void createKybdOutputWin() throws IOException {
	   
	JFrame kybdEntryFrame = new JFrame();
	kybdEntryFrame.setSize(625, 500);
	kybdEntryFrame.setTitle("Weather Data");

	JPanel kybdEntryPanel = new JPanel();
  
	kybdEntryPanel.setSize(625, 500);
	kybdEntryPanel.setBackground(Color.WHITE);
	kybdEntryFrame.add(kybdEntryPanel);
	kybdEntryFrame.setVisible(true);
  
  
	JTextArea titleArea = new JTextArea();
	titleArea.setEditable(false);
	titleArea.setFont(new Font("Arial", Font.BOLD, 16));
  
	String titleString = "\n  Weather Output Data  \n";
	titleArea.setText(titleString);
	titleArea.setSize(625, 35);
	kybdEntryPanel.add(titleArea);
  
   
	// set up the column headers
	JTextArea headerArea1 = new JTextArea();
	headerArea1.setFont(new Font("Arial", Font.BOLD, 11));  // set the font
      
	String headerString1 = ("         Temperature          Wind Speed              Dew Point             Wind Chill             Cloud Base\n"
	+ "__________________________________________________________________________________");
    
	/*** How to add data to this part? ***/
	
	headerArea1.setText(headerString1);
	headerArea1.setSize(600, 25);
	kybdEntryPanel.add(headerArea1);    
  
	kybdEntryPanel.add(outputArea);
	outputArea.setSize(625, 60);
	kybdEntryFrame.add(kybdEntryPanel);
	//kybdEntryFrame.toBack();    // put it behind main window
	outputArea.setFont(new Font("Arial", Font.BOLD, 12));  // set the font
	
	}
}// end of createKybdOutputWin
