package weather;

import java.io.IOException;

public class OutputWindow {

	public static void main(String[] args) {
		
	}
	
	public static void launch() {
		WeatherWin w = new WeatherWin();
		try {
			w.createKybdOutputWin();
		} catch (IOException e) {
			e.printStackTrace();
			}
		
		}
	
}
