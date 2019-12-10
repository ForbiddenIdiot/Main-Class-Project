package sample;

abstract class Product implements Item {
	// fields
	private int id;
	private Enum ItemType;
	private String manufacturer;
	private String name;

		Product(String name, String manufacturer, Enum ItemType) {
				// constructor
				this.name = name;
				this.manufacturer = manufacturer;
				this.ItemType = ItemType;
		} // end constructor

		// getters and setters
		public int getId() { // returns id
				return id;
		}

		public void setName(String newName) {
				// sets name to newName
			name = newName;
		}

		public String getName() {
				// returns name
				return name;
		}

		public void setManufacturer(String manu) {
			// sets manufacturer to manu
				manufacturer = manu;
		}

		public String getManufacturer() {
				// returns manufacturer
				return manufacturer;
		}
		// end getters and setters

		public String toString()
		{
				return "\nName: " + getName()
					+ "\nManufacturer: " + getManufacturer()
					+ "\nType: " + ItemType + "\n";
		} // end method toString
}
