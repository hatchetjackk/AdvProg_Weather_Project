package weather;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) throws IOException {
		FileChooser.createManWeather();
		OutputWindow.launch();
		select();
	}

	public static void select() {
		
		/* add options for selection window */
		Object[] options = {
				"Keyboard Input",
				"File Input",
				"Quit"
		};
		
		/* selection window */
		int n = JOptionPane.showOptionDialog(null, 
				"Select Data Input Source",
				"Weather Data Calculator",
				JOptionPane.PLAIN_MESSAGE,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
		
		/* option inputs */
		if (n == 0 ) {
			KeyboardInput k = new KeyboardInput();
			k.fields();
		} else if (n == 1) {
			FileChooser f = new FileChooser();
			try {
				f.main();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else  if (n == 2) {
			System.exit(0);
		}
	}
}
