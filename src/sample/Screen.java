/*
	* Angel Molina
	* 10/30/19
	* Class created and used by MoviePlayer Class
	*/

package sample;

public class Screen implements ScreenSpec {
		private String resolution;
		private int refreshrate, responsetime;

		public Screen(String resolution, int refreshrate, int responsetime) {
				this.resolution = resolution;
				this.refreshrate = refreshrate;
				this.responsetime = responsetime;
		}

		// getter methods
		public String getResolution() {
				return resolution;
		}
		public int getRefreshRate() {
			return refreshrate;
		}
		public int getResponseTime() {
				return responsetime;
		}
		// end getter methods

		public String toString()
		{
				return "Resolution " + getResolution()
					+ "\nRefresh Rate: " + getRefreshRate()
					+ "Hz\nResponse Time: " + getResponseTime()
					+ " ms";
		} // end toString

} // end class Screen
