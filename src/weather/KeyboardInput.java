package weather;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class KeyboardInput {

	public static void main(String[] args) {
		
	}
	
	public void fields() {
		double wc = 0; //windchill
		double cb = 0; //cloudbase
		
		/* create lists to store input */
		List<Double> tempA = new ArrayList<Double>();
		List<Double> windA = new ArrayList<Double>();
		List<Double> dewA = new ArrayList<Double>();
		List<Double> chillA = new ArrayList<Double>();
		List<Double> cloudA = new ArrayList<Double>();
		
		while (true) {
			/* input fields */
			JTextField temp = new JTextField(5);
			JTextField wind = new JTextField(5);
			JTextField dew = new JTextField(5);
			
			Object[] fields = { 
					"Temperature (F)", temp,
					"Wind Speed (MPH)", wind,
					"Dew Point (F)", dew
			};
			
			Object[] options = {
					"Calculate",
					"Back",
					"Cancel"
			};
			
			int n = JOptionPane.showOptionDialog(null,
					fields, 
					"Weather Data Calculator",
					JOptionPane.PLAIN_MESSAGE, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					options, 
					options[0]);
			
			/* Add exceptions for non-integer inputs */
			if (n == 0) {
				/* one-liners for getting text from forms and parsing to doubles */
				Double t = parser(temp.getText());
				Double w = parser(wind.getText());
				Double d = parser(dew.getText());
				
				if (t > 50 && w < 3) {
					JOptionPane.showConfirmDialog(null,
							"Please choose a temperature below 50F and a wind speed above 3 MPH.", 
							"Error",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);
				} else if ( t > 50) {
					JOptionPane.showConfirmDialog(null,
							"Please choose a temperature below 50F.", 
							"Error",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);
				} else if (w < 3 ) {
					JOptionPane.showConfirmDialog(null,
							"Please choose a wind speed above 3 MPH.",
							"Error",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);
				} else {
					wc = windChill(t, w, d);
					cb = cloudBase(t, w, d);
					
					/* add data to lists */
					/* how to add this to the JPanel? */
					tempA.add(t);
					windA.add(w);
					dewA.add(d);
					chillA.add(wc);
					cloudA.add(cb);
					
					/* debug lists */
					System.out.println(tempA);
					System.out.println(windA);
					System.out.println(dewA);
					System.out.println(chillA);
					System.out.println(cloudA);
				}	
				
			} else if (n == 1 ) {
				Main.select();
			} else {
				System.exit(0);
			}	
		}
	}
	
/*** begin supporting methods ***/
	
	public static Double parser(String x) {
		// parse string inputs to doubles
		Double y = Double.parseDouble(x);
		return y;
	}
	
	public static Double windChill(Double td, Double wd, Double dd) {
		// calculate wind chill
		Double windChill = 35.74 + 0.6215 * td - 35.75 * Math.pow(wd,0.15) + 0.4275 * td * Math.pow(wd,0.15);
		return windChill;
	}
	
	public static Double cloudBase(Double td, Double wd, Double dd) {
		// calculate cloud base
		Double cloudBase = (td - dd) / (4.4 * 1000);
		return cloudBase;
	}

}
