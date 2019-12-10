package sample;

public class AudioPlayer extends Product implements MultimediaControl{
	private String audioSpecification;
		private String mediaType;

	public AudioPlayer(String name, String manufacturer, String audioSpecification) {
		super(name, manufacturer, sample.ItemType.AU);
		this.audioSpecification = audioSpecification;
	} // end constructor

		// Methods implemented from MultimediaControl
		public void play() {
			System.out.println("Playing");
		}
		public void stop() {
				System.out.println("Stopped");
		}
		public void previous() {
				System.out.println("Previous");
		}
		public void next() {
				System.out.println("Next");
		}

		public String toString() {
			return super.toString() + "\nAudio Spec: " + audioSpecification;
		} // end method toString



} // end class AudioPlayer
