package labs.lab6;

/**
 * A customer that is represented by a name, amount spent, and type
 */
public class Customer {

	private String name;
	private double spent;
	private CustomerType type;

	public static enum CustomerType {
		CORPORATE, PERSONAL
	};

	/**
	 * Constructs a bank account with a name, amount spent, and customer type
	 * 
	 * If amountSpent < 0, sets it to 0
	 */
	public Customer(String name, double amountSpent, CustomerType custType) {
		this.name = name;
		this.spent = Math.max(0, amountSpent);
		this.type = custType;
	}


	/**
	 * Gets the name of the customer.
	 * 
	 * @return the name of the customer
	 */
	public String getName() {
		return name;
	}


	/**
	 * Gets the amount spent by the customer.
	 * 
	 * @return the amount spent by the customer
	 */
	public double getAmountSpent() {
		return spent;
	}


	/**
	 * Sets amountSpent to the new amount
	 * 
	 * If amountSpent < 0, sets it to 0
	 * 
	 * @param amountSpent the new amount spent
	 */
	public void setAmountSpent(double amountSpent) {
		spent = Math.max(0, amountSpent);
	}


	/**
	 * Gets the customer type of the customer.
	 * 
	 * @return the customer type of the customer
	 */
	public CustomerType getCustomerType() {
		return type;
	}


	/**
	 * Sets customer type to the new type
	 * 
	 * @param custType the new customer type
	 */
	public void setCustomerType(CustomerType custType) {
		type = custType;
	}


	/**
	 * Returns a string representation of this Customer, consisting of the name,
	 * amount spent, and customer type, each separated by a comma and one space
	 */
	@Override
	public String toString() {
		String t = "Personal";
		if (type.equals(CustomerType.CORPORATE)) {
			t = "Corporate";
		}
		return name + ", " + spent + ", " + t;
	}


	/**
	 * Returns true if the name, amount spent, and type are equal to this customer,
	 * false otherwise
	 */
	@Override
	public boolean equals(Object otherObj) {
		Customer oth = (Customer)otherObj;
		if (this.name.equals(oth.name) && this.spent == oth.spent && this.type.equals(oth.type)) {
			return true;
		}
		return false;
	}

}
