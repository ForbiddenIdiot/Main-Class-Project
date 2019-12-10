/*
	* Angel Molina
	* 10/30/19
	* Contains specs for a movie player
	*/

package sample;

public class MoviePlayer extends Product implements MultimediaControl {
		private Screen screen;
		private Enum MonitorType;

		MoviePlayer(String name, String manufacturer, Screen screen, Enum MonitorType) {
				super(name, manufacturer, sample.ItemType.VI);
				this.screen = screen;
				this.MonitorType = MonitorType;
		}

		// Methods implemented from MultimediaControl
		public void play() {
				System.out.println("Playing");
		}
		public void stop() {	System.out.println("Stopped"); }
		public void previous() { System.out.println("Previous"); }
		public void next() { System.out.println("Next"); }
		// end methods implemented from MultimediaControl

		public String toString()
		{
				return "\n\fdasfs" +
						"aadsfdsnName: " + getName()
					+ "\nScreen: " + screen.toString()
					+ "\nMonitor Type: " + MonitorType;
		} // end method toString

} // end class MoviePlayer
