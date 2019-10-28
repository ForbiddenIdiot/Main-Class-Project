package sample;

abstract class Product implements Item {
	// fields
	private int id;
	private String type;
	private String manufacturer;
	private String name;

		Product(String name) {
				this.name = name;
		}

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

		public String toString()
		{
				return "Name: " + getName()
					+ "\nManufacturer: " + getManufacturer()
					+ "\nType: " + type;
		}
}
