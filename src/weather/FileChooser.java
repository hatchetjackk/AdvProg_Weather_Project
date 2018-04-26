package weather;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileChooser {

	public void main() throws FileNotFoundException {
		File dir = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Choose a weather data file.");
		fc.setCurrentDirectory(dir);
		int status = fc.showOpenDialog(null);
		try {
			if (status != JFileChooser.APPROVE_OPTION) {
				return;
			} else {
				File f = fc.getSelectedFile();
				@SuppressWarnings({ "unused", "resource" })
				Scanner s = new Scanner(f);
				@SuppressWarnings("unused")
				StringBuilder i = new StringBuilder();
			} 
		} finally {
				
			}
		}
	
	public static void createManWeather() throws IOException {
		// create weather_data.txt
		File f = new File("weather_data.txt");
		
		if (f.createNewFile()) {
			System.out.println("File created!");
		} else {
			System.out.println("File already exists!");
		}
		
	}
	
	/*
	*public void writeTo(Double t, Double w, Double d, Double wc, Double cb) throws IOException {
	*	FileWriter f = new FileWriter("weather_data.txt");
	*	
	*	
	*}
	*/	

	}
